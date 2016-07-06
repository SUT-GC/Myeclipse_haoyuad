package control.jspmap;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import dao.operate.LabelDao;
import empty.Label;

public class BackAddCase extends ActionSupport {
	private List<Label> list;
	
	public List<Label> getList() {
		return list;
	}

	public void setList(List<Label> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("======进入BackAddCase===start===");
		//查询处所有的label
		list = LabelDao.selectAllLabel();
		for(Label label: list){
			label.setName(new String(Base64.decode(label.getName())));
		}
		System.out.println("======进入BackAddCase===end===");
		return SUCCESS;
	}
}
