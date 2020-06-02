package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ItemsDao extends BaseDao{

        public boolean doInsert(ItemsDto dto) {

		Connection        con = null ;
		PreparedStatement psmt  = null ;

		boolean isSuccess = true ;

		try {
			con = this.getConnection();
			//トランザクションの開始
			//オートコミットをオフにする（トランザクション開始）
			con.setAutoCommit(false);

			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append(" INSERT INTO items (");
			buf.append("     name  ,             ");
			buf.append("     gender  ,             ");
			buf.append("     price  ,             ");
			buf.append("     cost           ");
			buf.append("      )VALUES(              ");
			buf.append("         ? ,                ");
			buf.append("         ? ,                ");
			buf.append("         ? ,                ");
			buf.append("         ?                  ");
			buf.append("      )                     ");

			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			psmt = con.prepareStatement(buf.toString());

			//パラメータをセット
			psmt.setString(    1, dto.getName()              );
			psmt.setInt(    2, dto.getGender()               );
			psmt.setInt(    3, dto.getPrice()               );
			psmt.setInt(    4, dto.getCost()               );

			//SQL文の実行
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false ;
		} finally {

			if(isSuccess){
				try {
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
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
			if (psmt != null) {    //接続が確認できている場合のみ実施
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return isSuccess;
	}

}