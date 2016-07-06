package dao.operate;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.ApplicationContextUtil;
import empty.Label;

/**
 * @author gc
 * 对Label数据库进行操作
 * 1 向Label中添加
 * 2 在label中查询处所有的label
 * 3: 根据labelid更新label
 */
public class LabelDao {
	private static  SessionFactory sessionFactory;
	//创建sessionFactory
	static{
		sessionFactory = ApplicationContextUtil.getSessionFactory();
	}
	
	/**
	 * 1 向Label中添加
	 * @param Label newLabel;
	 * @return int result 
	 * -1数据库操作失败， -4:数据库中存在该label的名称 ,>0:存储成功
	 */
	public static int addLabel(Label newLabel){
		int result =  -1;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List<Label> list = null;
		
		list = session.createQuery("select label from Label label where label.name = '"+newLabel.getName()+"'").list();
		
		if(list.size() > 0){
			result = -4;
		}else{
			result = (Integer) session.save(newLabel);
		}
		
		transaction.commit();
		session.close();
		
		return result;
	}
	
	
	/**
	 * 2 在label中查询处所有的label
	 * @param 无
	 * @return list
	 */
	public static List<Label> selectAllLabel(){
		
		List<Label> list = null;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		list = session.createQuery("from Label").list();
		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 3: 根据labelid更新label
	 * @param int labelid, String oldlabelname
	 * @return 1:更新成功  -1:labelid没找到 0:数据库出错
	 */
	public static int  updateLabelById(int labelid, String labelname){
		
		int result = 0;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Label label = (Label) session.get(Label.class, labelid);
		if(label == null){
			result = -1;
		}else{
			label.setName(labelname);
			session.flush();
			result = 1;
		}
		transaction.commit();
		session.close();
		
		return result;
	}
	
	/**
	 * 4 根据id删除label
	 * @param int labelid
	 * @return 1:删除成功  -1:labelid不存在  0:数据库失败
	 */
	public static int deleteLabelById(int labelid){
		int result = 0;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Label label = (Label) session.get(Label.class, labelid);
		if(label == null){
			result = -1;
		}else{
			session.delete(label);
			result = 1;
		}
		
		transaction.commit();
		session.close();
		
		return result;
	}
	
	/**
	 * 5 :根据labelid与show更新show字段
	 * @param int labelid, int show
	 * @return int result
	 * 0:数据库操作出现问题，1:操作成功 , -1:最多不能超过三个展示案例
	 */
	public static int updataCaseShow(int labelid, int show){
		
		int result = 0;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List list =  session.createQuery("from Label label where label.show = 1").list();
		
		if(show == 1){
			if(list.size() > 2){
				result = -1;
			}else{
				Label label = (Label) session.get(Label.class, labelid);
				label.setShow(show);
				session.flush();
				result = 1;
			}
		}else{
			Label label = (Label) session.get(Label.class, labelid);
			label.setShow(show);
			session.flush();
			result = 1;
		}

		
		transaction.commit();
		session.close();
		
		return result;
	}
	
	/**
	 * 6:根据Label id查询Labl
	 * @param int labelid
	 * @return Label label
	 */
	public static Label selectLabelById(int labelid){
		Label label = null;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		label = (Label) session.get(Label.class, labelid);
		
		transaction.commit();
		session.close();
		
		return label;
	}
}

