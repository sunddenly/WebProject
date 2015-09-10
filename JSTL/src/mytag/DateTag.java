package mytag;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport {
	private String pattern;
	@Override
	public void doTag() throws JspException, IOException {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		String dateStr = dateFormat.format(date);
		PageContext pct = (PageContext)getJspContext();
		JspWriter out = pct.getOut();
		out.println(dateStr);
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
}
