package control.select;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import dao.operate.LabelDao;
import empty.Case;

public class SelectCases extends ActionSupport {
	private Set caseSet;
	private int labelid;
	private InputStream inputStream;

	public int getLabelid() {
		return labelid;
	}

	public void setLabelid(int labelid) {
		this.labelid = labelid;
	}

	public Set getCaseSet() {
		return caseSet;
	}

	public void setCaseSet(Set caseSet) {
		this.caseSet = caseSet;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("===进入SelectCases===start===");
		caseSet = LabelDao.selectCasesByLabelId(labelid);
		Iterator<Case> caseIterator = caseSet.iterator();
		
		String result = "[";
		while(caseIterator.hasNext()){
			Case acase = caseIterator.next();
			result +="{";
			result += "'name':'"+(new String(Base64.decode(acase.getName())))+"',";
			result += "'headimg':'"+acase.getHeadimg()+"',";
			result += "'id':'"+acase.getId()+"',";
			result +="},";
		}
		result +="{}";
		result += "]";

		inputStream = new ByteArrayInputStream(result.getBytes("utf-8"));
		System.out.println("===进入SelectCases===end===");
		return SUCCESS;
	}
}
