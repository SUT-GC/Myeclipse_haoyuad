package test;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import empty.Case;
import empty.Label;


public class TestSessionFactory {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		SessionFactory sessionFactory = ctx.getBean("sessionFactory", SessionFactory.class);
		
		
		//创建label对象
		Label label = new Label();
		label.setName("中国");
		
		//创建case对象
		Case case1 = new Case();
		case1.setName("hello");
		case1.setDescribe("hello2");
		case1.setHeadimg("hello2");
		case1.setImages("hello3");
		case1.setShow(1);
		
		Set<Case> set = new HashSet<Case>();
		set.add(case1);
		
		//label里加case
		label.setCases(set);
		
		
		Session session = sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		
		//在添加label_case之前一定要添加case
		session.save(case1);
		session.save(label);
		
		transaction.commit();
		session.close();
		
//		Configuration cfg = new Configuration().configure("xml/testhibernate.cfg.xml");
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//				.applySettings(cfg.getProperties()).build();
//		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//		
//		//创建label对象
//		Label label = new Label();
//		label.setName("公司文化");
//		
//		Session session = sessionFactory.openSession();
//		Transaction transaction =  session.beginTransaction();
//		
//		session.save(label);
//		
//		transaction.commit();
//		session.close();
	}
}
