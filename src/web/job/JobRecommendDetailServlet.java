package web.job;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import domain.Admin;
import domain.Company;
import domain.CompanyJob;
import domain.StuFavorite;
import utils.HttpRequest;

/**
 * Servlet implementation class JobRecommendDetailServlet
 */
@WebServlet("/JobRecommendDetailServlet")
public class JobRecommendDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JOBRECOMMENDDETAIL = "/WEB-INF/jsp/student/jobRecommendDetail.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		Admin admin = (Admin) session.getAttribute("admin");

		String jobIdS = request.getParameter("companyJobId");
		if (!jobIdS.equals("-1")) {

			int jobId = Integer.parseInt(jobIdS);
			CompanyJob companyJob = httpRequest.getCompanyJobById(jobId);
			Company company = httpRequest.getCompanyById(companyJob.getCom_id());
			if (company.getLogo()!=null&&!company.getLogo().equals("")) {
				companyJob.setLogo("http://47.96.70.17/career/"+company.getLogo());
			}else {
				companyJob.setLogo("images/company.png");
			}
			boolean isCollect = false;
			List<StuFavorite> collectList = httpRequest.getStuFavoriteListById(admin.getId());
			if (collectList != null) {
				for (int i = 0; i < collectList.size(); i++) {
					if (collectList.get(i).getJob_id() == companyJob.getId()) {
						isCollect = true;
					}
				}
			}
			if (isCollect) {
				session.setAttribute("isStar", 1);
			} else {
				session.setAttribute("isStar", 0);
			}
			
			int isSend = httpRequest.isSend(jobId,admin.getId());
			
			session.setAttribute("isSend", isSend);

			companyJob.setJobhits(companyJob.getJobhits()+1);
			httpRequest.updateJob(companyJob);
			session.setAttribute("companyJob", companyJob);
			request.getRequestDispatcher(JOBRECOMMENDDETAIL).forward(request, response);
		} else {
			request.getRequestDispatcher(JOBRECOMMENDDETAIL).forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
