package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.registerservice;
import model.Userbean;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   registerservice rs=new registerservice();
    /**
     * Default constructor. 
     */
    public register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();

		 //out.print(rs.Display());
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		
		Userbean ub=new Userbean();
		ub.setFirstName(request.getParameter("firstName"));
		ub.setLastName(request.getParameter("lastName"));
		ub.setEmail(request.getParameter("email"));
		ub.setPassword(request.getParameter("password"));
		ub.setRepassword(request.getParameter("repassword"));
		ub.setConutry(request.getParameter("country"));
		ub.setGender(request.getParameter("gender"));

		 if(request.getParameter("purpose").equals("register"))
	      {
			if(rs.Insert(ub))		
				out.println("Inserted successfully");		

	      }
		 else if(request.getParameter("purpose").equals("delete"))
	      {
			rs.delete(ub); 
	      }
		 out.print(rs.Display());
	}

}
