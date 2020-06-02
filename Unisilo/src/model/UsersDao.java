package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**----------------------------------------------------------------------*
 *■■■UsersDaoクラス■■■
 *概要：DAO
 *----------------------------------------------------------------------**/
//★★データベースへの接続情報は親クラスBaseDaoに持たせる。
public class UsersDao extends BaseDao{
	/**----------------------------------------------------------------------*
	 *■doInsertメソッド
	 *概要　：「survey」テーブルに対象のデータを挿入する
	 *引数　：対象のデータ（Dto型）
	 *戻り値：実行結果（真：成功、偽：例外発生）
	 *----------------------------------------------------------------------**/
        public boolean doInsert(UsersDto dto) {

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
			buf.append(" INSERT INTO users (");
			buf.append("     name  ,             ");
			buf.append("     gender  ,             ");
			buf.append("     age           ");
			buf.append("      )VALUES(              ");
			buf.append("         ? ,                ");
			buf.append("         ? ,                ");
			buf.append("         ?                  ");
			buf.append("      )                     ");

			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());

			//パラメータをセット
			ps.setString(    1, dto.getName()              ); //第1パラメータ：更新データ
			ps.setInt(    2, dto.getGender()               ); //第2パラメータ：更新データ
			ps.setInt(    3, dto.getAge()               ); //第3パラメータ：更新データ

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


}

