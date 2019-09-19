package listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener,ServletContextListener{
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session=arg0.getSession();
		ServletContext context=session.getServletContext();
		AtomicInteger userCount=(AtomicInteger) context.getAttribute("userCount");
		int count=userCount.incrementAndGet();
		context.setAttribute("userCount", new AtomicInteger(count));
		System.out.println("user number ="+count);
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context=arg0.getServletContext();
		context.setAttribute("userCount", new AtomicInteger());
	}
}
