package web.homepage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledDocument;

import domain.Admin;
import domain.Friend;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class SendFriendsRequestServlet
 */
@WebServlet("/SendFriendsRequestServlet")
public class SendFriendsRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STUDENTDETAIL = "/WEB-INF/jsp/student/studentDetail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		Student student = (Student) session.getAttribute("student");
		HttpRequest httpRequest = new HttpRequest();

		Friend friend = new Friend();
		friend.setId(0);
		friend.setUid1(admin.getId());
		friend.setUid2(student.getUid());
		friend.setUname1(httpRequest.getStudentByStuId(admin.getId()).getName());
		friend.setUname2(student.getName());
		
		httpRequest.addFriends(friend);
		List<Friend> friend2 = httpRequest.getFriendsListById(admin.getId());
		int isFriend = 2;
		if (friend2 != null) {
			for (int i = 0; i < friend2.size(); i++) {
				if (friend2.get(i).getUid1() == student.getUid()||friend2.get(i).getUid2() ==  student.getUid()) {
					isFriend = friend2.get(i).getStatus();
				}
			}
		}
		session.setAttribute("isFriend", isFriend);
		request.getRequestDispatcher(STUDENTDETAIL).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
