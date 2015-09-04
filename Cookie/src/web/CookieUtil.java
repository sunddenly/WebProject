package web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	// appname是应用名，在使用该工具类时，将应用名改为实际部署时的应用名
	private static String appname = "/Servlet_05";

	/**
	 * 添加一个cookie需要考虑编码问题
	 * @param name     Cookie名称
	 * @param value    Cookie值
	 * @param age      Cookie生命周期
	 * @param response 响应对象
	 * @throws UnsupportedEncodingException
	 */
	public static void addCookie(String name, String value,int age,HttpServletResponse response)
			throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		c.setMaxAge(age);
		c.setPath(appname);
		response.addCookie(c);
	}

	/**
	 * 依据cookie名称返回cookie的值，找不到则返回null
	 * @param name
	 * @param request
	 * @return
	 */
	public static String findCookie(String name, HttpServletRequest request) {
		String value = null;
		Cookie[] cooikes = request.getCookies();
		if (cooikes != null) {
			for (int i = 0; i < cooikes.length; i++) {
				Cookie c = cooikes[i];
				if (c.getName().equals(name)) {
					value = c.getValue();
				}
			}
		}
		return value;
	}

	/**
	 * 删除一个cookie
	 * @param name
	 * @param response
	 */
	public static void deleteCookie(String name, HttpServletResponse response) {
		Cookie c = new Cookie(name, "");
		c.setMaxAge(0);
		response.addCookie(c);
	}

}
