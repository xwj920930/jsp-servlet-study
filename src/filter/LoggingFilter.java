package filter;

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
@WebFilter(filterName="LoggingFilter",urlPatterns="/*",asyncSupported=true,
initParams={
		@WebInitParam(name="logFileName",value="log.txt"),
		@WebInitParam(name="prefix",value="URI:")
}
		)
public class LoggingFilter implements Filter{
	PrintWriter logger;
	String prefix;
	@Override
	public void destroy() {
		System.out.println("destroy");
		if (logger!=null) {
			logger.close();
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("dofilter");
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		String Url=httpServletRequest.getRequestURI();
		logger.println(new Date()+":"+prefix+Url);
		logger.flush();
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		prefix=filterConfig.getInitParameter("prefix");
		String logFileName=filterConfig.getInitParameter("logFileName");
		String appPath=filterConfig.getServletContext().getRealPath("/");
		try {
			logger=new PrintWriter(new File(appPath, logFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
