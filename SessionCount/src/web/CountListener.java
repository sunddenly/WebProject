package web;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.omg.CORBA.Request;
/**
 * 基于session的在线人数统计
 * @author hdoop
 * 实际统计的是session个数
 */
public class CountListener implements HttpSessionListener{
	private int count;
	public void sessionCreated(HttpSessionEvent se) {
		/*
		 * 客户端请求的是jsp页面，那么容器会自动创建一个session对象
		 * jsp页面包含很多系统为客户端自动创建隐含对象
		 * session就是其自动创建的隐含对象
		 */
		count++;
		/*
		 * 绑定数据
		 * request,session,servletContext
		 */
		HttpSession session = se.getSession();
		session.getServletContext().setAttribute("count", count);
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		count--;
		HttpSession session = se.getSession();
		session.getServletContext().setAttribute("count", count);
	}

}
