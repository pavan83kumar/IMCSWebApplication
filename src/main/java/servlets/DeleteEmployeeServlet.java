package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Employee;
import com.service.EmployeeService;

public class DeleteEmployeeServlet extends HttpServlet {
	EmployeeService service = new EmployeeService();
	private static final long serialVersionUID = 1L;

	public DeleteEmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		//if(empNo ==  )
		service.deleteEmployee(empNo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Employee.jsp");
		request.setAttribute("msg", "user deleted successfully");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		String operations = request.getParameter("operations");
		if (operations != null && operations.equals("updateOperFrmDept")) {
			request.setAttribute("pageType", "updateOperFrmDept");
		} else {
			request.setAttribute("pageType", "fromEmployee");
		}
		Employee emp = service.getEmployeeById(empNo);
		System.out.println();
		//System.out.println(emp.toString());
		request.setAttribute("empObject", emp);
		RequestDispatcher rd = request.getRequestDispatcher("displayemployee.jsp");
		rd.forward(request, response);
	}

}
