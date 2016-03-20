package dao.operate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.ApplicationContextUtil;
import empty.Admin;


/**
 * @author gc
 * 这是对Admin表进行操作的类
 * 1: 添加Admin用户
 * 2:根据用户account查询用户
 * 3: 根据account删除用户
 * 4: 根据account修改密码
 */

public class AdminDao {
	
	//session工厂
	private static SessionFactory sessionFactory;
	static {
		sessionFactory = ApplicationContextUtil.getSessionFactory();
	}
	/**
	 * 1: 添加Admin用户
	 * @param Admin admin
	 * @return 0:操作异常 ； -1: 该用户已经存在 ; >=1: 保存成功(返回id)
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
	
	/**
	 * 2:根据用户account查询用户
	 * @param String account
	 * @return List list
	 * list.size() == 1 :查询到一个结果
	 * list.size() == 0 :没有查询到结果
	 */
	
	public static List<Admin> selectAdminByAccount(String account){
		List<Admin> list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		list = session.createQuery("select admin from Admin admin where admin.account = "+account).list();
		
		transaction.commit();
		session.close();
		return list;
	}
	
	
	/**
	 * 3: 根据account删除用户
	 * @param String account
	 * @return int result
	 * 1:删除成功 ; -1: 没有此人 ; -2: 查询结果不为一；0: AdminDao异常
	 */
	public static int deleteAdminByAccount(String account){
		int result = 0;
		List<Admin> list = null;
		list = selectAdminByAccount(account);
		if(list.size() > 1){
			result = -2;
		}else if(list.size()  == 0){
			result = -1;
		}else if(list.size() == 1){
			Admin admin = list.get(0);
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.delete(admin);
			result = 1;
			
			transaction.commit();
			session.close();
		}
		return result;
	}

	/**
	 * 4: 根据account修改密码
	 * @param String account, String newpassmd5
	 * @return int result 
	 * 1:修改成功 ; -1: 没有这个人;  -2: 查询结果不唯一  0 :AdminDao 修改函数异常 
	 */
	public static int updateAdminByAccount(String oldaccount, String newpassmd5){
		int result = 0;
		List<Admin> list = null;
		list = selectAdminByAccount(oldaccount);
		if(list.size() == 0){
			result = -1;
		}else if(list.size() > 1){
			result = -2;
		}else if(list.size() == 1){
			Admin admin = list.get(0);
			admin.setPass(newpassmd5);
			
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.update(admin);
			result = 1;
			
			transaction.commit();
			session.close();
		}
		
		return result ;
	}
	
}
