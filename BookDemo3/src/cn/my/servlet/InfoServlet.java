package cn.my.servlet;
import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mysql.dao.StudentDao;
import cn.mysql.javabean.Student;

@WebServlet("")
public class InfoServlet extends HttpServlet {
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	StudentDao sDao=new StudentDao();
//	ArrayList<Student> slist=sDao.getAllstudent();//从数据层调用
//	
//	for(Student stu:slist){
//		out.println("id"+stu.getId()+"sname:"+stu.getSname()+"sno:"+stu.getSno());
//		out.print("<br/>");
//	}
	out.print("<br/>");
//	int id=0;
//	System.out.println(request.getParameter("id"));
//	id=Integer.parseInt(request.getParameter("id"));
	String nameString=request.getParameter("sname");
	System.out.println(nameString);
	ArrayList<Student> slist2=sDao.ByName(nameString);//从数据层调用
	for(Student stu:slist2){
		out.println("---------------------------<br/>");
		out.println("id"+stu.getId()+"sname:"+stu.getSname()+"sno:"+stu.getSno());
		System.out.println("id"+stu.getId()+"sname:"+stu.getSname()+"sno:"+stu.getSno());
		System.out.println("执行到这");
	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
