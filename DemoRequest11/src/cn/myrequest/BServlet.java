package cn.myrequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		/**
		 * 通过request来获取url相关方法
		 */
		response.getWriter().print(request.getScheme()+"<br/>");//获取请求协议
		response.getWriter().print(request.getServerName()+"<br/>");//获取服务器名称
		response.getWriter().print(request.getServerPort()+"<br/>");//获取服务器端口号1
		response.getWriter().print(request.getContextPath()+"<br/>");//获取项目的名称
		response.getWriter().print(request.getServletPath()+"<br/>");//获取Servlet路径
		response.getWriter().print(request.getQueryString()+"<br/>");//获取参数部分
		response.getWriter().print(request.getRequestURI()+"<br/>");//获取请求URI
		response.getWriter().print(request.getRequestURL()+"<br/>");//获取请求URL
		


	}

}
