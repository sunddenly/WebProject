package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 
 * @author hdoop
 * 属性名与标签中的属性名相同
 * 为属性提供get、set方法
 */
public class HelloTag extends SimpleTagSupport{
	private String str;
	private int count;
	@Override
	public void doTag() throws JspException, IOException {
		/**
		 * 实现按conut制定次数的输出str内容
		 */
		PageContext ctx = (PageContext)getJspContext();
		JspWriter out = ctx.getOut();//获取jsp页面的输出流
		for(int i=0;i<count;i++){
			out.println(str);
		}
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
