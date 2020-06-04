package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemsBusinessLogic;
import model.ItemsDto;

/**
 * Servlet implementation class InsertItem
 */
@WebServlet("/InsertItems")
public class InsertItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemsBusinessLogic logic = new ItemsBusinessLogic();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/InputItems.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 		//受け取ったパラメータの文字化け対策

		try {
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		int price =  Integer.parseInt(request.getParameter("price"));
		int cost = Integer.parseInt(request.getParameter("cost"));

		ItemsDto dto = new ItemsDto();
		dto.setName( name );
		dto.setGender( gender );
		dto.setPrice( price );
		dto.setCost( cost );

		logic.executeItems(dto);

		RequestDispatcher dispatch = request.getRequestDispatcher("/htmls/finish.html");
		dispatch.forward(request, response);
		}catch (Exception e){
			 RequestDispatcher dispatch = request.getRequestDispatcher("/htmls/error.html");
			 dispatch.forward(request, response);
  }

	}
}