package loginregiproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbadapter implements Dbservice{
 
	@Override
	public Connection dbconnect() {
		Connection con = null ;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginregidb","root","password");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return con;
	}

	
}
