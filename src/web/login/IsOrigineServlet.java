package web.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Origine;
import utils.HttpRequest;


@WebServlet("/IsOrigineServlet")
public class IsOrigineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		HttpRequest httpRequest = new HttpRequest();
		Origine origine = httpRequest.getOrigineByNumber(number);
        response.setContentType("text/xml;charset=utf-8");
        PrintWriter out=response.getWriter();

        if(origine == null){
            System.out.print(1);
            out.println("<msg>NotExist</msg>");
        }else if(origine.getIs_registered()!=0){
            out.println("<msg>Registed</msg>");
        }else if(!origine.getName().equals(name)){
            out.println("<msg>Wrong</msg>");
        }else {
        	out.println("<msg>True</msg>");
		}
        out.flush();
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
