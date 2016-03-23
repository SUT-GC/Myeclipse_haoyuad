package control.delete;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.AdminDao;

public class DeleteAdmin extends ActionSupport {
	private String useraccount;
	private InputStream inputStream;
	public String getUseraccount() {
		return useraccount;
	}
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	@Override
	public String execute() throws Exception {
		//定义返回码
		int result;
		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-4
			result = -4;
		}else{
			if(useraccount != null && useraccount.length() != 0){
				// 1:删除成功 ; -1: 没有此人 ; -2: 查询结果不为一；0: AdminDao异常
				result = AdminDao.deleteAdminByAccount(useraccount);
			}else{
				//如果account为null
				result = -3;
			}
		}
		//返回inputStream，带着result
		inputStream = new ByteArrayInputStream((result+"").getBytes("utf-8"));
		return SUCCESS;
	}
}
