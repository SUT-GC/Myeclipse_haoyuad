package test.dao.operate;

import dao.operate.AdminDao;
import util.MD5Util;
import empty.Admin;

public class TestAdminDao {

	public static void main(String[] args) {
		//测试addAdminUser
		Admin admin = new Admin();
		admin.setAccount("18804036473");
		admin.setName("张三");
		admin.setPower(1);
		admin.setPass(MD5Util.MD5ToString("gc"));
		System.out.println(admin);
		
		int result = AdminDao.addAdminUser(admin);
		System.out.println(result);

	}

}
