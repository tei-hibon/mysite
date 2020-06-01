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

import model.SalesRecordsBusinessLogic;
import model.SalesRecordsDto;
/**----------------------------------------------------------------------*
 *■■■Insertクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（回答入力画面）を出力する。
 *----------------------------------------------------------------------**/
//★★クラス名およびアクセス時の名称を変更。キャメルケースに統一、inputをinsertに変更
@WebServlet("/InsertSalesRecords")
/**@WebServletアノテーションを利用することで、
 *その関数にブラウザからアクセスする時のパスを明示することができます。 *
 *例えば、function InputSalesRecordsに対して@WebServlet(ISR)と明示した場合、
 *システムはhttp://localhost:8080/Unisilo/ISRで該当関数にアクセスすることができます。**/

public class InsertSalesRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//利用するモデルを紐づけ
	private SalesRecordsBusinessLogic logic = new SalesRecordsBusinessLogic();

	//★★初期化は不要なので削除

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//★★コントローラにあたるこのサーブレットではビジネスロジックで用意された値をビューに渡すだけ。

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定


		//★★選択肢の内容をモデルを介して取得
		List<Map<String,Object>> items = logic.getItems();
		List<Map<String,Object>> users = logic.getUsers();

		//★★選択肢の内容をrequestにセットしてビューに渡す
		request.setAttribute("items", items);
		request.setAttribute("users", users);


		//Viewにフォワード
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/InputSalesRecords.jsp");
		dispatch.forward(request, response);

	}

	//SaleSales_recordsの内容をこちらに統一
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定


		//リクエストパラメータを取得
		int  item_id              = Integer.parseInt( request.getParameter("itemId"));
		int  user_id              = Integer.parseInt( request.getParameter("userId") );
		String purchased_at       = request.getParameter("purchasedAt");

		//データ（Dto型）の作成
		SalesRecordsDto dto = new SalesRecordsDto();
		dto.setItem_id( item_id );
		dto.setUser_id( user_id);
		dto.setPurchased_at( purchased_at );


		//データをDBに登録
		boolean succesInsert = logic.executeInsertSurvey(dto);  //DB操作成功フラグ（true:成功/false:失敗）


		//DB操作の成功時のURL
		RequestDispatcher dispatch = request.getRequestDispatcher("/htmls/finish.html");

		//Insert失敗時はエラー画面に切り返る
		if (!succesInsert) {
			dispatch = request.getRequestDispatcher("/htmls/error.html");
		}

		//★★リダイレクトだと変な感じなのでフォワードで統一
		dispatch.forward(request, response);
	}

}
