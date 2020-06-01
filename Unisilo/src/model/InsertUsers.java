package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/InsertUsers")
public class InsertUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //localhost変更に必要あり？データベース名・ユーザー・パスワードも変更必須→すべて完了・成功
	private String url = "jdbc:mysql://121.142.93.107:20621/unisilodb?characterEncoding=UTF-8&serverTimezone=JST";
	private String user = "nskensyu2020";
	private String pw = "2020Nskensyu!";



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/InputUsers.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");



		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");

		int num = 0;
		Statement stmt=null;
		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url,user,pw);
            stmt = con.createStatement();
            String sql = "insert into users(name,gender,age) "
                                + "values ('" + name + "','" + gender + "','" + age + "')";

            num = stmt.executeUpdate(sql);


		} catch (SQLException| ClassNotFoundException e ) {
                e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}




		   if(num == 1) {
			   //forward
			   RequestDispatcher dispatch = request.getRequestDispatcher("/htmls/finish.html");
				dispatch.forward(request, response);
		   }else {
			   RequestDispatcher dispatch = request.getRequestDispatcher("/htmls/error.html");
				dispatch.forward(request, response);
		   }


	}




}
