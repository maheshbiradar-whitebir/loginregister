

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginregiproject.logindao;
import loginregiproject.loginpojo;

/**
 * Servlet implementation class loginctrl
 */
@WebServlet("/loginctrl")
public class loginctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginctrl() {
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
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		loginpojo lpojo = new loginpojo(email, pwd);
//		
//		lpojo.setEmail(email);
//		lpojo.setPwd(pwd);a
//		
		
		logindao da = new logindao();
		   String str =da.validateuser(lpojo);
		//   pw.print(str);
		   if(str.equals("success"))
		   {
			   RequestDispatcher rd = request.getRequestDispatcher("https://www.google.com");
//			   rd.forward(request, response);
			   response.sendRedirect("https://www.google.com");
			   
		   }
		else {
			//login with error message
			pw.print("incorrect user name and pass");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
					
		}
	
		
	}

}
