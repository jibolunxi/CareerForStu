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
import domain.Company;
import domain.Friend;
import domain.JobInterview;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class InterviewDetailServlet
 */
@WebServlet("/InterviewDetailServlet")
public class InterviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INTERVIEWDETAIL = "/WEB-INF/jsp/student/interviewDetail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");

		HttpRequest httpRequest = new HttpRequest();
		String interviewId = request.getParameter("interviewId");
		
		JobInterview jobInterview = httpRequest.getInterviewById(Integer.parseInt(interviewId));
		
		session.setAttribute("jobInterview", jobInterview);
		request.getRequestDispatcher(INTERVIEWDETAIL).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
