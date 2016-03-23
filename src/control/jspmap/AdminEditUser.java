package control.jspmap;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.AdminDao;
import empty.Admin;

public class AdminEditUser extends ActionSupport {
	
	private List<Admin> list;
		
	public List<Admin> getList() {
		return list;
	}

	public void setList(List<Admin> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("进入AdminEditUser ====start====");
		//判断session是否过期，如果过期，则重新登陆
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			return "sessionout";
		}else{
			list = AdminDao.selectFormalAdmin();
			for(int i = 0; i < list.size(); i++){
				list.get(i).setName(new String(Base64.decodeBase64(list.get(i).getName()), "utf-8"));
			}
		}
		System.out.println("list.size = "+list.size());
		System.out.println("进入AdminEditUser ====end====");
		return SUCCESS;
	}
	
}
