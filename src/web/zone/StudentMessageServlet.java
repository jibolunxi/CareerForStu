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
import domain.JobApply;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/StudentMessageServlet")
public class StudentMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "/WEB-INF/jsp/student/message.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		Admin admin = (Admin) session.getAttribute("admin");
		List<Friend> messageList = httpRequest.getMessageListById(admin.getId());
		if (messageList != null) {
			for(Friend friend : messageList) {
				  Student student = httpRequest.getStudentById(friend.getUid1());
				  if (student.getResume_photo()!=null&&!student.getResume_photo().equals("")) {
					  	friend.setResume_photo("http://47.96.70.17/career/"+student.getResume_photo());
					}else {
						friend.setResume_photo("images/student.png");
				  }
			}
		}
		session.setAttribute("friendsList", messageList);
		request.getRequestDispatcher(MESSAGE).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
