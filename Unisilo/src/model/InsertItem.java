package model;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class InsertItem
 */
@WebServlet("/InsertItem")
public class InsertItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//?以降は文字化け対策
	String url = "jdbc:mysql://121.142.93.107:20621/unisilodb?characterEncoding=UTF-8&serverTimezone=JST";
	String user = "nskensyu2020";
	String pw = "2020Nskensyu!";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/InputItem.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 		//受け取ったパラメータの文字化け対策

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String price = request.getParameter("price");
		String cost = request.getParameter("cost");

		  // DBへ保存処理
		Connection con = null;
		Statement smt = null;
		int num = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//コネクション作成
			con = DriverManager.getConnection(url, user, pw);
			smt = con.createStatement();

			//SQL実行
			String insert_item = "insert into items(name,gender,price,cost) "
					+ "values ('" + name + "','" + gender + "','" + price + "','" + cost + "')";

			num = smt.executeUpdate(insert_item);
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

		// DB更新状態を判断し、画面を移す
		if (num == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('登録完了しました');window.location='/Unisilo/InsertItem';</script>");
		}else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/htmls/error.html");
			dispatch.forward(request, response);
		}
	}
}