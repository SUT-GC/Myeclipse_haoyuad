package control.jspmap;

import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.LabelDao;
import empty.Label;

public class AdminEditLabel extends ActionSupport {

	private List<Label> list;

	
	public List<Label> getList() {
		return list;
	}


	public void setList(List<Label> list) {
		this.list = list;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("进入AdminEditLabel=====start=====");
		
		//查询出所有的label
		list = LabelDao.selectAllLabel();
		for(int i = 0; i < list.size(); i++){
			list.get(i).setName(new String(Base64.decodeBase64(list.get(i).getName())));
		}
		
		System.out.println("退出AdminEditLabel=====end=====");
		return SUCCESS;
	}
	
}
