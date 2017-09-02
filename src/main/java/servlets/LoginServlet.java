package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmployeeService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Login Servlet");
		RequestDispatcher rd = null;
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		EmployeeService service = new EmployeeService();
		System.out.println("uname "+uname + " pwd " +pwd);
		boolean  result = service.authenticatingUser(uname, pwd);
		System.out.println(result);
		
		if(result == true){
			
			rd = request.getRequestDispatcher("/homepage.html");
					rd.forward(request, response);
		}
		else{
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
		}
		
	}

}
