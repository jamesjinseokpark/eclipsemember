package com.hk.member.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AppInitServlet



 * web.xml servlet을 등록 후 load-on-startup에 1을 주고 Tomcat이 실행시
 * 자동으로 실행될 수 있도록 설정한다.
 * 이것도 서블릿이므로 생명주기가 있음. init() service() destroy()
 * 그 중 init 과 destroy만 사용 
 * init()은 DB접속을
 * 
 * destroy()는 DB접속 종료를
 * 
 * */

public class AppInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// JDBC 1,2단계
		// DB접속 정보 : Connection String, ID, PW
		// DB접속정보를 만들어서 servletcontext라고 하는 모든 servlet이
		// 접근가능한 공간에 저장을 해둔다.
		System.out.println("AppinitServlet 준비..");
		super.init(config);
		
		Connection connection;
		
		ServletContext sc = this.getServletContext();
		
		//jdbc1단계
		try {
			Class.forName(sc.getInitParameter("driver"));
			String url = sc.getInitParameter("url");
			String user = sc.getInitParameter("username");
			String password = sc.getInitParameter("password");
			
			connection = DriverManager.getConnection(url, user, password);
			
			//ServletContext 저장소에 저장.
			sc.setAttribute("conn", connection);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AppinitServlet 마무리..");
		//JDBC 6단계
		
		ServletContext sc = this.getServletContext();
		
		Connection connection = (Connection) sc.getAttribute("conn");
		
		try {
			if(connection != null && connection.isClosed()==false) connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
		}
	}

}
