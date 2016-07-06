package control.add;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import dao.operate.CaseDao;
import dao.operate.LabelDao;
import empty.Case;
import empty.Label;

public class AddCase extends ActionSupport {
	private String caseName;
	private String caseDescribe;
	private int labelId;
	private String imageHeadName;
	private String imageBodyNames;
	private InputStream inputStream;
	
	public String getCaseName() {
		return caseName;
	}


	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}


	public String getCaseDescribe() {
		return caseDescribe;
	}


	public void setCaseDescribe(String caseDescribe) {
		this.caseDescribe = caseDescribe;
	}


	public int getLabelId() {
		return labelId;
	}


	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}


	public String getImageHeadName() {
		return imageHeadName;
	}


	public void setImageHeadName(String imageHeadName) {
		this.imageHeadName = imageHeadName;
	}


	public String getImageBodyNames() {
		return imageBodyNames;
	}


	public void setImageBodyNames(String imageBodyNames) {
		this.imageBodyNames = imageBodyNames;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("===进入AddCase===start===");
		System.out.println("casename="+caseName);
		
		//创建result
		int result;
		
		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-2
			result = -2;
		}else{
			System.out.println();
			Case newCase = new Case();
			newCase.setName(Base64.encode(new String(caseName.getBytes("iso-8859-1"),"utf-8").getBytes()));
			newCase.setDescribe(Base64.encode(new String(caseDescribe.getBytes("iso-8859-1"),"utf-8").getBytes()));
			newCase.setHeadimg(imageHeadName);
			newCase.setImages(imageBodyNames);
			newCase.setTimestamp(new Timestamp(new Date().getTime()));
			Set<Label> set = new HashSet<Label>();
			set.add(LabelDao.selectLabelById(labelId));
			newCase.setLabels(set);
			
			result = CaseDao.AddCase(newCase);
		}
		inputStream = new ByteArrayInputStream((result+"").getBytes("utf-8"));
		System.out.println("===进入AddCase===end===");
		
		return SUCCESS;
	}
}
