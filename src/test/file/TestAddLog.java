package test.file;

import java.util.Date;

import file.log.AddLog;

public class TestAddLog {
	public static void main(String[] args) {
		AddLog.addOperateLog("勾超", "18804036473", "删除案例", new Date());
	}
}
