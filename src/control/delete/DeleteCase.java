package control.delete;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.CaseDao;

public class DeleteCase extends ActionSupport {
	private InputStream inputStream;
	private int caseid;
	
	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("===进入DeleteCase===start===");
		//定义返回码
		int result = -1;
		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-4
			result = -4;
		}else{
			result = CaseDao.deleteCaseByCaseId(caseid);
		}
		System.out.println("===进入DeleteCase===end===");
		inputStream = new ByteArrayInputStream((result+"").getBytes("utf-8"));
		return SUCCESS;
	}

}
