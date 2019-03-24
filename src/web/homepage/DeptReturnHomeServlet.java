package web.homepage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class DeptReturnHomeServlet
 */
@WebServlet("/DeptReturnHomeServlet")
public class DeptReturnHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STUDENTHOMEPAGE = "/WEB-INF/jsp/student/studentHomePage.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		HttpRequest httpRequest = new HttpRequest();
		String deptName = request.getParameter("deptName");
		HttpSession session = request.getSession();
		session.setAttribute("home_deptId", deptId);
		session.setAttribute("home_deptName", deptName);
		List<Student> students = httpRequest.getStudentListByCollege((int)session.getAttribute("home_collegeId"),deptId);
		session.setAttribute("homepage_students", students);
		request.getRequestDispatcher(STUDENTHOMEPAGE).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
