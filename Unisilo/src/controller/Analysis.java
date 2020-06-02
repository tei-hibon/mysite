package controller;

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

//	//データベースを指定。?以降は文字化け対策
//	String url = "jdbc:mysql://121.142.93.107:20621/unisilodb?characterEncoding=UTF-8&serverTimezone=JST";
//	String user = "nskensyu2020";
//	String pw = "2020Nskensyu!";
//

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//★★ここにDBから選択肢の値を取得してrequestに渡す処理を書きましょう。
		//List<Map<String,Object>> items = logic.getItems(); //サンプルです。logicはInsertSalesRecordsを参考に自分で用意する必要があります。
		//List<Map<String,Object>> users = logic.getUsers();
		//request.setAttribute("items", items);
		//request.setAttribute("users", users);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/Analysis.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		request.setCharacterEncoding("UTF-8"); 		//受け取ったパラメータの文字化け対策

		String dateStart = request.getParameter("date1");
		String dateEnd = request.getParameter("date2");
		String name = request.getParameter("item_name");
		String userGender = request.getParameter("userGender");
	    String userAge = request.getParameter("userAge");

//Dao	// DBへ保存処理
//Dao	Connection con = null;
//Dao	Statement smt = null;
//Dao
//Dao	try {
//Dao		Class.forName("com.mysql.cj.jdbc.Driver");
//Dao
//Dao		//コネクション作成
//Dao		con = DriverManager.getConnection(url, user, pw);
//Dao		smt = con.createStatement();
//Dao
//Dao		//SQL実行
//Dao		String input_analysis = "SELECT SUM(items.price) ,SUM(items.price-items.cost) " +
//Dao				"FROM sales_records " +
//Dao				"JOIN items " +
//Dao				"ON sales_records.item_id=items.id " +
//Dao				"JOIN users " +
//Dao				"ON sales_records.user_id=users.id " +
//Dao				"WHERE purchased_at BETWEEN " + dateStart + " and " + dateEnd +
//Dao				" and items.name = '" + name + "'" ;
//Dao		if (userGender!=null) {
//Dao			input_analysis=input_analysis+" and users.gender in(" + userGender +")";
//Dao		}
//Dao		if (userAge!="0") {
//Dao			input_analysis=input_analysis+" and users.age BETWEEN " + age1 + " and " + age2 + ";" ;
//Dao		}
//Dao
//Dao		//DBから受け取る
//Dao
//Dao		ResultSet rs = smt.executeQuery(input_analysis);

		//★★こんな感じで1行で結果売上げと利益を取得できたらいいかも。
		//List<int> results = logic.executeInsertSurvey(dto);


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
		// Output.jspへ出力表示
		//RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/Output.jsp");
		//dispatch.forward(request, response);

	}

}
