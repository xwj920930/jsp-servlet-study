package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
@WebFilter(filterName="AutoCorrectFilter",urlPatterns="/*")
public class AutoCorrectFilter implements Filter{
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	@Override
	public void destroy() {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		AutoCorrectHttpServletRequestWrapper wrapper=new AutoCorrectHttpServletRequestWrapper(httpServletRequest);
		filterChain.doFilter(wrapper, response);
	}
	class AutoCorrectHttpServletRequestWrapper extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		public AutoCorrectHttpServletRequestWrapper(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		@Override
		public String getParameter(String name) {
			return AutoCorrect(request.getParameter(name));
		}
	}
	private String AutoCorrect(String s){
		if(s==null){
			return null;
		}else{
			return s.trim().replace(" ", "");
		}
	}
}
