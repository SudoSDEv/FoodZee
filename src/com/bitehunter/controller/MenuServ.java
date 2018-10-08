package com.bitehunter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/MenuServ")
public class MenuServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public MenuServ() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> map=request.getParameterMap();
	
		ArrayList<String> menus=new ArrayList<>();
		System.out.println(map.size());
		
		for(Entry<String, String[]> x: map.entrySet())
		{
			System.out.println("test");
			
			if(!x.getValue()[0].equals("0") && x.getValue()[0].length()!=0){
				String tString=x.getKey();
				tString+=" "+x.getValue()[0];
				menus.add(tString);
				System.out.println(x.getValue()[0]);
			}
			
		}
				
		for(String x: menus)
			System.out.println(x);
			request.setAttribute("menus", menus);
		request.getRequestDispatcher("prePay.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
