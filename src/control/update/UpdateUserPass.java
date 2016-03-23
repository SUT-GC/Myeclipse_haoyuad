package control.update;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import util.MD5Util;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.AdminDao;

public class UpdateUserPass extends ActionSupport {
	private String useraccount;
	private String newuserpass;
	private InputStream inputStream;
	public String getUseraccount() {
		return useraccount;
	}
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
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
		//定义返回码
		int result;
		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-4
			result = -4;
		}else{
			//判断newpass是不是为空
			if(newuserpass.length() == 0){
				//newuserpass为空
				result = -3;
			}else{
				//将newuserpass MD5进行加密
				newuserpass = MD5Util.MD5ToString(newuserpass);
				//将newuserpass根据useraccount写入数据库
				//1:修改成功 ; -1: 没有这个人; -2: 查询结果不唯一 0 :AdminDao 修改函数异常
				result = AdminDao.updateAdminByAccount(useraccount, newuserpass);
			}
		}
		//返回inputStream，带着result
		
		inputStream = new ByteArrayInputStream((result+"").getBytes("utf-8"));
		
		return SUCCESS;
	}
}
