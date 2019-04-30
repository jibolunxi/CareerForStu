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
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class MessageDetailServlet
 */
@WebServlet("/MessageDetailServlet")
public class MessageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGEDETAIL = "/WEB-INF/jsp/student/messageDetail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");

		HttpRequest httpRequest = new HttpRequest();
		String stuId = request.getParameter("stuId");
		String friendId = request.getParameter("friendId");

		Student student = httpRequest.getStudentByStuId(Integer.parseInt(stuId));
		session.setAttribute("student", student);

		List<Friend> friend = httpRequest.getFriendsListById(admin.getId());
		int isFriend = 2;
		if (friend != null) {
			for (int i = 0; i < friend.size(); i++) {
				System.out.println(friend.get(i).getUid1());
				if (friend.get(i).getUid1() == Integer.parseInt(stuId)) {
					isFriend = friend.get(i).getStatus();
				}
			}
		}
		if (student.getResume_photo()!=null&&!student.getResume_photo().equals("")) {
			student.setResume_photo("http://47.96.70.17/career/"+student.getResume_photo());
		}else {
			student.setResume_photo("images/student.png");
	  }
		session.setAttribute("friendId", friendId);
		session.setAttribute("student", student);
		session.setAttribute("isFriend", isFriend);
		request.getRequestDispatcher(MESSAGEDETAIL).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
