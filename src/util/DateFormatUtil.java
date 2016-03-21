package util;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		
}
