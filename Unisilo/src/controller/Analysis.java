package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnalysisBusinessLogic;
import model.AnalysisDto;

/**
 * Servlet implementation class Analysis
 */
@WebServlet("/Analysis")
public class Analysis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AnalysisBusinessLogic logic = new AnalysisBusinessLogic();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8"); 		//受け取ったパラメータの文字化け対策

		//★★ここにDBから選択肢の値を取得してrequestに渡す処理を書きましょう。
		List<Map<String,Object>> items = logic.getItems();
		request.setAttribute("items", items);

       //viewに返す
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/Analysis.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		request.setCharacterEncoding("UTF-8"); 		//受け取ったパラメータの文字化け対策

		//リクエストパラメータを取得
		String dateStart = request.getParameter("date1");
		String dateEnd = request.getParameter("date2");
		String name = request.getParameter("item_name");
		String userGender = request.getParameter("userGender");
	    String userAge = request.getParameter("userAge");

	  //データ（Dto型）の作成
	  		AnalysisDto dto = new AnalysisDto();
	  		dto.setDateStart( dateStart );
	  		dto.setDateEnd( dateEnd);
	  		dto.setName( name );
	  		dto.setUserGender( userGender);
	  		dto.setUserAge( userAge);



		//★★こんな感じで1行で結果売上げと利益を取得できたらいいかも。


	  		Map<String,Integer> results = logic.getCalculationResult(dto);




		 //Output.jspへ出力表示
		 RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/Output.jsp");
		 dispatch.forward(request, response);

  }

}
