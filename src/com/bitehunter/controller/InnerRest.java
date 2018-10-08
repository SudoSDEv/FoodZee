package com.bitehunter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitehunter.dbo.DBLogic;
import com.bitehunter.model.Menu;


@WebServlet("/InnerRest")
public class InnerRest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InnerRest() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cname=request.getParameter("choice");
		ArrayList<Menu> menus=DBLogic.getMenus(cname);
		request.setAttribute("Menus", menus);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
