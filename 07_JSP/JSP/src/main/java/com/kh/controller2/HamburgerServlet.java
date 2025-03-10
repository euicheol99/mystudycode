package com.kh.controller2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HamburgerServlet
 */
@WebServlet("/confirmHamburger.do")
public class HamburgerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HamburgerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		
		String hamburger = request.getParameter("hamburger");
		String[] toppingList = request.getParameterValues("topping");
		String[] sideList = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
		
		int price = 0;
		switch(hamburger) {
		case "새우버거" :
		case "불고기버거" : price += 4000;
		case "한우버거" : 
		case "햄버거" : price +=5000;
		defalut : price +=1000;
		
		if(toppingList != null) {
			for(String topping : toppingList) {
				switch(topping) {
				case "고구마무스" :
				case "치즈크러스트" : price+=2000; break;
				case "치즈바이트" :
				case "치즈추가" : price+=3000;	break;
				case "베이컨,소세지" :
				case "파인애플" : price+=4000; break;
				default: price += 1000;
		
				}
			}
		}
		
		if(sideList!= null) {
			for(String side : sideList) {
				switch(side) {
				case "콜라":
				case "사이다": 
				case "환타": price += 3000; break;
				case "핫소스":
				case "파마산":
				case "피클": price += 1000;break;
				}
			}
		}
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		
		request.setAttribute("hamburger", hamburger);
		request.setAttribute("toppingList", toppingList);
		request.setAttribute("sideList", sideList);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		RequestDispatcher view = request.getRequestDispatcher("views/hamburger/hamburgerPayment.jsp");
		view.forward(request, response);
		} 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	
}

