package com.alone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户主页效果
 * @author Administrator
 *
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer=response.getWriter();
		
		
		String html="";
		/**
		 * 接收request域对象数据：
		 */
		/*String loginName=(String)request.getAttribute("loginName");*/
		
		/**
		 * 从session对象域中获取数据
		 */
		HttpSession session=request.getSession(false);
		if(session==null){
			//没有登录成功，跳转到登录页面
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;
		}
		
		//2.取出回话数据
		String loginName=(String)session.getAttribute("loginName");
		if(loginName==null){
			//没有登录成功，跳转到登录页面
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;
		}
		
		
		html+="<html><head><head><title>登录成功</title><body>欢迎回来,"+loginName+"<a href='"+request.getContextPath()+"/LogoutServlet'>安全退出</a></body></html>";
		
		writer.write(html);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
