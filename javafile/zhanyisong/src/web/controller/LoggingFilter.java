package web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggingFilter
 */
@WebFilter(filterName="LoggingFilter",urlPatterns= {"/*"},asyncSupported=true,
		initParams= {@WebInitParam(name="logFileName",value="log.txt"),
		@WebInitParam(name="prefix",value="URI: ")})
public class LoggingFilter implements Filter {
   private PrintWriter logger;
   private String prefix;
   public void init(FilterConfig filterConfig) throws ServletException {
		prefix = filterConfig.getInitParameter("prefix");
		String logFileName = filterConfig.getInitParameter("logFileName");
//		String addPath=filterConfig.getServletContext().getRealPath("/");
		String addPath="G:\\javafile\\zhanyisong\\log";
//		System.out.println("logFileName:"+logFileName);
		try {logger= new PrintWriter(new File(addPath,logFileName));}
		catch(FileNotFoundException e) {e.printStackTrace();
		throw new ServletException(e.getMessage());}
	}
  
    public LoggingFilter() {
    	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
//		System.out.println("destory filter");
		if(logger!=null) {
			logger.close();
		}
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//		System.out.println("LoggingFilter.doFilter");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		logger.println(new Date()+ "" + prefix + httpServletRequest.getRequestURI());
		logger.flush();
		filterChain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	

}
