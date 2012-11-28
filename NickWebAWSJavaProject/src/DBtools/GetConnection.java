package DBtools;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

public class GetConnection {

	
	public void dbTest(){

		String dbUrl 			= "jdbc:mysql://localhost:3306/test";
		String dbClass 		= "com.mysql.jdbc.Driver";
		
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
	}
		/**
		 * 
		 * @param String sql
		 * @return String resultMsg
		 */
		public static String excuteUpdateToRDS(String sql){

			Properties prop 	= new Properties();
			String dbClass 		= "com.mysql.jdbc.Driver";
			String resultMsg 	= "fail to quering";
			try {
				prop.load(new FileInputStream("DB.properties"));
				
				String RDSUrl = prop.getProperty("RDSUrl");
				byte[] decoded = Base64.decodeBase64(RDSUrl.getBytes());
				RDSUrl = new String(decoded);
				
				String RDSuser = prop.getProperty("RDSuser");
				decoded = Base64.decodeBase64(RDSuser.getBytes());
				RDSuser = new String(decoded);
				
				String RDSpassword = prop.getProperty("RDSpassword");
				decoded = Base64.decodeBase64(RDSpassword.getBytes());
				RDSpassword = new String(decoded);		        

				Class.forName(dbClass);
				Connection con = DriverManager.getConnection (RDSUrl,RDSuser,RDSpassword);
				Statement stmt = con.createStatement();
				int rs = stmt.executeUpdate(sql);
				if (rs==1) resultMsg = "success to quering";

				con.close();
			} //end try

			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}

			catch(SQLException e) {
				e.printStackTrace();
			}
			
			catch (IOException ex) {
	    		ex.printStackTrace();
			}
			return resultMsg;

	}  //end main
}
