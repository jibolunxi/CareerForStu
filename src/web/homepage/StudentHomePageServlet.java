package web.homepage;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;
import domain.News;
import domain.Student;
import utils.HttpRequest;
import utils.MD5;

@WebServlet("/StudentHomePageServlet")
public class StudentHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN = "/WEB-INF/jsp/student/login.jsp";
	private static final String STUDENTHOMEPAGE = "/WEB-INF/jsp/student/studentHomePage.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		request.setCharacterEncoding("utf-8");
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			String studentName = request.getParameter("studentName");
			String password = request.getParameter("password");
			
			if(studentName != null && password != null && !studentName.equals("") && !password.equals("")) {
				admin = httpRequest.getAdminByName(studentName);
				if (admin == null) {
					if (isInteger(studentName)) {
						admin = httpRequest.getAdminByPhone(studentName);
					}
				}
				if (admin != null) {
						try {
							if ("student".equals(admin.getType())&&MD5.verify(password, "", admin.getPassword())) {
								admin.setLogin(true);
								Student student = httpRequest.getStudentByStuId(admin.getId());
								session.setAttribute("admin", admin);
								session.setAttribute("mystudent", student);
								if (session.getAttribute("homepage_students")==null) {
									List<Student> students = httpRequest.getStudentListByCollege(student.getCollege_id(), student.getDept_id());
									session.setAttribute("homepage_students", students);
									session.setAttribute("home_collegeId", student.getCollege_id());
									session.setAttribute("home_collegeName", student.getCollege_name());
									session.setAttribute("home_deptId", student.getDept_id());
									session.setAttribute("home_deptName", student.getDept_name());
								}
								if (session.getAttribute("homepage_news")==null) {
									List<News> newsList = httpRequest.getNewsListByColId(student.getCollege_id());
									if (newsList!=null) {
										News news = new News();
										news = newsList.get(0);
										news.setCtime(news.getCtime().substring(0, 10));
										session.setAttribute("homepage_news", news);
									}else {
										session.setAttribute("homepage_news", null);
									}
									session.setAttribute("newsList", newsList);
								}
								request.getRequestDispatcher(STUDENTHOMEPAGE).forward(request, response);
							}else {
								session.setAttribute("isRight", "账号和密码不匹配");
								request.getRequestDispatcher(LOGIN).forward(request, response);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							session.setAttribute("isRight", "账号和密码不匹配");
							request.getRequestDispatcher(LOGIN).forward(request, response);
						}
				}else {
					session.setAttribute("isRight", "用户不存在");
					request.getRequestDispatcher(LOGIN).forward(request, response);
				}
			}else {
				session.setAttribute("isRight", "账号或密码不能为空");
				request.getRequestDispatcher(LOGIN).forward(request, response);
			}
		}else {
			request.getRequestDispatcher(STUDENTHOMEPAGE).forward(request, response);
		}
	}
	
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
}
