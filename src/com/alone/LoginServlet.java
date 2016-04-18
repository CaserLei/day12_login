package com.alone;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 处理登录的逻辑
 * @author Administrator
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.接收参数
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		
		//2.判断逻辑
		if("alone".equals(userName) && "123456".equals(userPwd)){
			//登录成功
			/**
			 * context 域对象：不合适会覆盖对象
			 * request 域对象： 不合适,整个网站必须使用转发技术来跳转页面
			 * 
			 * session 域对象： 合适
			 * 
			 */
			/*request.setAttribute("loginName", userName);
			request.getRequestDispatcher("/IndexServlet").forward(request, response);
			*/
			
			/**
			 * 用户数据保存session对象中
			 */
			//1.创建session对象
			HttpSession session=request.getSession();
			//2.把数据保存到session域中
			session.setAttribute("loginName", userName);
			//3.跳转到用户主页，
			response.sendRedirect(request.getContextPath()+"/IndexServlet");
			
		}else{
			//登录失败
			//用请求重定向
			response.sendRedirect(request.getContextPath()+"/fail.html");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
