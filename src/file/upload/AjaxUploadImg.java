package file.upload;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import util.QiniuOperator;

import com.opensymphony.xwork2.ActionSupport;
import com.qiniu.util.Auth;

import dao.operate.LabelDao;

public class AjaxUploadImg extends ActionSupport {
	private static String ACCESS_KEY = "LJcxRfv5nTPm92JSUrLlP72BY7xPWjIq8Sh-m4Kf";
	private static String SECRET_KEY = "147EU_I4oHeCCF5el0dBt7zoKpXI9EQmgp_cS9ze";
	private static String BUCKETNAME = "haoyuad";
	
	private String uploadToken = null;
	private InputStream inputStream;
	
	public String getUploadToken() {
		return uploadToken;
	}

	public void setUploadToken(String uploadToken) {
		this.uploadToken = uploadToken;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("======进入AjaxUploadImg=== start ===");
		uploadToken = "0";
		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-4
			uploadToken ="-4";
		}else{
			Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
			uploadToken = auth.uploadToken(BUCKETNAME);
			uploadToken = "{\"uptoken\":\""+uploadToken+"\"}";
		}
		
		System.out.println(uploadToken);
		
		inputStream = new ByteArrayInputStream((""+uploadToken).getBytes("utf-8"));
		System.out.println("======进入AjaxUploadImg=== end ===");
		return SUCCESS;
	}
	
}
