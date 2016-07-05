package control.outlogin;



import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import select.ip.ShowAddress;
import util.ApplicationContextUtil;

import com.opensymphony.xwork2.ActionSupport;

import file.log.AddLog;

public class OutLogin extends ActionSupport {
	@Override
	public String execute() throws Exception {
		//获取session
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		//获取对应的id，name，useraccount
		int id  = (Integer) httpSession.getAttribute("userid");
		String name = (String) httpSession.getAttribute("username");
		String account = (String)httpSession.getAttribute("useraccount");
		//获取登陆ip 与登陆地址
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		String ipaddress = "";
		if(ip.equals("0:0:0:0:0:0:0:1")){
			ipaddress="本地回环网络";
		}else{
			ipaddress = ApplicationContextUtil.getApplicationContext().getBean("showAddress", ShowAddress.class).getResult(ip);
		}
		AddLog.addOperateLog(name, account, "退出登陆", ip, ipaddress, ApplicationContextUtil.getApplicationContext().getBean("date", Date.class));
		
		//注销session
		httpSession.removeAttribute("userid");
		httpSession.removeAttribute("username");
		httpSession.removeAttribute("useraccount");
		httpSession.removeAttribute("userpower");
		
		return SUCCESS;
	}
}
