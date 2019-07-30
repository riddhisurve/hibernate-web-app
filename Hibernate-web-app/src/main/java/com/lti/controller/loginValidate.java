package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

/**
 * Servlet implementation class loginValidate
 */
public class loginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			CustomerDao dao=new CustomerDao();
			Customer c= dao.fetchByEmail(email, pass);
			
			HttpSession session=request.getSession();
			session.setAttribute("login",c);
			response.sendRedirect("Welcome.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			response.sendRedirect("login.html");
		}
		/*
		if(c.getEmail()!=null)
		{
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("Wrong credentials.");
			out.println("<br><a href=login.html> Login </a> ");
		}*/
		
	}

}
