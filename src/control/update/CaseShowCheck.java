package control.update;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.LabelDao;

public class CaseShowCheck extends ActionSupport {
	private int id;
	private int show;
	private InputStream inputStream;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("进入CaseShowCheck======start======");

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
			System.out.println("show=="+show+"id==="+id);
			result = LabelDao.updataCaseShow(id, show);
		}

		// 将result编程字节流进行ajax返回
		inputStream = new ByteArrayInputStream(("" + result).getBytes("utf-8"));

		System.out.println("退出CaseShowCheck======end======");
		return SUCCESS;
	}
}
