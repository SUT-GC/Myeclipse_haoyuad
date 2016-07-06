package control.select;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.CaseDao;
import empty.Case;
import empty.Label;

public class SelectCaseLabelById extends ActionSupport {
	private int caseid;
	private InputStream inputStream;
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
		System.out.println("===进入SelectCaseLabelById===start===");
		//定义返回码
		int result = -1;
		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-4
			result = -4;
		}else{
			Case acase = CaseDao.selectCaseByCaseid(caseid);
			Iterator<Label> iterator = acase.getLabels().iterator();
			Label  label = iterator.next();
			result = label.getId();
		}
		
		System.out.println("===进入SelectCaseLabelById===end===");
		inputStream = new ByteArrayInputStream((result+"").getBytes("utf-8"));
		return SUCCESS;
	}
}	
