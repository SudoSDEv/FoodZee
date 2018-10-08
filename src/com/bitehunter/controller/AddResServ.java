
package com.bitehunter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitehunter.dbo.DBLogic;

/**
 * Servlet implementation class AddResServ
 */
@WebServlet("/AddResServ")
public class AddResServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag=DBLogic.addRestaurant(request.getParameter("rname"),request.getParameter("cityname"),request.getParameter("address"),request.getParameter("phone"),request.getParameter("email"));
		if(flag)
			{
			request.setAttribute("over", 1);
				request.getRequestDispatcher("AddRestaurants.jsp").forward(request, response);
			}
		else{
			request.setAttribute("over", -1);
			request.getRequestDispatcher("AddRestaurants.jsp").forward(request, response);
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
