package com.kh.controlloer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ElServler
 */
@WebServlet("/el.do")
public class ElServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElServler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 데이터를 담을 수 있는 JSP/servlet의 내장객체
		 * 
		 * 1.ServletContest(application scope)
		 * 한 애플리케이션당 단 1개만 존재하는 객체
		 * 이 영역에 데이터를 담으면 애플리케이션이 전역에서 사용 가능
		 * 공유 범위가 가장 크다.
		 * 
		 * 2.HttpSession(session scope)
		 * 한 브라우저당 1개 존재하는 객체
		 * 이 영역에 데이터를 담으면 jsp/servlet단에서 사용이 가능
		 * 
		 * 3.HttpServletRequest(request scope)
		 * 요청때마다 매번 생성되는 객체
		 * 이 영역에 데이터를 담으면 해당 request 객체를 포워딩받는 응답 jsp에서만 사용 가능
		 * 
		 * 4. PageContext(page scope)
		 * jsp마다 존재하는 개체
		 * 공유범위가 가장 좁다.(해당 페이지에서만 공유)
		 * */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
