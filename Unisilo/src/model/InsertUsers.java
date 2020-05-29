package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//動かないのはなぜだろう



public class InsertUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //localhost変更に必要あり？データベース名・ユーザー・パスワードも変更必須→すべて完了・成功
	private String url = "jdbc:mysql://121.142.93.107:20621/unisilodb?characterEncoding=UTF-8&serverTimezone=JST";
	private String user = "nskensyu2020";
	private String pw = "2020Nskensyu!";


    public InsertUsers() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/InputUsers.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");


		Enumeration<String> names = request.getParameterNames();


		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
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
			String sql = "insert into users(name,gender,age) "
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




		   if(num == 1) {
			   //リダイレクト
		       response.sendRedirect("htmls/finish.html");
		   }else {
			   response.sendRedirect("htmls/error.html");
		   }


	}




}


