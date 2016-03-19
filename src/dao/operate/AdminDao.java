package dao.operate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import empty.Admin;


/**
 * @author gc
 * 这是对Admin表进行操作的类
 */

public class AdminDao {
	
	//session工厂
	private static SessionFactory sessionFactory;
	static {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		sessionFactory = applicationContext.getBean("sessionFactory", SessionFactory.class);
	}
	/**
	 * 1: 添加Admin用户
	 * @param Admin admin
	 * @return 0:操作异常 ； -1: 该用户已经存在 ; 1: 保存成功
	 */
	public static int addAdminUser(Admin admin){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		int result = 0;
		
		List<Admin> list =  session.createQuery("select admin from Admin admin where admin.account = "+admin.getAccount()) .list();
		if(list.size() == 0){
			result = (Integer) session.save(admin);
		}else{
			result = -1;
		}
		transaction.commit();
		session.close();
		return result;
	}

}
