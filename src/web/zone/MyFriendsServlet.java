package web.zone;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import domain.Admin;
import domain.Company;
import domain.Friend;
import domain.JobInterview;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class MyFriendsServlet
 */
@WebServlet("/MyFriendsServlet")
public class MyFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MYFRIENDS = "/WEB-INF/jsp/student/myFriends.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		HttpRequest httpRequest = new HttpRequest();
		Admin admin = (Admin) session.getAttribute("admin");
		List<Friend> friends = httpRequest.getFriendsListById(admin.getId());
		if (friends != null) {
			for(Friend friend : friends) {
				Student student = new Student();
				if (friend.getUid1() == admin.getId()) {
					student = httpRequest.getStudentById(friend.getUid2());
				}else {
					student = httpRequest.getStudentById(friend.getUid1());
				}
				if (student.getResume_photo()!=null&&!student.getResume_photo().equals("")) {
					friend.setResume_photo("http://47.96.70.17/career/"+student.getResume_photo());
				}else {
					friend.setResume_photo("images/student.png");
				}
			}
		}
		session.setAttribute("friends", friends);
		request.getRequestDispatcher(MYFRIENDS).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
