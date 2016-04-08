package control.jspmap;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import select.ip.ShowAddress;
import util.ApplicationContextUtil;
import util.DateFormatUtil;

import com.opensymphony.xwork2.ActionSupport;

public class NormalIndex extends ActionSupport {

	private String ip;
	private String ipaddress;
	private Date date;
	private String formatDate;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	@Override
	public String execute() throws Exception {
		
		System.out.println("这里走了NormalIndex======start======");
		
		// 初始化
		date = ApplicationContextUtil.getApplicationContext().getBean("date",
				Date.class);

		formatDate = DateFormatUtil.dateFormatToyyyyMMddHHmmss(date);
		ip = ServletActionContext.getRequest().getRemoteAddr();
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ipaddress = "本地回环网络";
		} else {
			ipaddress = ApplicationContextUtil.getApplicationContext()
					.getBean("showAddress", ShowAddress.class).getResult(ip);
		}

		System.out.println("这里走了NormalIndex======end======");
		return SUCCESS;
	}

}
