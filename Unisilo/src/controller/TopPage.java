package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TopPage")
public class TopPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TopPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書の出力
		out.println( " 	<!DOCTYPE html>                                                           " );
		out.println( " <html>                                                                     " );
		out.println( "   <head>                                                                   " );
		out.println( "     <meta charset=\"utf-8\">                                               " );
		out.println( "     <title>Unisilo情報登録サイト</title>                                   " );
		out.println( "     <link rel=\"stylesheet\" href=\"htmls/TopPagestylesheet.css\">               " );
		out.println( "   </head>                                                                  " );
		out.println( "   <body>                                                                   " );
		out.println( "     <!-- ここからHTMLを書き始めてください -->                              " );
		out.println( "     <div class=\"header\">                                                 " );
		out.println( "       <img class=\"logo\" src=\"pictures/Logo.JPG\">                       " );
		out.println( "       <div class=\"header-list\" >                                         " );
		out.println( "          <a href=\"InsertItems\">◇　商品マスタ登録　</a>                  " );
		out.println( "          <br>                                                              " );
		out.println( "          <br>                                                              " );
		out.println( "          <br>                                                              " );
		out.println( "          <a href=\"InsertUsers\">◇　顧客情報登録　</a>                    " );
        out.println( "          <br>                                                              " );
	    out.println( "          <br>                                                              " );
        out.println( "          <br>                                                              " );
        out.println( "          <a href=\"InsertSalesRecords\">◇　購入履歴登録　</a>             " );
        out.println( "          <br>                                                              " );
        out.println( "          <br>                                                              " );
        out.println( "          <br>                                                              " );
        out.println( "          <a href=\"InsertAnalysis\">◇　　情報分析　</a>                   " );
        out.println( "       </div>                                                               " );
        out.println( "     </div>                                                                 " );
        out.println( "   </body>                                                                  " );
        out.println( " </html>                                                                    " );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}