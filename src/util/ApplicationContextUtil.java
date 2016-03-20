package util;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gc
 * 作用:创建ApplicationContext与SessionFactory
 */
public class ApplicationContextUtil {
	private static ApplicationContext applicationContext ;
	private static SessionFactory sessionFactory;
	
	static{
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		sessionFactory = applicationContext.getBean("sessionFactory", SessionFactory.class);
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		ApplicationContextUtil.applicationContext = applicationContext;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		ApplicationContextUtil.sessionFactory = sessionFactory;
	}
	
}
