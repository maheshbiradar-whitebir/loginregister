package loginregiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logindao {

	public String validateuser(loginpojo lpojo)
	{  
		String str ="";
		String q = "select * from login where useremail=? and password =? ";
		
		  try {
		PreparedStatement pst	=new Dbadapter().dbconnect().prepareStatement(q);
//		
//		Dbadapter Dba = new Dbadapter();
//		Connection con = Dba.dbconnect();
			
			pst.setString(1,lpojo.getEmail());
			pst.setString(2,lpojo.getPwd());
			
			ResultSet rs = pst.executeQuery();
			
			
			if(rs.next())
				str ="success";
			else
				str="error";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  

		
		return str;
	}
}
