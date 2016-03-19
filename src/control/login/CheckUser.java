package control.login;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

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
		String result = "hello";
		inputStream = new ByteArrayInputStream(result.getBytes("utf-8"));
		
		System.out.println("====结束 CheckUser.acton end====");
		return SUCCESS; 
	}
}
