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

public class EmployeeAddServlet extends HttpServlet {

	EmployeeService service = new EmployeeService();
	private static final long serialVersionUID = 1L;

	public EmployeeAddServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In the servlet");
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

		Employee emp = new Employee(deptNo, doj, dob, salary, salGrade);
		try {
			service.loadEmployeeWithOutId(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("empObject", emp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayemployee.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
