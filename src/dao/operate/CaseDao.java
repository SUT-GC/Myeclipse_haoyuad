package dao.operate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.ApplicationContextUtil;
import empty.Case;

public class CaseDao {
	private static  SessionFactory sessionFactory;
	//创建sessionFactory
	static{
		sessionFactory = ApplicationContextUtil.getSessionFactory();
	}
	
	/**
	 * 1 向Case中插入一条新记录
	 * @param Case newCase
	 * @reutrn int 
	 */
	public static int AddCase(Case newCase){
		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		result = (Integer) session.save(newCase);
		transaction.commit();
		session.close();
		return result;
	}
	
	/**
	 * 2 查询处所有的case
	 * @param void
	 * @return list<Case>
	 */
	public static List<Case> selectAllCase(){
		List<Case> list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		list = session.createQuery("from Case").list();
		
		transaction.commit();
		session.close();
		return list;
	}
	
	/**
	 * 3: 根据caseid 删除case
	 * @param calseid
	 * @return int 
	 */
	public static int deleteCaseByCaseId(int caseid){
		int result = -1;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Case acase = (Case) session.get(Case.class, caseid);
		session.delete(acase);
		result = 1;
		
		transaction.commit();
		session.close();
		return result;
	}
}
