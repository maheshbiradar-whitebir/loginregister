package loginregiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class regidao {

	public String adduser(regipojo rpojo) 
	{
		int i = 0;
		   int j = 0;
		   
		String q1 ="insert into regi values(?,?,?,?,?,?,?,?)";
		
		Dbadapter Dba = new Dbadapter();
		Connection con = Dba.dbconnect();
		
		
		try {
			PreparedStatement pst = con.prepareStatement(q1);
			
			pst.setInt(1,rpojo.getRid()); 
			pst.setString(2,rpojo.getName()); 
			pst.setString(3,rpojo.getEmail());
			pst.setString(4,rpojo.getPwd());
			pst.setString(5,rpojo.getGender());
			pst.setString(6,rpojo.getCountry());
			pst.setLong(7,rpojo.getPhno());
			pst.setString(8,rpojo.getRdate());
			
			i = pst.executeUpdate();
			
			
			  String sql2 ="insert into login values(?,?)";
						
						pst = con.prepareStatement(sql2);
						
						pst.setString(1, rpojo.getEmail());
						pst.setString(2, rpojo.getPwd());
						
						j= pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	
	    if(i>0 && j>0)
	    	return "sucess";
	    else 
	    	return "error";
	    	
	}
}
