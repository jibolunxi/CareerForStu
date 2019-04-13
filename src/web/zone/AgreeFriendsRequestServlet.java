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

/**
 * Servlet implementation class AgreeFriendsRequestServlet
 */
@WebServlet("/AgreeFriendsRequestServlet")
public class AgreeFriendsRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MESSGAE = "/WEB-INF/jsp/student/message.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		
		Admin admin = (Admin) session.getAttribute("admin");
		Admin admin2 = (Admin) session.getAttribute("admin2");
		
		Friend friend = new Friend();
		friend.setId(Integer.parseInt((String) session.getAttribute("friendId")));
		friend.setUid1(admin2.getId());
		friend.setUid2(admin.getId());
		friend.setStatus(1);
		httpRequest.updateFriends(friend);
		List<Friend> friend2 = httpRequest.getFriendsListById(admin.getId());
		int isFriend = 2;
		if (friend2 != null) {
			for (int i = 0; i < friend2.size(); i++) {
				if (httpRequest.getAdminById(friend2.get(i).getUid1()).getItem_id() == admin2.getItem_id()) {
					isFriend = friend2.get(i).getStatus();
				}
			}
		}
		session.setAttribute("friendId", null);
		session.setAttribute("isFriend", isFriend);
		List<Friend> messageList = httpRequest.getMessageListById(admin.getId());
		session.setAttribute("friendsList", messageList);
		request.getRequestDispatcher(MESSGAE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
