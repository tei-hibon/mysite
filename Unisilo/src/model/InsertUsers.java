package model;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUsers extends HttpServlet{

	private static final long serialVersionUID = 1L;

	//localhost変更の必要・データベースはtestdbに設定中
	private String url = "jdbc:mysql://localhost/testdb?characterEncoding=UTF-8&serverTimezone=JST";
	private String user = "testuser";
	private String pw = "1q2w3e4r5t6y";


    public InsertUsers() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");

		Enumeration<String> names = request.getParameterNames();


		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		int num = 0;
		Connection conn = null;
		try {

			conn = DriverManager.getConnection(url,user,pw);
			Statement stmt = conn.createStatement();
			String sql = "insert into Users(name,gender,age) "
						+ "values ('" + name + "','" + gender + "','" + age + "')";

			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(num + "件のデータを登録しました。");
	}


}
