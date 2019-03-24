package utils;

import java.io.IOException;
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
			System.out.println("3");
			/*resp.sendRedirect(req.getContextPath() + "/companyLogin");*/
			request.getRequestDispatcher("/WEB-INF/jsp/student/login.jsp").forward(request, response);
            return;
		}
		
		
		
		
		
		/*if(uri.equals("companyResume")&&(String)session.getAttribute("backurl")==null)
		{
		
		uri=uri+"?"+"studentId="+req.getParameter("studentId");
		System.out.println(uri);
		session.setAttribute("backurl", uri);
		}
		else if (uri.equals("studentDetail")&&session.getAttribute("backurl")!=null) {
			String temp=(String)session.getAttribute("backurl");
			
			session.setAttribute("tempbackurl", temp);
		}else if (uri.equals("messageDetail")&&session.getAttribute("backurl")!=null) {
			String temp=(String)session.getAttribute("backurl");
			
			session.setAttribute("tempbackurl", temp);
		}else if(uri.equals("companyResume")&&(String)session.getAttribute("backurl")!=null){
			uri=uri+"?"+"studentId="+req.getParameter("studentId");
			String temp=(String)session.getAttribute("backurl");
			if (uri.equals(temp)) {
				session.setAttribute("backurl", null);
			}
		}
		else if(uri.equals("myFriends")){
			session.setAttribute("backurl", uri);
		}else if(uri.equals("companyMessage")){
			session.setAttribute("backurl", uri);
		}else if(uri.equals("companyCollection")){
			session.setAttribute("backurl", uri);
		}else if(uri.equals("companyZone")){
			session.setAttribute("backurl", null);
		}else {
			
		}*/
		/*if(uri.equals("companyResume"))
		{
		uri=uri+"?"+"studentId="+req.getParameter("studentId");
		System.out.println(uri);
		session.setAttribute("backurl", uri);
		}
		else if(uri.equals("myFriends")){
			session.setAttribute("backurl", uri);
		}else if(uri.equals("companyMessage")){
			session.setAttribute("backurl", uri);
		}else if(uri.equals("companyCollection")){
			session.setAttribute("backurl", uri);
		}else if(uri.equals("companyZone")){
			session.setAttribute("backurl", null);
		}else {
			
		}
			
		
		// pass the request along the filter chain
		chain.doFilter(request, response);*/
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器初始化");
	}

}
