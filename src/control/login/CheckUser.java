package control.login;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;

import select.ip.ShowAddress;
import util.ApplicationContextUtil;
import util.DateFormatUtil;
import util.MD5Util;

import com.opensymphony.xwork2.ActionSupport;

import control.jspmap.AdminIndex;
import dao.operate.AdminDao;
import dao.operate.AdminLoginInforDao;
import empty.Admin;
import empty.AdminLoginInfo;

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
				/*
				 * 密码验证正确
				 */
				
				//进行session写入
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("userid", admin.getId());
				session.setAttribute("useraccount", admin.getAccount());
				session.setAttribute("username", new String (Base64.decodeBase64(admin.getName())));
				session.setAttribute("userpower", admin.getPower());
				
				
				/*
				 * 开始写入登陆记录
				 */
				//获取登陆ip 与登陆地址
				String ip = ServletActionContext.getRequest().getRemoteAddr();
				String ipaddress = "";
				if(ip.equals("0:0:0:0:0:0:0:1")){
					ipaddress="本地回环网络";
				}else{
					ipaddress = ApplicationContextUtil.getApplicationContext().getBean("showAddress", ShowAddress.class).getResult(ip);
				}
				//格式化登陆日期
				String logindate = "";
				logindate = DateFormatUtil.dateFormatToyyyyMMddHHmmss( ApplicationContextUtil.getApplicationContext().getBean("date",Date.class));
				
				
				//检查是否是超级管理员
				if(admin.getPower() == 1){
					//是。result=1
					result ="1";
					//创建登陆记录
					AdminLoginInfo adminLoginInfo = ApplicationContextUtil.getApplicationContext().getBean("adminLoginInfor", AdminLoginInfo.class);
					adminLoginInfo.setAdminid(admin.getId());
					//为了防止ipaddress导致数据库出现问题，吧ipaddress base64之后进行存储
					adminLoginInfo.setLoginaddress(Base64.encodeBase64String(ipaddress.getBytes()));
					adminLoginInfo.setLoginip(ip);
					adminLoginInfo.setLogindate(logindate);
					adminLoginInfo.setLoginaccount(admin.getAccount());
					System.out.println(adminLoginInfo);
					//将AdminLoginInfor添加进入数据库
					AdminLoginInforDao.addAdminLoginInfor(adminLoginInfo);
					
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
