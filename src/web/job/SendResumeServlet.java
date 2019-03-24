package web.job;

import java.io.IOException;
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
import domain.CompanyJob;
import domain.Friends;
import domain.JobApply;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class SendResumeServlet
 */
@WebServlet("/SendResumeServlet")
public class SendResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JOBRECOMMENDDETAIL = "/WEB-INF/jsp/student/jobRecommendDetail.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpRequest httpRequest = new HttpRequest();
		HttpSession session = request.getSession();
		
		Student student = (Student) session.getAttribute("mystudent");
		CompanyJob companyJob = (CompanyJob) session.getAttribute("companyJob");
		JobApply jobApply = new JobApply();
		jobApply.setId(0);
		jobApply.setUid(student.getUid());
		jobApply.setJob_id(companyJob.getId());
		jobApply.setJob_name(companyJob.getName());
		jobApply.setCom_id(companyJob.getCom_id());
		jobApply.setCom_name(companyJob.getCom_name());
		jobApply.setStatus(0);
		httpRequest.sendResume(jobApply);

		session.setAttribute("isSend", 1);
		companyJob.setSnum(companyJob.getSnum()+1);
		httpRequest.updateJob(companyJob);
		request.getRequestDispatcher(JOBRECOMMENDDETAIL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
