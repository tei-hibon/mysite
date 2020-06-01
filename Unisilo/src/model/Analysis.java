package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Analysis
 */
@WebServlet("/Analysis")
public class Analysis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//データベースを指定。?以降は文字化け対策
	String url = "jdbc:mysql://121.142.93.107:20621/unisilodb?characterEncoding=UTF-8&serverTimezone=JST";
	String user = "nskensyu2020";
	String pw = "2020Nskensyu!";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Analysis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//jspに移す
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/Analysis.jsp");
		dispatcher.forward(request, response);

		request.setCharacterEncoding("UTF-8"); 		//受け取ったパラメータの文字化け対策

		//受け取る Ageのところだけ別処理がいる
		String dateStart = request.getParameter("date1");
		String dateEnd = request.getParameter("date2");
		String name = request.getParameter("item_name");
		String userGender = request.getParameter("userGender");
	    String userAge = request.getParameter("userAge");

	    //age1,age2	初期化
	    int age1=0, age2=0;

        //age1, afe2設定
	    switch(userAge) {
	      case "0":
	    	 age1=0;
	    	 age2=200;
	    	 break;
	      case "1":
	    	 age1=10;
	    	 age2=19;
	    	 break;
	      case "2":
	    	 age1=20;
	    	 age2=29;
	    	 break;
	      case "3":
	    	 age1=30;
	    	 age2=39;
	    	 break;
	      case "4":
	    	 age1=40;
	    	 age2=200;
	    	 break;
	    }

		// DBへ保存処理
		Connection con = null;
		Statement smt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//コネクション作成
			con = DriverManager.getConnection(url, user, pw);
			smt = con.createStatement();

			//SQL実行
			String input_analysis = "SELECT SUM(items.price) ,SUM(items.price-items.cost) " +
					"FROM sales_records " +
					"JOIN items " +
					"ON sales_records.item_id=items.id " +
					"JOIN users " +
					"ON sales_records.user_id=users.id " +
					"WHERE purchased_at BETWEEN " + dateStart + " and " + dateEnd +
					" and items.name = '" + name + "'" +
					" and users.gender = " + userGender +
					" and users.age BETWEEN " + age1 + " and " + age2 +
					";";
			//DBから受け取る

			ResultSet rs = smt.executeQuery(input_analysis);
			int sumPrice = rs.getInt("SUM(items.price)");
			int sumPC = rs.getInt("SUM(items.price-items.cost)");


		}catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		  // ここまでDB処理

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		// Output.jspへ出力表示
		//RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/Output.jsp");
		//dispatch.forward(request, response);

	}

}
