package com.bitehunter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitehunter.dbo.DBLogic;


@WebServlet("/AddMenuServ")
public class AddMenuServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddMenuServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean flag=DBLogic.addMenus(request.getParameter("cname"),request.getParameter("menuname"),request.getParameter("price"));
		if(flag)
			{
			request.setAttribute("over", 1);
				request.getRequestDispatcher("AddMenus.jsp").forward(request, response);
			}
		else{
			request.setAttribute("over", -1);
			request.getRequestDispatcher("AddMenus.jsp").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
