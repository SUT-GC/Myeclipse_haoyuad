package control.update;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.CaseDao;

public class UploadCaseImg extends ActionSupport {
	private int caseid;
	private String HeadImg;
	private String BodyImg;
	private InputStream inputStream;
	public int getCaseid() {
		return caseid;
	}
	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}
	public String getHeadImg() {
		return HeadImg;
	}
	public void setHeadImg(String headImg) {
		HeadImg = headImg;
	}
	public String getBodyImg() {
		return BodyImg;
	}
	public void setBodyImg(String bodyImg) {
		BodyImg = bodyImg;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("====进入UploadCaseImg===start===");
		int result = 0;
		
		// 判断session是否已经过期， 如果过期，则进行页面跳转
		if (ServletActionContext.getRequest().getSession()
				.getAttribute("sessionout") == null
				|| ServletActionContext.getRequest().getSession()
						.getAttribute("sessionout").equals("yes")) {
			// 把result负值为-4
			result = -4;
		} else{
			if(HeadImg.equals("0")|| HeadImg.equals("")|| HeadImg.length() == 0){
				HeadImg = null;
			}
			if(BodyImg.equals("0")|| BodyImg.equals("")|| BodyImg.length() == 0){
				BodyImg = null;
			}
			result = CaseDao.uploadCaseImg(caseid, HeadImg, BodyImg);
		}
		
		inputStream=new ByteArrayInputStream((""+result).getBytes("utf-8"));
		System.out.println("====进入UploadCaseImg===end===");
		return SUCCESS;
	}
}
