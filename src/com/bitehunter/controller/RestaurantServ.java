package com.bitehunter.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitehunter.dbo.DBLogic;

@WebServlet("/RestaurantServ")
public class RestaurantServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RestaurantServ() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext servletContext=getServletContext();
		String rId=request.getParameter("resId");
		servletContext.setAttribute("rId", rId);
		ArrayList<String> categories=DBLogic.getCategories(rId);
		request.setAttribute("categories",categories);
		request.setAttribute("resname", rId);
		request.getRequestDispatcher("InnerRest.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
