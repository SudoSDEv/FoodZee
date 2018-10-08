package com.bitehunter.dbo;

import java.util.ArrayList;

public class Helper {
	
	public static String calTotal(ArrayList<String> arg)
	{
		double total=0;
		for(String x:arg){
			String[] details=x.split(" ");
			total+=Double.parseDouble(details[details.length-1])*Double.parseDouble(details[details.length-2]);
		}
		
		return total+"";
		
	}
	
	public static String fetchName(String arg)
	{
		String name = "";
		String details[]=arg.split(" ");

		for(int i=1;i<details.length-2;i++)
		{
			name+=details[i]+" ";
		}
		
		return name;
	}

}
