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
	public Map<String,Integer> getCalculationResult() {
		Map<String,Integer> results = new HashMap<String,Integer>();


		  //★★★★★★ここから次の★★★★★★まではDaoに入れるべき内容になると思います。
				// DBへ保存処理
				Connection con = null;
				Statement smt = null;
				ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数

				try {
					Class.forName(DRIVER_NAME);

					//コネクション作成
					con = DriverManager.getConnection(JDBC_URL, USER_ID , USER_PASS);
					smt = con.createStatement();

					//SQL実行
					String input_analysis = "SELECT SUM(items.price) ,SUM(items.price-items.cost) " +
							"FROM sales_records " +
							"JOIN items " +
							"ON sales_records.item_id=items.id " +
							"JOIN users " +
							"ON sales_records.user_id=users.id " +
							"WHERE purchased_at BETWEEN " + dateStart + " and " + dateEnd +
							" and items.name = '" + name + "'" ;
					if(userGender!=null) {
						input_analysis=input_analysis+" and users.gender in(" + userGender +")";
					}
					//途中
					//if(userAge!=null) {
						input_analysis=input_analysis+" and users.age BETWEEN " + age1 + " and " + age2 ;
							//}

							//";";
					//DBから受け取る

					ResultSet rs = smt.executeQuery(input_analysis);
					//★★★★★★


		try {
			con = this.getConnection();
			Statement stmt = con.createStatement();
			//★★SQLは簡略化しています。 DUALはテーブルの指定なしの意味です。
			//取得したデータは as XXを使って名前をつけてやると、のちに扱う時に便利です。
			ResultSet sums = stmt.executeQuery("SELECT 100 as uriage, 50 as rieki FROM DUAL");

			//★★取ってきたデータをMapに格納します。例え1行であっても、データを取るにはループさせる必要があります。
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

			    /**
			     * <p>購入者一覧の取得.</p>
			     * @return 検索結果
			     */
			    public List<Map<String,Object>> getUsers() {
			    	Connection con = null ;   // Connection（DB接続情報）格納用変数
			    	ResultSet users = null;
			    	List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();

					try {
						con = this.getConnection();
						Statement stmt = con.createStatement();
						users = stmt.executeQuery("SELECT id, name, gender FROM users");

						while(users.next()) {
							Map<String,Object> result = new HashMap<>();
							result.put("id", users.getInt("id"));
							result.put("name", users.getString("name"));
							result.put("gender", users.getInt("gender"));
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
