package utils;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class BackFilter
 */
/*@WebFilter(filterName="/BackFilter",
		urlPatterns="/*",
		initParams= {@WebInitParam(name = "charset", value = "utf-8")}
		)*/
public class BackFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BackFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session = req.getSession();
		String uri=req.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/")+1);
//		System.out.println(uri);
//		System.out.println(req.getRequestURI());
		if(uri.toString().contains(".css") || uri.toString().contains(".js") || uri.toString().contains(".png")|| uri.toString().contains(".do")){
			 chain.doFilter(request, response);
		 }

		if ( uri.equals("studentHomePage")) {
//			System.out.println("1");
			session.setAttribute("backurl", uri);
			chain.doFilter(request, response);
			return;
		}else if (req.getSession().getAttribute("admin") != null) {
//			System.out.println("2");
			
			
			
			if(uri.equals("jobRecommendDetail"))
			{
			uri=uri+"?"+"companyJobId="+req.getParameter("companyJobId");
			System.out.println(uri);
			session.setAttribute("backurl", uri);
			}			else if(uri.equals("myFriends")){
				session.setAttribute("backurl", uri);
			}else if(uri.equals("studentMessage")){
				session.setAttribute("backurl", uri);
			}else if(uri.equals("studentCollection")){
				session.setAttribute("backurl", uri);
			}else if(uri.equals("studentZone")){
				session.setAttribute("backurl", null);
			}else {
				
			}
				
			System.out.println(session.getAttribute("backurl"));
			// pass the request along the filter chain
			chain.doFilter(request, response);
			
			return;
			
			
		}else {
			if ("toRegistration".equals(uri)) {
				System.out.println("1");
				chain.doFilter(request, response);
	            return;
			}else if ("registration".equals(uri)) {
				System.out.println("2");
				chain.doFilter(request, response);
	            return;
	        }else {
				System.out.println("2222");
				request.getRequestDispatcher("/WEB-INF/jsp/student/login.jsp").forward(request, response);
	            return;
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器初始化");
	}

}
