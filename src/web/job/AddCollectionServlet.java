package web.job;

import java.io.IOException;
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

/***
 * Servlet implementation class AddCollectionServlet
 */
@WebServlet("/AddCollectionServlet")
public class AddCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JOBRECOMMENDDETAIL = "/WEB-INF/jsp/student/jobRecommendDetail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		CompanyJob companyJob = (CompanyJob) session.getAttribute("companyJob");

		Admin admin = (Admin) session.getAttribute("admin");

		StuFavorite stuFavorite = new StuFavorite();
		stuFavorite.setId(0);
		stuFavorite.setUid(admin.getId());
		stuFavorite.setCom_id(companyJob.getCom_id());
		stuFavorite.setCom_name(companyJob.getCom_name());
		stuFavorite.setJob_id(companyJob.getId());
		stuFavorite.setJob_name(companyJob.getName());
		httpRequest.collectJob(stuFavorite);
		session.setAttribute("isStar", 1);
		request.getRequestDispatcher(JOBRECOMMENDDETAIL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
