package web.homepage;

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
import domain.Friends;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/StudentDetailServlet")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String STUDENTDETAIL = "/WEB-INF/jsp/student/studentDetail.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");

		String stuId = request.getParameter("stuId");
		String studentId = request.getParameter("studentId");
		HttpRequest httpRequest = new HttpRequest();
		Student student = new Student();
		if (stuId != null) {
			student = httpRequest.getStudentByStuId(Integer.parseInt(stuId));
			session.setAttribute("student", student);
		} else if(studentId != null) {
			student = httpRequest.getStudentByStuId(Integer.parseInt(studentId));
			session.setAttribute("student", student);
		}else {
			student = (Student) session.getAttribute("student");
		}

		List<Friends> friends = httpRequest.getFriendsListById(admin.getId());
		int isFriend = 2;
		if (friends != null) {
			for (int i = 0; i < friends.size(); i++) {
				if (friends.get(i).getUid1() == student.getUid()||friends.get(i).getUid2() ==  student.getUid()) {
					isFriend = friends.get(i).getStatus();
				}
			}
		}
		session.setAttribute("isFriend", isFriend);
		request.getRequestDispatcher(STUDENTDETAIL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
