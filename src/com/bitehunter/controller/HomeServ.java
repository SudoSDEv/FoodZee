package com.bitehunter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitehunter.dbo.DBLogic;
import com.bitehunter.model.Restaurant;


@WebServlet("/HomeServ")
public class HomeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String cityname=request.getParameter("city");
		
		try{
		if(cityname.length()!=0)
		{
		if(cityname.charAt(0)>=97 && cityname.charAt(0)<=122){
			StringBuilder stringBuilder=new StringBuilder(cityname);
			stringBuilder.setCharAt(0, (char)(cityname.charAt(0)-32));
			cityname=stringBuilder.toString().trim();
		}
		HashMap<String,ArrayList<Restaurant>> allCitiesWithRestaurants=DBLogic.fetchRestaurants();
		System.out.println(allCitiesWithRestaurants.get(cityname));
		if(allCitiesWithRestaurants.get(cityname)!=null && allCitiesWithRestaurants.get(cityname).size()!=0)
		{
		request.setAttribute("rests", allCitiesWithRestaurants.get(cityname));
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("displayPage.jsp");
		requestDispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("displayPage.jsp");
			requestDispatcher.forward(request, response);
		}
		}}catch (Exception e) {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(request, response);		}	
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
