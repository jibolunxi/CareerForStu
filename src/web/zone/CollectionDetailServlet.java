package web.zone;

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

import domain.Admin;
import domain.CompanyJob;
import domain.StuFavorite;
import utils.HttpRequest;



@WebServlet("/CollectionDetailServlet")
public class CollectionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COLLECTJOB = "/WEB-INF/jsp/student/collectJob.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");

		String jobIdS = request.getParameter("jobId");
		if (!jobIdS.equals("-1")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date date = new Date();
			HttpRequest httpRequest = new HttpRequest();
			int jobId = Integer.parseInt(jobIdS);

			CompanyJob companyJob = httpRequest.getCompanyJobById(jobId);
			
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
			session.setAttribute("companyJob", companyJob);
			request.getRequestDispatcher(COLLECTJOB).forward(request, response);
		} else {
			request.getRequestDispatcher(COLLECTJOB).forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
