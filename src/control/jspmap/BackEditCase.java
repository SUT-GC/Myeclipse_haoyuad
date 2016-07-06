package control.jspmap;

import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.CaseDao;
import empty.Case;

public class BackEditCase extends ActionSupport {
	private List<Case> list;
	
	public List<Case> getList() {
		return list;
	}

	public void setList(List<Case> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("===进入BackEditCase===start===");
		
		list = CaseDao.selectAllCase();
		for(Case acase: list){
			acase.setName(new String(Base64.decodeBase64(acase.getName())));
			acase.setDescribe(new String(Base64.decodeBase64(acase.getDescribe()),"utf-8"));
		}
		System.out.println("===进入BackEditCase===end===");
		return SUCCESS;
	}
}
