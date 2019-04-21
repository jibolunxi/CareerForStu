package web.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Admin;
import domain.Origine;
import domain.Student;
import utils.HttpRequest;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN = "/WEB-INF/jsp/student/login.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpRequest httpRequest = new HttpRequest();
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Origine origine = httpRequest.getOrigineByNumber(number);
		if (origine != null) {
			if (origine.getIs_registered()==0) {
				if (origine.getName().equals(name)) {
					Admin admin = new Admin();
					admin.setId(0);
					admin.setName(account);
					admin.setPassword(password);
					admin.setType("student");
					admin.setMobile(phone);
					httpRequest.addAdmin(admin);
					admin = httpRequest.getAdminByName(account);
					Student student = new Student();
					student.setId(0);
					student.setUid(admin.getId());
					student.setName(name);
					student.setSex(origine.getSex());
					student.setTelphone(phone);
					student.setCollege_id(origine.getCollege_id());
					student.setCollege_name(origine.getCollege_name());
					student.setDept_id(origine.getDept_id());
					student.setDept_name(origine.getDept_name());
					student.setMajor_id(origine.getMajor_id());
					student.setMajor_name(origine.getMajor_name());
					student.setEdu_id(origine.getEdu_id());
					student.setEdu(origine.getEdu());
					httpRequest.addStudent(student);
					origine.setIs_registered(1);
					httpRequest.updateOrigine(origine);
					request.getRequestDispatcher(LOGIN).forward(request, response);
				}else {
					request.getRequestDispatcher(LOGIN).forward(request, response);
				}
			}else {
				request.getRequestDispatcher(LOGIN).forward(request, response);
			}
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
