package com.hk.member.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */

public class CharacterEncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
	
	FilterConfig fConfig;
    public CharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
//		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding(fConfig.getInitParameter("encoding"));
		System.out.println("Encoding = UTF-8");		
		System.out.println("Filter-doFilter()");
		// pass the request along the filter chain
		
//	    HttpServletRequest httReq = (HttpServletRequest) request;
//	    HttpServletResponse httRes = (HttpServletResponse) response;
//
//	    HttpSession session = httReq.getSession();
//	    
//	    if (session.getAttribute("member") == null) { 
//	    	System.out.println("로그인 사용자가 없습니다. login페이지로 이동해야합니다.");
//	    	httRes.sendRedirect("../auth/login");
//	    } else { 
//	    	System.out.println("현재 로그인한 사용자는 = " + session.getAttribute("member"));
//	    }
//		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		//최초1회 . . FilterConfig이라는 class의 인스턴스를 선언하여 값을 입력받음.
		System.out.println("Filter-init()");
		this.fConfig = fConfig;
		
	}

}
