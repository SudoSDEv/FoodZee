package com.bitehunter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitehunter.dbo.DBLogic;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname=request.getParameter("username");
		String pass=request.getParameter("userpassword");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Home.jsp");
		//test for session requestDispatcher=request.getRequestDispatcher("AfterLogin.jsp");
		
		
		//use old session
		
		if(uname.equals("admin") && pass.equals("admin"))
		{
			HttpSession httpSession=request.getSession(true);
			requestDispatcher=request.getRequestDispatcher("HomeForOwner.jsp");

			httpSession.setAttribute("uname",uname);
			System.out.println("Login Successfull!");
			requestDispatcher.forward(request, response);
			
		}
		
		else if(DBLogic.check(uname,pass))
		{
			//new session object
			HttpSession httpSession=request.getSession(true);
			httpSession.setAttribute("uname", uname);
			requestDispatcher.forward(request, response);
		}
		else
		{
			try {
				request.setAttribute("error", "Username/Password incorrect.");
				requestDispatcher=request.getRequestDispatcher("Login.jsp");
				
				requestDispatcher.forward(request, response);
				
				throw new Exception("Invalid Login Details");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
