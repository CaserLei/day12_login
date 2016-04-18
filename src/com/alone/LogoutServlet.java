package com.alone;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 退出逻辑
 * @author Administrator
 *
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 安全退出的逻辑
		 *     删除掉session对象中的loginName属性，就可以了，不删除session的原因是避免因删除session而把所有session中的数据删掉。产生问题
		 */
		//1.得到session对象
		HttpSession session=request.getSession();
		if(session!=null){
			//2.删除属性
			session.removeAttribute("loginName");
		}
		//3.回到登录页面
		response.sendRedirect(request.getContextPath()+"/login.html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
