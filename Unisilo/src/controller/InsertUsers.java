package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsersBusinessLogic;
import model.UsersDto;




@WebServlet("/InsertUsers")
public class InsertUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;


    //★★Daoを使ってデータベースにアクセスしましょう
	private UsersBusinessLogic logic = new UsersBusinessLogic();



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/InputUsers.jsp");
		dispatcher.forward(request, response);
	}


		protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定


	try {	//リクエストパラメータを取得
		String  name              =  request.getParameter("name");
		int  gender              = Integer.parseInt( request.getParameter("gender") );
		int age       = Integer.parseInt(request.getParameter("age"));

		//データ（Dto型）の作成
		UsersDto dto = new UsersDto();
		dto.setName( name );
		dto.setGender( gender);
		dto.setAge( age );

      logic.executeInsertSurvey(dto);



        RequestDispatcher dispatch = request.getRequestDispatcher("/htmls/finish.html");
        dispatch.forward(request, response);
		//Insert失敗時はエラー画面に切り返る
	}catch(Exception e)  {
			RequestDispatcher dispatch = request.getRequestDispatcher("/htmls/error.html");
			 dispatch.forward(request, response);
	



	}
		}



}
