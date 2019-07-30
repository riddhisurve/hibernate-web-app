package com.lti.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

/**
 * Servlet implementation class InsertDisplay
 */
public class InsertDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDisplay() {
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
		String name = request.getParameter("cname");
		String email = request.getParameter("cemail");
		String city = request.getParameter("ccity");
		String pass = request.getParameter("cpass");
 		
 		CustomerDao dao = new CustomerDao();
 		Customer c = new Customer();
 		c.setCity(city);
 		c.setEmail(email);
 		c.setName(name);
 		c.setPassword(pass);
 		dao.add(c);
 		
 		response.sendRedirect("index.html");
	}

}
