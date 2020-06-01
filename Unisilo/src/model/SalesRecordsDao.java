package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**----------------------------------------------------------------------*
 *■■■Sales_recordsDaoクラス■■■
 *概要：DAO
 *----------------------------------------------------------------------**/
//★★データベースへの接続情報は親クラスBaseDaoに持たせる。
public class SalesRecordsDao extends BaseDao{
	/**----------------------------------------------------------------------*
	 *■doInsertメソッド
	 *概要　：「survey」テーブルに対象のデータを挿入する
	 *引数　：対象のデータ（Dto型）
	 *戻り値：実行結果（真：成功、偽：例外発生）
	 *----------------------------------------------------------------------**/
        public boolean doInsert(SalesRecordsDto dto) {

		//-------------------------------------------
		//SQL発行
		//-------------------------------------------

		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数

		//実行結果（真：成功、偽：例外発生）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		boolean isSuccess = true ;

		try {

			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = this.getConnection();
			//-------------------------------------------
			//トランザクションの開始
			//-------------------------------------------
			//オートコミットをオフにする（トランザクション開始）
			con.setAutoCommit(false);


			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append(" INSERT INTO sales_records (");
			buf.append("     item_id  ,             ");
			buf.append("     user_id  ,             ");
			buf.append("     purchased_at           ");
			buf.append("      )VALUES(              ");
			buf.append("         ? ,                ");
			buf.append("         ? ,                ");
			buf.append("         ?                  ");
			buf.append("      )                     ");

			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());

			//パラメータをセット
			ps.setInt(    1, dto.getItem_id()              ); //第1パラメータ：更新データ
			ps.setInt(    2, dto.getUser_id()               ); //第2パラメータ：更新データ
			ps.setString(    3, dto.getPurchased_at()               ); //第3パラメータ：更新データ

			//SQL文の実行
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

			//実行結果を例外発生として更新
			isSuccess = false ;

		} finally {
			//-------------------------------------------
			//トランザクションの終了
			//-------------------------------------------
			if(isSuccess){
				//明示的にコミットを実施
				try {
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}else{
				//明示的にロールバックを実施
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//-------------------------------------------
			//接続の解除
			//-------------------------------------------

			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		//実行結果を返す
		return isSuccess;
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
