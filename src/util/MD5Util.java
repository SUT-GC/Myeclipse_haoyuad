package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;


/**
 * 
 * @author gc
 *
 * 1 对字符串进行MD5加解密
 * 2 对一个字符串进行MD5加密，之后与另一个MD5进行比较
 */
public class MD5Util {
	private static MessageDigest md ;
	static {
		try {
			md  = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("MessageDigest 初始化 出错了 \n 打印错误信息开始 ===== start =====");
			e.printStackTrace();
			System.out.println("MessageDigest 打印错误信息开始 ===== end =====");
		}
	}
	
	/**
	 * 1 对字符串进行MD5加解密
	 * @param String src  源字符串
	 * @return MD5之后的字符串
	 */
	public static String MD5ToString(String src){
		byte[] result  = md.digest(src.getBytes());
		return Hex.encodeHexString(result);
	}
	
	/**
	 * 2 对一个字符串进行MD5，并且与另一个MD5进行比较
	 * @param String src & String md5
	 * @return true:相同， false: 不相同
	 */
	public static boolean compareStringAndMD5(String src, String md5){
		if(md5.equals(MD5ToString(src))){
			return true;
		}else{
			return false;
		}
	}

}
