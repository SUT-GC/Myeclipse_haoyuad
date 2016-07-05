package control.jspmap;

import com.opensymphony.xwork2.ActionSupport;

public class BackAddCase extends ActionSupport {
	@Override
	public String execute() throws Exception {
		System.out.println("======进入BackAddCase===start===");
		System.out.println("======进入BackAddCase===end===");
		return SUCCESS;
	}
}
