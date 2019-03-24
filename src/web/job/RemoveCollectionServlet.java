package web.job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;
import domain.Comfavorite;
import domain.Company;
import domain.CompanyJob;
import domain.StuFavorite;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class RemoveCollectionServlet
 */
@WebServlet("/RemoveCollectionServlet")
public class RemoveCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COLLECTJOB = "/WEB-INF/jsp/student/collectJob.jsp";
	private static final String COLLECTION = "/WEB-INF/jsp/student/collection.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		
		CompanyJob companyJob = (CompanyJob) session.getAttribute("companyJob");
		Admin admin = (Admin) session.getAttribute("admin");
		
		httpRequest.removeCollectJob(companyJob.getId(), admin.getId());
		if (((String) session.getAttribute("backurl")).equals("studentCollection")) {
			List<StuFavorite> stuFavorites = httpRequest.getStuFavoriteListById(admin.getId());
			session.setAttribute("stuFavorites", stuFavorites);
			request.getRequestDispatcher(COLLECTION).forward(request, response);
		} else {
			session.setAttribute("isStar", 0);
			request.getRequestDispatcher(COLLECTJOB).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
