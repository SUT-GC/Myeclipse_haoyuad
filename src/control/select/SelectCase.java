package control.select;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import dao.operate.CaseDao;
import empty.Case;

public class SelectCase extends ActionSupport {
	private int caseid;
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("===进入SelectCase===start====");
		Case acase = CaseDao.selectCaseByCaseid(caseid);
		String result = "{";
		result+="'id':'"+acase.getId()+"',";
		result+="'name':'"+new String(Base64.decode(acase.getName()))+"',";
		result+="'describe':'"+new String(Base64.decode(acase.getDescribe()))+"',";
		result+="'caseimgs':'"+acase.getImages()+"'";
		result+="}";
		System.out.println("resultJson:"+result);
		inputStream = new ByteArrayInputStream(result.getBytes("utf-8"));
		System.out.println("===进入SelectCase===end====");
		return SUCCESS;
	}
}
