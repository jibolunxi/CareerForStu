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
import domain.Friends;
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

		HttpRequest httpRequest = new HttpRequest();
		Admin admin2 = (Admin) session.getAttribute("admin2");
		Friends friend = new Friends();
		friend.setId(0);
		friend.setUid1(admin.getId());
		friend.setUid2(admin2.getId());
		friend.setUname1(httpRequest.getStudentByStuId(admin.getItem_id()).getName());
		if ("student".equals(admin2.getType())) {
			friend.setUname2(httpRequest.getStudentByStuId(admin2.getItem_id()).getName());
		}else if ("company".equals(admin2.getType())) {
			friend.setUname2(httpRequest.getCompanyById(admin2.getItem_id()).getName());
		}
		
		httpRequest.addFriends(friend);
		List<Friends> friends = httpRequest.getFriendsListById(admin.getId());
		int isFriend = 2;
		if (friends != null) {
			for (int i = 0; i < friends.size(); i++) {
				System.out.println(friends.get(i).getUid1());
				if (friends.get(i).getUid2() == admin2.getId()) {
					isFriend = friends.get(i).getStatus();
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
