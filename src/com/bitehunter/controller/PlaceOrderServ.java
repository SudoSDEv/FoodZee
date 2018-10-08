package com.bitehunter.controller;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitehunter.dbo.DBLogic;


@WebServlet("/PlaceOrderServ")
public class PlaceOrderServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PlaceOrderServ() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession httpSession=request.getSession(false);
		if(httpSession.getAttribute("uname")==null)
			httpSession.setAttribute("uname", "asd");
		
		
			
		java.util.Map<String, String[]> map=request.getParameterMap();
		if(map.size()!=0){
		String menuIds="";
		String plates="";
		String total="";
		for(Entry<String, String[]> x: map.entrySet())
		{
			menuIds+=x.getKey().split(" ")[0]+" ";
			plates+=x.getValue()[0]+" ";
			double t=Double.parseDouble(x.getKey().split(" ")[x.getKey().split(" ").length-2])*Double.parseDouble(x.getValue()[0]);
			total+=t+" ";
		}
		menuIds.trim();
		plates.trim();
		total.trim();
		System.out.println("ids :"+menuIds+ " Plates: " + plates);
		if(DBLogic.placeOrder(httpSession.getAttribute("uname")+"", menuIds,"9088999394", plates,total,""+getServletContext().getAttribute("rId")))
			response.sendRedirect("Finish.jsp?value=Your+order+is+successfully+placed.");
		else
			response.sendRedirect("Finish.jsp?value=Please+try+again.");
		}
		else {
			response.sendRedirect("Finish.jsp?value=Please+order+some+items.");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
