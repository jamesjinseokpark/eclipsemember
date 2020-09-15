package com.hk.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.member.dao.MemberDao;

/**
 * Servlet implementation class MemberDelete
 */
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("NO =" + no);
		System.out.println("doGet(delete -1까지 ");
		response.setContentType("text/html; charset=UTF-8"); 
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberDelete.jsp");
		rd.include(request, response);
		System.out.println("doGet(delete -2까지 ");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("doPost No = " + no);
		
		System.out.println("doPost(delete -3까지 ");
	
		
		Connection connection = null;
		MemberDao memberDao = new MemberDao();
		memberDao.setConnection(connection);
		
		System.out.println("doPost(delete -4까지 ");
		
		
				
		try {
			
			ServletContext sc = this.getServletContext();
			connection = (Connection) sc.getAttribute("conn");
			System.out.println("doPost(delete -4.5까지 ");
			memberDao.delete(no);
			
			System.out.println("doPost(delete -5까지 ");
	    						
			response.setContentType("text/html; charset=UTF-8;");
			
			System.out.println("doPost(delete -6까지 ");
//			
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberDeleteAfter.jsp");
			rd.include(request, response);
			
			System.out.println("doPost(delete -7까지 ");
			

		}catch(Exception e) {

			e.getStackTrace();
			throw new ServletException();

		}finally{
			
//			if(conn != null)
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			if(stmt != null)
//				try {
//					stmt.close();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			//db close
		}
		
	}

}
