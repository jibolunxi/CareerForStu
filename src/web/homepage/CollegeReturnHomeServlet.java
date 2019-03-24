package web.homepage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.News;
import utils.HttpRequest;

/**
 * Servlet implementation class CollegeReturnHomeServlet
 */
@WebServlet("/CollegeReturnHomeServlet")
public class CollegeReturnHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STUDENTHOMEPAGE = "/WEB-INF/jsp/student/studentHomePage.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		String collegeName = request.getParameter("collegeName");
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		session.setAttribute("home_collegeId", collegeId);
		session.setAttribute("home_collegeName", collegeName);
		
		List<News> newsList = httpRequest.getNewsListByColId(collegeId);
		if (newsList!=null) {
			News news = new News();
			news = newsList.get(0);
			news.setCtime(news.getCtime().substring(0, 10));
			session.setAttribute("homepage_news", news);
		}else {
			session.setAttribute("homepage_news", null);
		}
		session.setAttribute("newsList", newsList);
		request.getRequestDispatcher(STUDENTHOMEPAGE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
