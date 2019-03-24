package web.zone;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;
import domain.StudentEdu;
import domain.StudentExp;
import utils.HttpRequest;

/**
 * Servlet implementation class MyResumeServlet
 */
@WebServlet("/MyResumeServlet")
public class MyResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String RESUME = "/WEB-INF/jsp/student/resume.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		Admin admin = (Admin) session.getAttribute("admin");
		StudentExp studentExp = httpRequest.getStudentExpById(admin.getId());
		List<StudentEdu> studentEduList = httpRequest.getStudentEduListById(admin.getId());
		if (studentEduList != null) {
			for (int i = 0; i < studentEduList.size(); i++) {
				studentEduList.get(i).setStarttime(studentEduList.get(i).getStarttime().substring(0, 10));
				studentEduList.get(i).setEndtime(studentEduList.get(i).getEndtime().substring(0, 10));
			}
		}
		session.setAttribute("studentExp", studentExp);
		session.setAttribute("studentEduList", studentEduList);
		request.getRequestDispatcher(RESUME).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
