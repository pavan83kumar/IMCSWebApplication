package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Department;
import com.entities.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;

public class DepartmentServlet extends HttpServlet {

	DepartmentService deptService = new DepartmentService();
	EmployeeService service = new EmployeeService();

	private static final long serialVersionUID = 1L;

	public DepartmentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int deptNum = Integer.parseInt(request.getParameter("deptNo"));
		

		List<Employee> empObject = deptService.getEmployeesByDeptId(deptNum);
		if (empObject.isEmpty()) {
			request.setAttribute("msg", "Department Number doestn't exist");
			request.setAttribute("empObject", empObject);
			RequestDispatcher rd = request.getRequestDispatcher("Department.jsp");
			rd.forward(request, response);
		} else {

			request.setAttribute("empObject", empObject);
			RequestDispatcher rd = request.getRequestDispatcher("displayemployeebydeptid.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int deptNum = Integer.parseInt(request.getParameter("deptNo"));
		Department deptObject = service.getDepartment(deptNum);
		if (deptObject == null) {
			request.setAttribute("msg", "Department Number doestn't exist");
			request.setAttribute("deptObject", deptObject);
			RequestDispatcher rd = request.getRequestDispatcher("Department.jsp");
			rd.forward(request, response);
		}
		request.setAttribute("deptObject", deptObject);
		RequestDispatcher rd = request.getRequestDispatcher("Department.jsp");
		rd.forward(request, response);
	}

}
