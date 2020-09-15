package com.hk.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int no = Integer.parseInt(request.getParameter("no"));
		//		
		System.out.println("doGet(update1 호출)");
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		//
		try {
			//			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			//
			//			// 2단계
			//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			//					// JDBC로 oracle을 연결하는데 IP는 localhost이고, Port는 1521이고 SID XE
			//					"STUDY", "STUDY");
			ServletContext sc = this.getServletContext();
			System.out.println("doGet(update2 호출)");
			Connection connection = (Connection) sc.getAttribute("conn");
			System.out.println("doGet(update3 호출)");
			pStmt = connection.prepareStatement("select mno,email,pwd,mname,cre_date, mod_date from members where mno=?");
			System.out.println("doGet(update4 호출)");
			pStmt.setInt(1, no);

			rs = pStmt.executeQuery(); // ResultSet
			System.out.println("doGet(update5 호출)");
			// while(rs.next()) {
			//
			//
			//
			// //? :pk로 조회했기때문에 결과는 1개인데 꼭 while이 필요?
			// System.out.println(rs.getString("mname"));
			//
			// }
			Member member = new Member();
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(connection);
			//	    System.out.println("1")
			rs.next();
			// ResultSet의 결과가 1row만 있을때는 rs.next(): 1개만 꺼냄.
			member.setMno(rs.getInt("mno"));
			member.setMname(rs.getString("mname"));
			member.setEmail(rs.getString("email"));
			member.setPassword(rs.getString("pwd"));
			member.setCre_date(rs.getDate("cre_date"));
			memberDao.update(member);
	//		response.setContentType("text/html; charset=UTF-8;");
			request.setAttribute("member", member);
	//		Member member = memberDao.selectOne(Integer.parseInt(request.getParameter("no")));
			
			System.out.println("doGet(update6 호출");
			response.setContentType("text/html; charset=UTF-8");

			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdate.jsp");
			rd.include(request, response);
			System.out.println("doGet(update7 호출");
			//

		} catch (Exception e) {

			e.getStackTrace();

		} finally {
			// db close
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 사용자가 수정한 정보를 가져와서 DB에 저장
		// 사용자가 보내오는 정보 키워드는 어디서 확인하는가? doget()

		//		request.setCharacterEncoding("UTF-8");


	//	PreparedStatement pStmt = null;

		try {

		//	ServletContext sc = this.getServletContext();
		//	Connection connection = (Connection) sc.getAttribute("conn");

			response.setContentType("text/html; charset=UTF-8;");
			request.setAttribute("name", request.getParameter("name"));
			System.out.println("doPost(update8 호출)");
			

			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdateAfter.jsp");
			rd.include(request, response);
			System.out.println("doPost(update9 호출)");

			// 성공하였습니다. 하고 3초뒤에 /member/list로 보냄.
			// while(rs.next()) {
			// //? :pk로 조회했기때문에 결과는 1개인데 꼭 while이 필요?
			// System.out.println(rs.getString("mname"));
			// }

		} catch (Exception e) {

			e.getStackTrace();
			throw new ServletException();

		} finally {
			// db close
			//
			//			if(stmt != null) try {
			//
			//				stmt.close();
			//			}catch (SQLException e) {
			//				e.printStackTrace();
			//			}

		}

	}

}
