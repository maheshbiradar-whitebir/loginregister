

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginregiproject.regidao;
import loginregiproject.regipojo;

/**
 * Servlet implementation class regictrl
 */
@WebServlet("/regictrl")
public class regictrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regictrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String  pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String phno = request.getParameter("phno");
		
		regipojo rpojo = new regipojo();
		rpojo.setRid(0);
		rpojo.setName(name);
		rpojo.setEmail(email);
		rpojo.setCountry(country);
		rpojo.setGender(gender);
		rpojo.setPwd(pwd);
		rpojo.setPhno(Long.parseLong(phno));
		
//		Calendar c =Calendar.getInstance();
//		
//		int d =c.get(Calendar.DATE);
//		int m =c.get(Calendar.MONTH) +1;
//		int y =c.get(Calendar.YEAR);
//		
//		String rdate =d +"/" +m+"/"+y;
		
		LocalDate rdate = LocalDate.now();
		
		rpojo.setRdate(rdate.toString());
		
		regidao da = new regidao();
		String st = da.adduser(rpojo);
		
		
//		pw.print("sucess");
		 if(st.equals("sucess"))
		   {
			   RequestDispatcher rd = request.getRequestDispatcher("login.html");
			   rd.forward(request, response);
			   
		   }
		else {
			//login with error message
			pw.print("incorrect data");
			RequestDispatcher rd = request.getRequestDispatcher("regi.html");
			rd.include(request, response);
		}
		
		
	}

}
