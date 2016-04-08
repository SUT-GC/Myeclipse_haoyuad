package util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

/**
 * @author gc
 * 这是格式化日期的类
 */
public class DateFormatUtil {
	
	/**
	 * 1 格式化Date
	 * @param Date date
	 * @return String result;
	 */
	public static String dateFormatToyyyyMMddHHmmss(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}
		
	/**
	 * 2 格式化Date, 将结果Base64转码
	 * @param Date date
	 * @return String result
	 * @throws UnsupportedEncodingException 
	 */
	public static String dateFormatToyyyyMMdd(Date date) throws UnsupportedEncodingException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formart = simpleDateFormat.format(date);
		String result = Base64.encodeBase64String(formart.getBytes("utf-8"));
		return result;
	}
	
}
