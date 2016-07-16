package control.jspmap;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import dao.operate.CaseDao;
import dao.operate.LabelDao;
import empty.Case;
import empty.Label;

public class ShowCases extends ActionSupport {
	private List<Case> caseList;
	private List<Label> labelList;
	
	
	public List<Case> getCaseList() {
		return caseList;
	}


	public void setCaseList(List<Case> caseList) {
		this.caseList = caseList;
	}


	public List<Label> getLabelList() {
		return labelList;
	}


	public void setLabelList(List<Label> labelList) {
		this.labelList = labelList;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("====进入ShowCase===start====");
		
		caseList = CaseDao.selectAllCase();
		for(Case acase:caseList){
			acase.setName(new String(Base64.decode(acase.getName())));
		}
		
		labelList = LabelDao.selectAllLabel();
		for(Label alabel:labelList){
			alabel.setName(new String(Base64.decode(alabel.getName())));
		}
		
		System.out.println("====进入ShowCase===end====");
		return SUCCESS;
	}
}
