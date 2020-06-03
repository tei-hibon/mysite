package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SampleAnalysisDao extends BaseDao {


	//★★Mapを使って取得したデータを返すことにしましょう。
	public Map<String,Integer> getCalculationResult() {
		Map<String,Integer> results = new HashMap<String,Integer>();

		Connection con = null ;


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

}
