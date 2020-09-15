package com.hk.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.member.dao.MemberDao;
import com.hk.member.dto.Member;

/**
 * Servlet implementation class MemberAddServlet
 */
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=UTF-8");
		

		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberAdd.jsp");
		rd.include(request, response);
		System.out.println("doGet(add) 호출됨");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("doPost(add) 호출됨");

		Connection connection = null;

		try {

			ServletContext sc = this.getServletContext();
			connection = (Connection) sc.getAttribute("conn");
			MemberDao memberDao = new MemberDao();

			memberDao.setConnection(connection);

			Member member = new Member();

			member.setEmail(request.getParameter("email"));
			member.setMname(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));

			memberDao.insert(member);

			//request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8;");
			request.setAttribute("name", request.getParameter("name"));

			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberAddAfter.jsp");
			rd.include(request, response);



		}catch(Exception e) {

			throw new ServletException (e);


		}finally {

		}
	}

}
