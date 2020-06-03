package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.AnalysisDto;

public class AnalysisDao extends BaseDao {

	 public boolean doInsert(AnalysisDto dto) {
	//★★Mapを使って取得したデータを返すことにしましょう。
	public Map<String,Integer> getCalculationResult() {
		Map<String,Integer> results = new HashMap<String,Integer>();


		  //★★★★★★ここから次の★★★★★★まではDaoに入れるべき内容になると思います。
				// DBへ保存処理
				Connection con = null;
				Statement smt = null;
				ResultSet  rs  = null ;   // ResultSet（SQL抽出結果）格納用変数
				PreparedStatement ps  = null ;

				try {
					Class.forName(DRIVER_NAME);

					//コネクション作成
					con = DriverManager.getConnection(JDBC_URL, USER_ID , USER_PASS);
					smt = con.createStatement();

					//SQL実行
					StringBuffer buf = new StringBuffer();
					buf.append(" SELECT SUM(items.price) ,SUM(items.price-items.cost)           ");
					buf.append(" FROM sales_records                                             ");
					buf.append(" JOIN items                                                     ");
					buf.append("ON sales_records.item_id=items.id                               ");
					buf.append(" JOIN users                                                     ");
					buf.append(" ON sales_records.user_id=users.id                              ");
					buf.append(" WHERE purchased_at BETWEEN  ?  and  ? and items.name = '?'     ");

					if(dto.getUserGender()!=null) {
						input_analysis=input_analysis+" and users.gender in(" + dto.getUserGender() +")";
					}
					//途中
					if(userAge!=null) {
						input_analysis=input_analysis+" and users.age BETWEEN " + dto.age1 + " and " + dto.age2 ;
							}

					ps = con.prepareStatement(buf.toString());

					//パラメータをセット
					ps.setString(    1, dto.getDateStart()              );
					ps.setString(    2, dto.getDateEnd()               );
					ps.setString(    3, dto.getName()       );

					//DBから受け取る

					ResultSet rs = smt.executeQuery(input_analysis);
					//★★★★★★


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return results;
	}
				/**
			     * <p>商品一覧の取得.</p>
			     * @return 検索結果
			     */
			    public List<Map<String,Object>> getItems() {
			    	Connection con = null ;   // Connection（DB接続情報）格納用変数
			    	ResultSet items = null;
					List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();

					try {
						con = this.getConnection();
						Statement stmt = con.createStatement();
						items = stmt.executeQuery("SELECT id, name, gender FROM items");

						//★★Connectionを接続するとResultSetは使えないので、取ってすぐ戻り値用のリストに入れる。
						while(items.next()) {
							Map<String,Object> result = new HashMap<>();
							result.put("id", items.getInt("id"));
							result.put("name", items.getString("name"));
							result.put("gender", items.getInt("gender"));
							resultList.add(result);
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}

					return resultList;
			    }

	 }
}
