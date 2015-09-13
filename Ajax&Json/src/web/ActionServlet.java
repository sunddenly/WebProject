package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SaleDao;

import net.sf.json.JSONArray;

import bean.City;
import bean.Sale;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if(uri.equals("/getArea")){
			String name = request.getParameter("name");
			List<City> cs = new ArrayList<City>();
			if(name.equals("sh")){
				City c1 = new City("浦东","pd");
				City c2 = new City("闸北", "zb");
				City c3 = new City("虹口","hk");
				cs.add(c1);
				cs.add(c2);
				cs.add(c3);
				JSONArray obj = JSONArray.fromObject(cs);
				String str = obj.toString();
				out.println(str);
			}else if(name.equals("bj")){
				City c1 = new City("海淀", "hd");
				City c2 = new City("朝阳", "cy");
				City c3 = new City("上地", "sd");
				cs.add(c1);
				cs.add(c2);
				cs.add(c3);
				JSONArray obj = JSONArray.fromObject(cs);
				String str = obj.toString();
				out.println(str);
			}else{
				City c1 = new City("北辰","bc");
				City c2 = new City("红桥", "hq");
				City c3 = new City("和平","hp");
				cs.add(c1);
				cs.add(c2);
				cs.add(c3);
				JSONArray obj = JSONArray.fromObject(cs);
				String str = obj.toString();
				out.println(str);
			}
		}else if(uri.equals("/sale")){
			String[] ary = {"联想-拯救者","华硕-兰博基尼","苹果-Air","戴尔-灵越"};
			Random random = new Random();
			SaleDao dao = new SaleDao();
			try{
				List<Sale> list = dao.findAll();
				JSONArray array = JSONArray.fromObject(list);
				String str = array.toString();
				out.println(str);
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		out.close();
	}
}
