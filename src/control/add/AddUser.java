package control.add;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.struts2.ServletActionContext;
import org.bouncycastle.jce.provider.JCEMac.MD5;
import org.springframework.context.ApplicationContext;

import util.ApplicationContextUtil;
import util.MD5Util;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.AdminDao;
import empty.Admin;

public class AddUser extends ActionSupport {
	private String newusername;
	private String newuseraccount;
	private String newuserpass;
	private InputStream inputStream;
	private ApplicationContext applicationContext;
	
	public String getNewusername() {
		return newusername;
	}

	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}

	public String getNewuseraccount() {
		return newuseraccount;
	}

	public void setNewuseraccount(String newuseraccount) {
		this.newuseraccount = newuseraccount;
	}

	public String getNewuserpass() {
		return newuserpass;
	}

	public void setNewuserpass(String newuserpass) {
		this.newuserpass = newuserpass;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("进入AddUser.action  ====start====");
		
		//创建result
		int result;
		
		System.out.println("这里输出了sessionout的值"+ServletActionContext.getRequest().getSession().getAttribute("sessionout"));
		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-2
			result = -2;
		}else{
			/*
			 * 如果session没有过期，再进行一下活动
			 */

			//获得ApplicationContext
			applicationContext = ApplicationContextUtil.getApplicationContext();
			
			//创建新的Admin
			Admin newAdmin = applicationContext.getBean("newAdmin", Admin.class);
			
			//判断newuserpass是不是为空，如果是，则初始化000000密码
			if(newuserpass.length() == 0){
				newuserpass = "000000";
			}
			
			//向新的Admin中装入信息 将相关信息进行转码
			//这一步是因为web前端传过来的数据是8859_1(西欧语言)的编码
			newAdmin.setName(Base64.encodeBase64String( newusername.getBytes("8859_1")));
			newAdmin.setAccount(newuseraccount);
			newAdmin.setPass(MD5Util.MD5ToString(newuserpass));
			newAdmin.setPower(0);
			System.out.println("newAdmin 是"+newAdmin);
			//将newAdmin写入数据库
			result = AdminDao.addAdminUser(newAdmin);
			
		}
		//创建result ajax 输出
		inputStream = new ByteArrayInputStream((result+"").getBytes("utf-8"));
		System.out.println("退出AddUser.action  ==result:"+result+"==end====");
		return SUCCESS;
	}
}
