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
import domain.Friend;
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
		List<Friend> friend = httpRequest.getFriendsListById(admin.getId());
		session.setAttribute("friends", friend);
		request.getRequestDispatcher(MYFRIENDS).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
