package com.bitehunter.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitehunter.dbo.DBLogic;
import com.bitehunter.model.User;

@WebServlet("/RegServ")
public class RegServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RegServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("username");
		String pass1=request.getParameter("userpassword");
		String pass2=request.getParameter("userpassword2");
		String email=request.getParameter("useremail");
		String city=request.getParameter("usercity");
		String address=request.getParameter("useraddress");
		String phone=request.getParameter("userphone");
		String custname=request.getParameter("customername");
		if(pass1.equals(pass2))
		{
			

			User user=new User((DBLogic.noOfRecords("users","uid")+1)+"" , email, address, city, phone, pass1, uname,custname);
			//System.out.println(student);
			
			boolean flag=DBLogic.registerUser(user);
			if(flag){
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("error", "Username already exists.");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("reg.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else{
			request.setAttribute("error", "Passwords doesn't match.");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("reg.jsp");
			requestDispatcher.forward(request, response);
		}
	}

		


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
