package web.homepage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.College;
import domain.Department;
import utils.HttpRequest;

/**
 * Servlet implementation class GetDepartmentServlet
 */
@WebServlet("/GetDepartmentServlet")
public class GetDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEPTLIST = "/WEB-INF/jsp/student/deptList.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		int collegeId = (int) session.getAttribute("home_collegeId");
		List<Department> departments = httpRequest.getDepartmentListByCollegeId(collegeId);
		session.setAttribute("departments", departments);
		request.getRequestDispatcher(DEPTLIST).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
