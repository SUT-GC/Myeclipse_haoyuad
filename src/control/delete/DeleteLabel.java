package control.delete;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.LabelDao;

public class DeleteLabel extends ActionSupport {
	private int labelid = -1 ;
	private InputStream inputStream;
	public int getLabelid() {
		return labelid;
	}
	public void setLabelid(int labelid) {
		this.labelid = labelid;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("进入DeleteLabel=====start=====");
		//定义返回码
		int result = 0;
		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-4
			result = -4;
		}else{
			//1:删除成功 -1:labelid不存在 0:数据库失败
			result = LabelDao.deleteLabelById(labelid);
		}
		
		inputStream = new ByteArrayInputStream((""+result).getBytes("utf-8"));
		System.out.println("进入DeleteLabel===result:"+result+"==end=====");
		return SUCCESS;
	}
}
