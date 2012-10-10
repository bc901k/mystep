package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;



public class DBTest {
//	@Test
	public static String dbUrl = "jdbc:mysql://localhost:3306/test";
	public static String dbClass = "com.mysql.jdbc.Driver";
	
	public void dbTest(){

		try {
			String query = "Select * FROM polling";
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection (dbUrl);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			String id = "";
			String value = "";
			String time = "";
			String name = "";

			while (rs.next()) {
				id = rs.getString(1);
				value = rs.getString(2);
				time = rs.getString(3);
				name = rs.getString(4);
				System.out.println(id);
				System.out.println(value);
				System.out.println(time);
				System.out.println(name);
			} //end while

			con.close();
		} //end try

		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch(SQLException e) {
			e.printStackTrace();
		}

	}  //end main
	
	public synchronized void dbInsertPolledData(List<String> list){

		try {
			String value = list.get(0);
			String name = list.get(1);
			
			String query = "INSERT INTO polling VALUES (null, "+value+", now(), '"+name+"')";
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection (dbUrl);
			Statement stmt = con.createStatement();
			stmt.execute(query);
			stmt.close();
			con.close();
		} //end try

		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch(SQLException e) {
			e.printStackTrace();
		}

	}  //end main
}
