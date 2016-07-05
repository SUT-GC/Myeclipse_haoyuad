package test.file;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class TestSelectLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<String> list = file.log.SelectLogs.selectAllLogs();
			for(String logName:list){
				System.out.println(logName);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
