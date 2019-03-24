package web.homepage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.News;
import utils.HttpRequest;

/**
 * Servlet implementation class NewsDetailServlet
 */
@WebServlet("/NewsDetailServlet")
public class NewsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NEWSDETAIL = "/WEB-INF/jsp/student/newsDetail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		HttpRequest httpRequest = new HttpRequest();
		HttpSession session = request.getSession();
		News news = httpRequest.getNewsById(newsId);
		session.setAttribute("news", news);
		request.getRequestDispatcher(NEWSDETAIL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
