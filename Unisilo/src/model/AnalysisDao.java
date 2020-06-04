package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalysisDao extends BaseDao {


	//★★Mapを使って取得したデータを返すことにしましょう。
	public Map<String,Integer> getCalculationResult(AnalysisDto dto) {
		Map<String,Integer> results = new HashMap<String,Integer>();


		  //★★★★★★ここから次の★★★★★★まではDaoに入れるべき内容になると思います。
				// DBへ保存処理
				Connection con = null;
				Statement smt = null;

				try {
					Class.forName(DRIVER_NAME);

					//コネクション作成
					con = DriverManager.getConnection(JDBC_URL, USER_ID , USER_PASS);
					smt = con.createStatement();

					//SQL実行
					String sumsSQL= "SELECT SUM(items.price) as uriage, "
							+ "SUM(items.price-items.cost) as rieki "
							+ "FROM sales_records "
							+ "JOIN items "
							+ "ON sales_records.item_id=items.id "
							+ "JOIN users "
							+ "ON sales_records.user_id=users.id "
							+ "WHERE purchased_at BETWEEN '" + dto.getDateStart() + "' and '" + dto.getDateEnd()
							+ "' and items.id = " + dto.getItemID()  ;
					if( dto.getUserGender() == 1 || dto.getUserGender() == 2 ) {
						sumsSQL = sumsSQL + " and users.gender in(" + dto.getUserGender() + ")";
					}
					if( dto.getUserAge() != "0" ) {
						dto.checkAge();
						sumsSQL = sumsSQL + " and users.age BETWEEN " + dto.age1 + " and " + dto.age2 ;
					};


					ResultSet sums = smt.executeQuery( sumsSQL ) ;

					while(sums.next()) {
						results.put("uriage", sums.getInt("uriage"));
						results.put("rieki", sums.getInt("rieki"));
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
