package control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class test extends ActionSupport {
	@Override
	public String execute() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sessionFactory = ctx.getBean("sessionFactory", SessionFactory.class);
		
		Session session = sessionFactory.openSession();
		
		return SUCCESS;
	}
}
