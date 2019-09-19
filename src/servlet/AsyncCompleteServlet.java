package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AsyncCompleteServlet",urlPatterns="/asyncComplete",asyncSupported=true)
public class AsyncCompleteServlet extends HttpServlet{
	//每次生成的js并没有覆盖，只是按照上下顺序后面的值会覆盖前面的值
	//<script>document.getElementById('progress').innerHTML='90%';</script>
	//<script>document.getElementById('progress').innerHTML='done';</script>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		final PrintWriter writer=resp.getWriter();
		writer.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title></title></head><body><div id='progress'></div></body></html>");
		final AsyncContext asyncContext=req.startAsync();
		asyncContext.setTimeout(60000);
		asyncContext.start(new Runnable() {
			public void run() {
				System.out.println("thread:"+Thread.currentThread().getName());
				for(int i=0;i<10;i++){
					writer.println("<script>document.getElementById('progress').innerHTML='"+(i*10)+"%';</script>");
					writer.flush();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				writer.println("<script>document.getElementById('progress').innerHTML='done';</script>");
				asyncContext.complete();
			}
		});
	}
}
