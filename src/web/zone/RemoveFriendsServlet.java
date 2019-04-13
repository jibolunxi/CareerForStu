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
import domain.Friend;
import domain.Student;
import utils.HttpRequest;

@WebServlet("/RemoveFriendsServlet")
public class RemoveFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STUDENTDETAIL = "/WEB-INF/jsp/student/studentDetail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		Admin admin = (Admin) session.getAttribute("admin");
		Admin admin2 = (Admin) session.getAttribute("admin2");
		Friend friend = new Friend();
		friend.setUid1(admin2.getId());
		friend.setUid2(admin.getId());
		httpRequest.removeFriends(friend);
		friend.setUid1(admin.getId());
		friend.setUid2(admin2.getId());
		httpRequest.removeFriends(friend);
		List<Friend> friend2 = httpRequest.getFriendsListById(admin.getId());
		int isFriend = 2;
		if (friend2 != null) {
			for (int i = 0; i < friend2.size(); i++) {
				if (friend2.get(i).getUid1() == admin2.getId()||friend2.get(i).getUid2() == admin2.getId()) {
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
