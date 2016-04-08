package file.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import util.DateFormatUtil;

public class AddLog {
	public static void addOperateLog(String username, String useraccount, String useroperate, String userip, String useraddress , Date date){
		
		String filename;
		boolean createok = true;
		try {
			//创建文件的名字为当前的日期记性base64转码之后的结果
			filename = DateFormatUtil.dateFormatToyyyyMMdd(date);
			System.out.println("文件的名字为 : "+filename);
			
			//以文件的名字和linux目录 /home/gc/hyad_log/filename.txt进行创建
			File file = new File("/home/gc/hyad_log/"+filename+".txt");
			//输出文件的绝对路径
			System.out.println("文件的绝对路径"+file.getPath());
			
			//如果文件不存在，创建文件
			if(!file.exists()){
				createok = file.createNewFile();
			}
			
			//如果创建成功，开始进行文件的写入
			if(createok){
				System.out.println("创建文件成功，开始进入写操作......");
				
				//创建文件输出流
				FileOutputStream fileOutputStream = new FileOutputStream(file, true);
				//创建包装流
				PrintStream printStream = new PrintStream(fileOutputStream);
				
				//包装流进行写入
				printStream.println("===================操作开始====================="
						+ "\n操作时间："+DateFormatUtil.dateFormatToyyyyMMddHHmmss(date)
						+"\n操作者："+username+"\n操作账号："+useraccount
						+"\n操作 ip："+userip+"\n操作地址："+useraddress+"  "
						+"\n所进行的操作："+useroperate
						+"\n===================操作结束====================="
						);
				
				//关闭流
				printStream.close();
				fileOutputStream.close();
				
				System.out.println("写入成功!");
				
				
			}else{
				System.out.println("创建文件失败，写入失败......");
			}
			
		//打印异常
		} catch (UnsupportedEncodingException e) {
			System.out.println("AddLog报错开始======start======");
			System.out.println("不支持转码操作");
			e.printStackTrace();
			System.out.println("AddLog报错结束======end======");
		} catch (IOException e) {
			System.out.println("创建文件失败报错开始======start======");
			System.out.println("创建新文件失败");
			System.out.println("创建文件失败报错结束======end======");
		}
		
	}
}
