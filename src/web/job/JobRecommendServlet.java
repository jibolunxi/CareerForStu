package web.job;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;
import domain.CompanyJob;
import domain.JobExpect;
import utils.HttpRequest;

/**
 * Servlet implementation class CompanyRecruitmentServlet
 */
@WebServlet("/JobRecommendServlet")
public class JobRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JOBRECOMMEND = "/WEB-INF/jsp/student/jobRecommend.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		Admin admin = (Admin) session.getAttribute("admin");
		if (session.getAttribute("companyJobs")==null) {
			List<JobExpect> jobExpects = httpRequest.getJobExpectListById(admin.getId());
			if (jobExpects!=null) {
				List<CompanyJob> companyJobs = httpRequest.getCompanyJobListByHyname(jobExpects.get(0).getHy_name());
				session.setAttribute("companyJobs", companyJobs);
			} else {
				List<CompanyJob> companyJobs = httpRequest.getCompanyJobList();
				session.setAttribute("companyJobs", companyJobs);
			}
		}
		request.getRequestDispatcher(JOBRECOMMEND).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
