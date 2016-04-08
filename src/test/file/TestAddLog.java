package test.file;

import java.util.Date;

import file.log.AddLog;

public class TestAddLog {
	public static void main(String[] args) {
		AddLog.addOperateLog("gc", "18804036473", "删除用户", "192.168.1.1", "沈阳", new Date());
	}
}
