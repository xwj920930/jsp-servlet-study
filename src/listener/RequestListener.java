package listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
@WebListener
public class RequestListener implements ServletRequestListener{
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		ServletRequest request=arg0.getServletRequest();
		long start=(long) request.getAttribute("start");
		long end=System.currentTimeMillis();
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		System.out.println("url:"+httpServletRequest.getRequestURI()+";time:"+(end-start));
	}
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		ServletRequest request=arg0.getServletRequest();
		request.setAttribute("start", System.currentTimeMillis());
	}

}
