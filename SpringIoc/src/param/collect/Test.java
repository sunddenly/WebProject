package param.collect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

	public static void main(String[] args) {
		String conf = "paramCollect.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		MessageBean m = (MessageBean) ctx.getBean("m1");
		m.execute();
		System.out.println(m.getSomeList().getClass().getName());
		System.out.println(m.getSomeSet().getClass().getName());
		System.out.println(m.getSomeMap().getClass().getName());
	}

}
