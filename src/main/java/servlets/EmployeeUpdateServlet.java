package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Employee;
import com.service.EmployeeService;

public class EmployeeUpdateServlet extends HttpServlet {
	EmployeeService service = new EmployeeService();

	private static final long serialVersionUID = 1L;

	public EmployeeUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int empNo = Integer.parseInt(request.getParameter("empNo"));
		String operations = request.getParameter("operations");
		if (operations != null && operations.equals("updateOperFrmDept")) {
			request.setAttribute("pageType", "updateOperFrmDept");
		} else {
			request.setAttribute("pageType", "fromEmployee");
		}
		Employee emp = service.getEmployeeById(empNo);
		request.setAttribute("empObject", emp);
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Back from JSP");
		RequestDispatcher rd = null;
		String url = "/Employee.jsp";
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD");
		Date dob = null;
		try {
			dob = date.parse(request.getParameter("DoB"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Date doj = null;
		try {
			doj = date.parse(request.getParameter("DoJ"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		int salary = Integer.parseInt(request.getParameter("salary"));
		int salGrade = Integer.parseInt(request.getParameter("salgrade"));

		Employee emp = new Employee(empNo, deptNo, doj, dob, salary, salGrade);
		try {
			service.loadEmployeeWithOutId(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean result = service.updateEmployee(empNo, emp);

		if (result = true) {
			request.setAttribute("msg", "Employee Number " + empNo + " updated successfully");
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Employee Number " + empNo + "doesn't exist");
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		}
	}

}
