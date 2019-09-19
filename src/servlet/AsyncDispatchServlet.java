package servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AsyncDispatchServlet",urlPatterns="/asyncDispatch",asyncSupported=true)
public class AsyncDispatchServlet extends HttpServlet{
	@Override
	protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final AsyncContext asyncContext=req.startAsync();
		req.setAttribute("mainThread", Thread.currentThread().getName());
		asyncContext.setTimeout(5000);
		asyncContext.start(new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				req.setAttribute("workThread", Thread.currentThread().getName());
				asyncContext.dispatch("/threadName.jsp");
			}
		});
	}
}
