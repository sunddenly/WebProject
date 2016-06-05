package json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.People;

public class JSONTest {
	public static void f1(){
		//java对象-->json字符串
		JSONObject jsonObj = JSONObject.fromObject(new People("jiang",11));
	    String str = jsonObj.toString();
	    System.out.println(str);
	}
	public static void f2(){
		People p1 = new People("Luffy",23);
		People p2 = new People("Zoro",28);
		List<People> ps = new ArrayList<People>();
		ps.add(p1);
		ps.add(p2);
		JSONArray jsonObj = JSONArray.fromObject(ps);
		String str = jsonObj.toString();
		//java集合-->json字符串
		System.out.println(str);
	}
	public static void f3(){
		//json字符串--->java对象转换
		String str = "{\"name\":\"Luffy\",\"age\":17}";
		JSONObject obj = JSONObject.fromObject(str);
		//转变成java对象
		//People.class返回的是关于People的类型描述信息的对象是一种Class类型
		People p =(People)obj.toBean(obj,People.class);
		System.out.println(p.toString());
	}
	public static void f4(){
		//json字符串--->java对象转换
		String str =
				"[{\"name\":\"Luffy1\",\"age\":17}," +
				"{\"name\":\"Luffy2\",\"age\":17}]";
		JSONArray objArr = JSONArray.fromObject(str);
		//转变成java对象
		//People.class返回的是关于People的类型描述信息的对象是一种Class类型
		List<People> ps =(List<People>) objArr.toCollection(objArr,People.class);
		System.out.println(ps);
	}
	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		f4();
	}
}
