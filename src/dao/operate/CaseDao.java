package dao.operate;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.ApplicationContextUtil;
import empty.Case;
import empty.Label;

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
	/**
	 * 4: 根据caseid 查询case
	 * @param calseid
	 * @return int 
	 */
	public static Case selectCaseByCaseid(int caseid){
		Case acase = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		acase = (Case) session.get(Case.class, caseid);
		
		transaction.commit();
		session.close();
		return acase;
	}
	
	/**
	 * 5:根据caseid， 更新caseName, caseDescribe, labelSet;
	 * @param String caseName, String caseDescribe, Set<Label> labelSet;
	 * @return int
	 */
	public static int updateCaseInfoById(int caseid, String caseName, String caseDescribe, Set<Label> labelSet){
		int result = -1;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Case acase = (Case) session.get(Case.class, caseid);
		acase.setName(caseName);
		acase.setDescribe(caseDescribe);
		if(labelSet != null){
			acase.setLabels(labelSet);
		}
		result = 1;
		
		transaction.commit();
		session.close();
		return result;
	}
	
	/**
	 * 6 根据caseid，更新项目图片
	 * @param String imageNames;
	 * @return int 
	 */
	public static int updateCaseImageNames(int caseid, String imageNames){
		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Case acase = (Case) session.get(Case.class, caseid);
		acase.setImages(imageNames);
		
		result = 1;
		
		transaction.commit();
		session.close();
		return result;
	}
	
	/**
	 * 7: 跟新HeadImg并且添加BodyImg
	 * @param int caseid,String headimg, String bodyimg
	 * @return int
	 */
	public static int uploadCaseImg(int caseid,String headimg, String bodyimg){
		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Case acase = (Case) session.get(Case.class, caseid);
		try {
			if(headimg != null){
				acase.setHeadimg(headimg);
			}
			if(bodyimg != null){
				acase.setImages(acase.getImages()+bodyimg);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		transaction.commit();
		session.close();
		return result;
	}
}
