package com.bitehunter.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.bitehunter.model.Category;
import com.bitehunter.model.Menu;
import com.bitehunter.model.Order;
import com.bitehunter.model.Restaurant;
import com.bitehunter.model.User;
import com.sun.corba.se.pept.transport.ConnectionCache;
import com.sun.javafx.binding.StringFormatter;
import com.sun.jndi.toolkit.ctx.StringHeadTail;

public class DBLogic {
	
	
	public static HashMap<String,ArrayList<Restaurant>> fetchRestaurants()
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		ResultSet resultSet2=null;
		ResultSet resultSet3=null;
		
		HashMap<String, ArrayList<Restaurant>> rHashMap=new HashMap<>();
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select * from cities");
			resultSet=preparedStatement.executeQuery();

			while(resultSet.next())
			{
				String cityname=resultSet.getString(1);
				//cityWithRests.setCityName(cityname);
				ArrayList<Restaurant> restaurants=new ArrayList<>();
				preparedStatement=connection.prepareStatement("select rid from cityandrest where cityname=\""+cityname+"\"");
				
				resultSet2=preparedStatement.executeQuery();
				while(resultSet2.next())
				{
					String rId=resultSet2.getString(1);
					preparedStatement=connection.prepareStatement("select * from restaurants where rId=\""+rId+"\"");
					resultSet3=preparedStatement.executeQuery();
					while(resultSet3.next()){
						restaurants.add(new Restaurant(resultSet3.getString(1), resultSet3.getString(2), resultSet3.getString(3), resultSet3.getString(4), resultSet3.getString(5), resultSet3.getString(6)));
					}
				}
				rHashMap.put(cityname, restaurants);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			DBConnection.closeResultSet(resultSet3);
			DBConnection.closeResultSet(resultSet2);
			
		}
		return rHashMap;
	}

	public static ArrayList<String> getCategories(String rId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<String> cat=new ArrayList<>();
		ResultSet resultSet=null;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select * from interface where rid="+rId);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				cat.add(resultSet.getString(2));
			}
			DBConnection.closeResultSet(resultSet);

			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);

		}
		
		
		return cat;
	}

	
	public static ArrayList<Menu> getMenus(String cname)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		ArrayList<Menu> menus=new ArrayList<>();
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select * from menus where cname=\'"+cname+"\'");
			resultSet=preparedStatement.executeQuery();
			Menu menu;
			while(resultSet.next())
			{
				menu=new Menu(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.parseDouble(resultSet.getString(4)));
				menus.add(menu);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return menus;
		
	}
	
	@SuppressWarnings("resource")
	public static boolean placeOrder(String uId,String menuids,String phNo,double total)
	{
		boolean flag=false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date=new java.util.Date();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int maxOrderId;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select max(orderid) from orders");
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
				maxOrderId=resultSet.getInt(1);
			else 
				maxOrderId=0;
			
			String sql="insert into orders values('"+uId+"','"+menuids+"','"+(maxOrderId+1)+"','"+dateFormat.format(date)+"','"+phNo+"','"+total+"')";
			preparedStatement=connection.prepareStatement(sql);
			
			if(preparedStatement.executeUpdate()>0)
				flag=true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return flag;
		
	}
	
	public static String fetchMenuName(String mId)
	{
		String name=null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int r=0;

		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select menuname from menus where mid=?");
			preparedStatement.setString(1, mId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				name=resultSet.getString(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return name;
	}
	
	public static ArrayList<Order> fetchOrders()
	{
		ArrayList<Order> orders=new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int r=0;

		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select * from orders");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Order order=new Order(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
				orders.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return orders;
	}
	
	public static int noOfRecords(String dbname,String param)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int r=0;

		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select max(cast(("+param+")as unsigned)) from "+dbname);
			
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
				r=resultSet.getInt(1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return r;

}

	public static boolean registerUser(User user) {


		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("insert into users values(\'"+user.getUid()+"\',\'"+user.getUname()+"\',\'"+user.getPassword()+"\',\'"+user.getCity()+"\',\'"+user.getAddress()+"\',\'"+user.getPhone()+"\',\'"+user.getEmail()+"\','"+user.getCustomername()+"')");
			if(preparedStatement.executeUpdate()>0)
				return true;
			else return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return false;
		
		
	}
	
	public static ArrayList<Menu> fetchMenus() {
		
		ArrayList<Menu> rArrayList=new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select * from menus");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) rArrayList.add(new Menu(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.parseDouble(resultSet.getString(4))));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return rArrayList;
		
	}
	
	public static ArrayList<Category> fetchCategories()
	{
		ArrayList<Category> rArrayList=new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select * from categories");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) rArrayList.add(new Category(resultSet.getString(1)));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return rArrayList;	
	}
	
	public static String fetchResName(String rId)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String name=null;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select rName from restaurants where rId="+rId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) name=resultSet.getString(1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return name;
		
		
	}
	
	public static boolean check(String uname, String pass)  {

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection = DBConnection.getSQLConnection();
			System.out.println(uname +" "+pass);
		
			preparedStatement=connection.prepareStatement("Select * from users where usname like \""+uname+"\" and passwd like \""+pass+"\"");
			resultSet=preparedStatement.executeQuery();
			resultSet.beforeFirst();
			
			if(resultSet.next())
			{
				return true;
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
		}
		
		return false;
	}

	public static boolean addMenus(String parameter, String parameter2, String parameter3) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			System.out.println(DBLogic.noOfRecords("menus","mid"));
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("insert into menus values(?,?,?,?)");
			preparedStatement.setString(1, (DBLogic.noOfRecords("menus","mid")+1)+"" );
			preparedStatement.setString(2, parameter);
			preparedStatement.setString(3, parameter2);
			preparedStatement.setString(4, parameter3);
			
			if(preparedStatement.executeUpdate()>0)
				return true;
			else return false;
					
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
		}
		return false;
		
		
	}
	
	public static boolean removeOrders(String orderid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("delete from orders where orderid=?");
			preparedStatement.setString(1, orderid);
			
			if(preparedStatement.executeUpdate()>0)
				return true;
			else return false;
					
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
		}
		return false;
		
	}

	public static boolean addCategory(String parameter) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("insert into categories values(?)");
			preparedStatement.setString(1,parameter);
			
			
			if(preparedStatement.executeUpdate()>0)
				return true;
			else return false;
					
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
		}
		return false;

	}

	public static boolean removeMenu(String parameter) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("delete from menus where mid=?");
			preparedStatement.setString(1,parameter);
			
			
			if(preparedStatement.executeUpdate()>0)
				return true;
			else return false;
					
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
		}
		return false;
	}

	@SuppressWarnings("resource")
	public static boolean removeCat(String parameter) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("select * from menus where cname=?");
			preparedStatement.setString(1,parameter);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				DBLogic.removeMenu(resultSet.getString(1));
			}
			
			preparedStatement=connection.prepareStatement("delete from interface where cname=?");
			preparedStatement.setString(1,parameter);
			preparedStatement.executeUpdate();
			
				preparedStatement=connection.prepareStatement("delete from categories where cname=?");
				preparedStatement.setString(1,parameter);
							
				if(preparedStatement.executeUpdate()>0)
					return true;
				else return false;					
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
		}
		return false;
	}

	@SuppressWarnings("resource")
	public static boolean addRestaurant(String parameter, String parameter2, String parameter3, String parameter4,
			String parameter5) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int noOfRest=(DBLogic.noOfRecords("restaurants","rid"));
		try {
			connection=DBConnection.getSQLConnection();
		
			preparedStatement=connection.prepareStatement("insert into restaurants values(?,?,?,?,?,?)");
			preparedStatement.setString(1,(noOfRest+1)+"");
			preparedStatement.setString(2,parameter);

			preparedStatement.setString(3,parameter2);
			preparedStatement.setString(4,parameter3);
			preparedStatement.setString(5,parameter4);
			preparedStatement.setString(6,parameter5);
			
			if(preparedStatement.executeUpdate()>0)
			{
				preparedStatement=connection.prepareStatement("insert into cityandrest values(?,?)");
				preparedStatement.setString(1,parameter2);
				preparedStatement.setString(2,(noOfRest+1)+"");
				if(preparedStatement.executeUpdate()>0)
				{
					return true;
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
		}
		return false;
	}

	@SuppressWarnings("resource")
	public static boolean removeRestaurant(String parameter) {
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=DBConnection.getSQLConnection();
			preparedStatement=connection.prepareStatement("delete from cityandrest where rId=?");
			preparedStatement.setString(1,parameter);
			preparedStatement.executeUpdate();
			
			
			preparedStatement=connection.prepareStatement("delete from interface where rid=?");
			preparedStatement.setString(1,parameter);
			preparedStatement.executeUpdate();
			
				preparedStatement=connection.prepareStatement("delete from restaurants where rid=?");
				preparedStatement.setString(1,parameter);
							
				if(preparedStatement.executeUpdate()>0)
					return true;
				else return false;					
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
		}
		return false;
	}
		

	public static boolean placeOrder(String uname, String menuIds, String phone, String plates, String total,String rid) {
		boolean flag=false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date=new java.util.Date();
		System.out.println(rid);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int maxOrderId;
		try {
			maxOrderId=DBLogic.noOfRecords("orders", "orderid");
			connection=DBConnection.getSQLConnection();
			String sql="insert into orders values('"+uname+"','"+menuIds+"','"+(maxOrderId+1)+"','"+dateFormat.format(date)+"','"+phone+"','"+total+"','"+plates+"','"+rid+"')";
			preparedStatement=connection.prepareStatement(sql);
			
			if(preparedStatement.executeUpdate()>0)
				flag=true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
			DBConnection.closePreparedConnection(preparedStatement);
			DBConnection.closeResultSet(resultSet);
			
		}
		return flag;
	}
	
	
}		
	


	
	

	
	
