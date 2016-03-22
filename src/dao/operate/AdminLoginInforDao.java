package dao.operate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import empty.AdminLoginInfo;
import util.ApplicationContextUtil;


/**
 * @author gc
 * 对超级管理员的登陆记录进行记录
 */
public class AdminLoginInforDao {

	/**
	 * 1:添加登陆记录信息 AdminLoginInfor 
	 * @param AdminLoginInforDao 登陆记录
	 * @return int result 
	 * > 1:添加成功
	 */
	
	public static int addAdminLoginInfor(AdminLoginInfo adminlogininfor){
		int result = -1;
		Session session = ApplicationContextUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		result = (Integer) session.save(adminlogininfor);
		
		transaction.commit();
		session.close();
		return result ;
	}
	
	
	
}
