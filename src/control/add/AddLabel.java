package control.add;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;

import util.ApplicationContextUtil;

import com.opensymphony.xwork2.ActionSupport;

import dao.operate.LabelDao;
import empty.Case;
import empty.Label;

public class AddLabel extends ActionSupport {
	private String labelname;
	private InputStream inputStream;
	
	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("进入AddLabel  ====start====");
		//创建result
		int result;
		//进行转换
		labelname = new String(labelname.getBytes("8859_1"));

		//判断session是否已经过期， 如果过期，则进行页面跳转
		if(ServletActionContext.getRequest().getSession().getAttribute("sessionout") == null || ServletActionContext.getRequest().getSession().getAttribute("sessionout").equals("yes")){
			//把result负值为-2
			result = -2;
		}else{
		
			if(labelname == null || labelname.indexOf(" ") >= 0){
				//如果casename中有空格，result负值为-3
				result = -3;
			}else{
			
				/*
				 * 当casename中没有空格的时候，将casename加入case
				 */
				Label newLabel = ApplicationContextUtil.getApplicationContext().getBean("newLabel",Label.class);
				//将labelname 转化Base64
				//这一步是因为web前端传过来的数据是8859_1(西欧语言)的编码
				newLabel.setName(Base64.encodeBase64String(labelname.getBytes("utf-8")));

				//默认该分类不显示
				newLabel.setShow(0);
				
				//int result -1数据库操作失败， -4:数据库中存在该case的名称 ,>0:存储成功
				result = LabelDao.addLabel(newLabel);


			}
		}
		inputStream = new ByteArrayInputStream((result+"").getBytes("utf-8"));
		System.out.println("退出AddLabel ====result:"+result+"===end====");
		return SUCCESS;
	}
}
