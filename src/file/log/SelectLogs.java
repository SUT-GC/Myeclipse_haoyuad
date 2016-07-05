package file.log;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import control.add.AddLabel;

public class SelectLogs {
	public static List<String> selectAllLogs() throws UnsupportedEncodingException{
		List<String > logs = new ArrayList<String>();
		
		File logFile = new File(AddLog.FILEPATH);
		File[] files = logFile.listFiles();

		for(File eachLog : files){
			logs.add(eachLog.getAbsolutePath());
		}
		
	
		return logs;
	}
}
