package control.select;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SelectLogs extends ActionSupport {
	private List<String> logs;

	public List<String> getLogs() {
		return logs;
	}

	public void setLogs(List<String> logs) {
		this.logs = logs;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=======这里进入了SelectLogs start======");
		logs = file.log.SelectLogs.selectAllLogs();
		
		System.out.println("=======这里进入了SelectLogs end======");
		return SUCCESS;
	}
	
}
