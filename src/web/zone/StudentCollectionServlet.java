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
import domain.CompanyCollection;
import domain.JobInterview;
import domain.StuFavorite;
import utils.HttpRequest;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/StudentCollectionServlet")
public class StudentCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COLLECTION = "/WEB-INF/jsp/student/collection.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		Admin admin = (Admin) session.getAttribute("admin");
		List<StuFavorite> stuFavorites = httpRequest.getStuFavoriteListById(admin.getId());
		if (stuFavorites != null) {
			for(StuFavorite stuFavorite : stuFavorites) {
				Company company = httpRequest.getCompanyById(stuFavorite.getCom_id());
				if (company.getLogo()!=null&&!company.getLogo().equals("")) {
					stuFavorite.setCompany_logo("http://47.96.70.17/career/"+company.getLogo());
				}else {
					stuFavorite.setCompany_logo("images/company.png");
				}
			}
		}
		session.setAttribute("stuFavorites", stuFavorites);
		request.getRequestDispatcher(COLLECTION).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
