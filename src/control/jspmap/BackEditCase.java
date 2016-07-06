package control.jspmap;

import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.CaseDao;
import dao.operate.LabelDao;
import empty.Case;
import empty.Label;

public class BackEditCase extends ActionSupport {
	private List<Case> list;
	private List<Label> labels;
	
	public List<Case> getList() {
		return list;
	}

	public void setList(List<Case> list) {
		this.list = list;
	}
	
	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("===进入BackEditCase===start===");
		
		list = CaseDao.selectAllCase();
		labels = LabelDao.selectAllLabel();
		
		for(Case acase: list){
			acase.setName(new String(Base64.decodeBase64(acase.getName())));
			acase.setDescribe(new String(Base64.decodeBase64(acase.getDescribe()),"utf-8"));
		}
		
		for(Label label:labels){
			label.setName(new String(Base64.decodeBase64(label.getName())));
		}
		System.out.println("===进入BackEditCase===end===");
		return SUCCESS;
	}
}
