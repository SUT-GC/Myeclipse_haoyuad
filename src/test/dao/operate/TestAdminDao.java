package test.dao.operate;

import java.util.List;

import util.MD5Util;
import dao.operate.AdminDao;
import empty.Admin;

public class TestAdminDao {

	public static void main(String[] args) {
		//测试addAdminUser
//		Admin admin = new Admin();
//		admin.setAccount("18804036473");
//		admin.setName("张三");
//		admin.setPower(1);
//		admin.setPass(MD5Util.MD5ToString("gc"));
//		System.out.println(admin);
//		
//		int result = AdminDao.addAdminUser(admin);
//		System.out.println(result);
		
		
		//测试selectAdminByAccount
//		List<Admin> list = null;
//		list = AdminDao.selectAdminByAccount("18804036475");
//		System.out.println(list.size());
		
		//测试deleteAdminByAccount
//		int result = 0;
//		result = AdminDao.deleteAdminByAccount("18804036473");
//		System.out.println(result);

		//测试updataAdminByAccount
//		int result = 0;
//		result = AdminDao.updateAdminByAccount("18804036473", MD5Util.MD5ToString("gc"));
//		System.out.println(result);
		
		//测试selectFormalAdmin
		List <Admin> list = AdminDao.selectFormalAdmin();
		System.out.println(list.size());
		
	}

}
