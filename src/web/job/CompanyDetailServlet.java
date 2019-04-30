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
import domain.Company;
import domain.Friend;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class CompanyDetailServlet
 */
@WebServlet("/CompanyDetailServlet")
public class CompanyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COMPANYDETAIL = "/WEB-INF/jsp/student/companyDetail.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String companyId = request.getParameter("companyId");
		HttpRequest httpRequest = new HttpRequest();
		Company company = new Company();
		
		company = httpRequest.getCompanyById(Integer.parseInt(companyId));
		if (company.getLogo()!=null&&!company.getLogo().equals("")) {
			company.setLogo("http://47.96.70.17/career/"+company.getLogo());
		}else {
			company.setLogo("images/company.png");
		}
		session.setAttribute("company", company);
		request.getRequestDispatcher(COMPANYDETAIL).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
