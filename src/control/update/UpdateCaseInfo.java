package control.update;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.CaseDao;
import dao.operate.LabelDao;
import empty.Label;

public class UpdateCaseInfo extends ActionSupport {
	private int caseId;
	private String caseName;
	private String caseDescribe;
	private int labelId;
	private InputStream inputStream;
	
	public int getCaseId() {
		return caseId;
	}
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
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
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("进入UpdateCaseInfo======start======");

		// 定义返回码
		int result = 0;

		// 判断session是否已经过期， 如果过期，则进行页面跳转
		if (ServletActionContext.getRequest().getSession()
				.getAttribute("sessionout") == null
				|| ServletActionContext.getRequest().getSession()
						.getAttribute("sessionout").equals("yes")) {
			// 把result负值为-4
			result = -4;
		} else{
			Set<Label> labelSet = null;
			
			if(labelId == -1){
				labelSet = null;
			}else{
				labelSet = new HashSet<Label>();
				labelSet.add(LabelDao.selectLabelById(labelId));
			}
			caseName = new String(caseName.getBytes("8859_1"));
			caseDescribe = new String(caseDescribe.getBytes("8859_1"));
			System.out.println("caseName="+caseName+"caseDescribe"+caseDescribe+"caseId="+caseId+"labelSet="+labelSet);
			caseName = Base64.encodeBase64String(caseName.getBytes("utf-8"));
			caseDescribe = Base64.encodeBase64String(caseDescribe.getBytes("utf-8"));
	
			result = CaseDao.updateCaseInfoById(caseId, caseName, caseDescribe, labelSet);
		}
		System.out.println("进入UpdateCaseInfo======start======");
		inputStream = new ByteArrayInputStream((result+"").getBytes("utf-8"));
		return SUCCESS;
	}
}
