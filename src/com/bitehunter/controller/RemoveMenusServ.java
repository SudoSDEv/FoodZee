package com.bitehunter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitehunter.dbo.DBLogic;

/**
 * Servlet implementation class RemoveMenusServ
 */
@WebServlet("/RemoveMenusServ")
public class RemoveMenusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveMenusServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag=DBLogic.removeMenu(request.getParameter("mId"));
		if(flag)
		{
			request.setAttribute("over", 1);
			request.getRequestDispatcher("RemoveMenus.jsp").forward(request, response);
		}
		else{
			request.setAttribute("over", -1);
			request.getRequestDispatcher("RemoveMenus.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
