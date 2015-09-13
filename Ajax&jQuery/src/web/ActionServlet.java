package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import bean.Stock;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(uri.equals("/getInfo")){
			out.println("服务器端数据");
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			System.out.println(name+" "+age);
		}else if(uri.equals("/salary")){
			String eId = request.getParameter("eId");
			if(eId.equals("T10001")){
				out.println("实际工资：￥10000<br/>个税：￥2500");
			}else {
				out.println("实际工资：￥15000<br/>个税：￥3500");
			}
		}else if(uri.equals("/quoto")){
			Random random = new Random();
			List<Stock> stocks = new ArrayList<Stock>();
			for(int i=0;i<10;i++){
				Stock s = new Stock();
				s.setCode("60001"+random.nextInt(10));
				s.setName("中国国贸"+random.nextInt(10));
				DecimalFormat df = new DecimalFormat("0.00");
				double price = Double.parseDouble(df.format(100*random.nextDouble()));
				s.setPrice(price);
				stocks.add(s);
			}
			JSONArray jsonArray = JSONArray.fromObject(stocks);
			String jstr = jsonArray.toString();
			System.out.println(jstr);
			out.println(jstr);
		}
		out.close();
	}

}
