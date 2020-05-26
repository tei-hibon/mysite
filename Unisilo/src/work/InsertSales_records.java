package work;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InsertEmployee
 */
public class InsertSales_records extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//URLの後ろに?characterEncoding=UTF-8&serverTimezone=JSTを利用しているのはバグ対策。
	//ないと文字化けが発生してエラーが起こる
	private String url = "jdbc:mysql://localhost/mysql?characterEncoding=UTF-8&serverTimezone=JST";
	private String user = "root";
	private String pw = "infonic5818";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSales_records() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 //受け取ったパラメータが文字化けしなおように文字コードの設定をする
		request.setCharacterEncoding("UTF-8");


		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String retirement = request.getParameter("retirement");
		String age = request.getParameter("age");

		try {
			//★JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		int num = 0;
		Connection conn = null;
		try {
			//★コネクションの作成
			conn = DriverManager.getConnection(url,user,pw);
			Statement stmt = conn.createStatement();
			String sql = "insert into employee(name,gender,retirement,age) "
						+ "values ('" + name + "','" + gender + "','" + retirement + "','" + age + "')";
			//★SQLの実行
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}


		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(num + "件のデータを登録しました。");
	}

}
