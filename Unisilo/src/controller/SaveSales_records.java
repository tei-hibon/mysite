package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sales_recordsBusinessLogic;
import model.Sales_recordsDto;

/**----------------------------------------------------------------------*
 *■■■Saveクラス■■■
 *概要：サーブレット
 *詳細：リクエストをDAOに登録し、画面遷移する。
 *　　　＜遷移先＞登録成功：回答完了画面（finish.html）／登録失敗：エラー画面（error.html）
 *----------------------------------------------------------------------**/
public class SaveSales_records extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveSales_records() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定


		//リクエストパラメータを取得
		int  item_id              = Integer.parseInt( request.getParameter("ITEM_ID"));
		int  user_id              = Integer.parseInt( request.getParameter("USER_ID") );
		String purchased_at       = request.getParameter("PURCHASED_AT");

		//データ（Dto型）の作成
		Sales_recordsDto dto = new Sales_recordsDto();
		dto.setItem_id( item_id );
		dto.setUser_id( user_id);
		dto.setPurchased_at( purchased_at );


		//データをDBに登録
		Sales_recordsBusinessLogic logic = new Sales_recordsBusinessLogic();
		boolean succesInsert = logic.executeInsertSurvey(dto);  //DB操作成功フラグ（true:成功/false:失敗）


		//DB操作の成功/失敗に応じて表示させる画面を振り分ける
		if (succesInsert) {

			//DB登録に成功した場合、回答完了画面（finish.html）を表示する
			response.sendRedirect("htmls/finish.html");

		} else {

			//DB登録に失敗した場合、エラー画面（error.html）を表示する
			response.sendRedirect("htmls/error.html");

		}
	}
}
