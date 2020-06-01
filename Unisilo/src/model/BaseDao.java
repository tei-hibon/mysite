package model;

import java.sql.Connection;
import java.sql.DriverManager;

//★★Daoは基本的にこのBaseDaoを継承することで、このクラスが持つgetConenctionを呼び出せば
//★★各ファイルに接続情報を書かなくてもデータベースに接続することができる。
public class BaseDao {
	//-------------------------------------------
	//データベースへの接続情報
	//-------------------------------------------

	//JDBCドライバの相対パス
	//※バージョンによって変わる可能性があります
	protected String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	//接続先のデータベース
	protected String JDBC_URL    = "jdbc:mysql://121.142.93.107:20621/unisilodb?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";

	//接続するユーザー名
	protected String USER_ID     = "nskensyu2020";

	//接続するユーザーのパスワード
	protected String USER_PASS   = "2020Nskensyu!";


	/**
	 * <p>MySQLサーバに接続するコネクションを返す.</p>
	 * @return コネクション
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception{
		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
	}
}
