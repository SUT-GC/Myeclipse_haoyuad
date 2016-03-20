package control.login;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import util.MD5Util;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.AdminDao;
import empty.Admin;

public class CheckUser extends ActionSupport {
	private String useraccount;
	private String userpass;
	private InputStream inputStream;
	
	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("====这里走了CheckUser.acton   start====");
		System.out.println("输出接受到的参数: useraccount="+useraccount+", userpass="+userpass);
		
		String result = "0";
		List<Admin> list = AdminDao.selectAdminByAccount(useraccount);
		if(list.size() == 0){
			//账号不存在，返回
			result = "3";
		}else if(list.size() > 1){
			//查询结果不为一，返回7
			result = "7";
		}else if(list.size() == 1){
			//在list中选出admin
			Admin admin = list.get(0);
			//比对用户输入的密码是否正确
			if(MD5Util.compareStringAndMD5(userpass, admin.getPass())){
				//密码验证正确
				//检查是否是超级管理员
				if(admin.getPower() == 1){
					//是。result=1
					result ="1";
				}else{
					//不是，result= 8
					result ="8";
				}
			}else{
				//密码错误
				result = "2";
			}
		}
		
		inputStream = new ByteArrayInputStream(result.getBytes("utf-8"));
		
		System.out.println("====结束 CheckUser.acton end====");
		return SUCCESS; 
	}
}
