

//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
///**
// * Servlet Filter implementation class AuthFilter
// */
//@WebFilter("/*")
//public class AuthFilter implements Filter {
//
//    /**
//     * Default constructor. 
//     */
//    public AuthFilter() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		AuthService serv=new AuthService();
//		if(serv.auth())
//		{chain.doFilter(request, response);}
//		else
//		{request.getServletContext().getRequestDispatcher("/").forward(request, response);
//		
//	}
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
