package control.update;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.LabelDao;

public class UpdateLabel extends ActionSupport {

	private int oldlabelid;
	private String newlabelname;
	private InputStream inputStream;

	public int getOldlabelid() {
		return oldlabelid;
	}

	public void setOldlabelid(int oldlabelid) {
		this.oldlabelid = oldlabelid;
	}

	public String getNewlabelname() {
		return newlabelname;
	}

	public void setNewlabelname(String newlabelname) {
		this.newlabelname = newlabelname;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("进入UpdateLabel======start======");

		// 定义返回码
		int result = 0;

		// 判断session是否已经过期， 如果过期，则进行页面跳转
		if (ServletActionContext.getRequest().getSession()
				.getAttribute("sessionout") == null
				|| ServletActionContext.getRequest().getSession()
						.getAttribute("sessionout").equals("yes")) {
			// 把result负值为-4
			result = -4;
		} else {
			if (newlabelname == null || newlabelname.length() == 0) {
				// 如果新表签名为空，返回-3
				result = -3;
			} else {
				// 1:更新成功 -1:labelid没找到 0:数据库出错
				newlabelname = Base64.encodeBase64String(newlabelname
						.getBytes("8859_1"));
				result = LabelDao.updateLabelById(oldlabelid, newlabelname);
			}
		}

		inputStream = new ByteArrayInputStream(("" + result).getBytes("utf-8"));
		System.out.println("退出UpdateLabel===result : " + result
				+ "===end======");
		return SUCCESS;
	}
}
