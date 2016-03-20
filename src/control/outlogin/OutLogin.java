package control.outlogin;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class OutLogin extends ActionSupport {
	@Override
	public String execute() throws Exception {
		//获取session
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		//注销session
		httpSession.removeAttribute("userid");
		httpSession.removeAttribute("username");
		httpSession.removeAttribute("useraccount");
		httpSession.removeAttribute("userpower");
		
		return SUCCESS;
	}
}
