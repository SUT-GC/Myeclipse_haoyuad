package control.jspmap;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import dao.operate.LabelDao;
import empty.Case;
import empty.Label;

public class Index extends ActionSupport {
	private List<Label> labelList;
	private String labelsJSON;
	private String casesJSON;

	public List<Label> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<Label> labelList) {
		this.labelList = labelList;
	}
	
	public String getLabelsJSON() {
		return labelsJSON;
	}

	public void setLabelsJSON(String labelsJSON) {
		this.labelsJSON = labelsJSON;
	}

	public String getCasesJSON() {
		return casesJSON;
	}

	public void setCasesJSON(String casesJSON) {
		this.casesJSON = casesJSON;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("===进入Index===start===");
		
		labelList = LabelDao.selectAllShowLabels();
		System.out.println(labelList.size());
		
		labelsJSON = "[";
		if(labelList.size() >= 1){
			for(int i = 0; i< labelList.size()-1; i++){
				labelsJSON += "{'labelName':'";
				labelsJSON += labelList.get(i).getName();
				labelsJSON += "'},";
			}
			labelsJSON+="{'labelName':'";
			labelsJSON+= labelList.get(labelList.size()-1).getName();
			labelsJSON+="'}";
		}
	
		labelsJSON += "]";
		
		casesJSON = "[";
		for(Label label : labelList){
			casesJSON += "{'cases':[";
			int count = 0;
			Set<Case> labelCases = label.getCases();
			Iterator<Case> iterator = labelCases.iterator();
			while(iterator.hasNext()){
				count ++;
				if(count > 5){
					break;
				}
				Case acase = iterator.next();
				casesJSON +="{'caseName':'"+acase.getName()+"','caseHeadImg':'"+acase.getHeadimg()+"'},";
				System.out.println(acase.getHeadimg());
			}
			casesJSON +="{'caseName':'theLaseSpaceCase','caseHeadImg':'0'}]},";
		}
		casesJSON += "{}]";
		System.out.println(labelsJSON);
		System.out.println("========================");
		System.out.println(casesJSON);
		System.out.println("===进入Index===end===");
		return SUCCESS;
	}
}
