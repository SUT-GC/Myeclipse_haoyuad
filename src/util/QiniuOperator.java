package util;

import com.qiniu.util.Auth;

public class QiniuOperator {
	private static String ACCESS_KEY = "LJcxRfv5nTPm92JSUrLlP72BY7xPWjIq8Sh-m4Kf";
	private static String SECRET_KEY = "147EU_I4oHeCCF5el0dBt7zoKpXI9EQmgp_cS9ze";
	private static String BUCKETNAME = "haoyuad";
	public static String getACCESS_KEY() {
		return ACCESS_KEY;
	}
	public static void setACCESS_KEY(String aCCESS_KEY) {
		ACCESS_KEY = aCCESS_KEY;
	}
	public static String getSECRET_KEY() {
		return SECRET_KEY;
	}
	public static void setSECRET_KEY(String sECRET_KEY) {
		SECRET_KEY = sECRET_KEY;
	}
	public static String getBUCKETNAME() {
		return BUCKETNAME;
	}
	public static void setBUCKETNAME(String bUCKETNAME) {
		BUCKETNAME = bUCKETNAME;
	}
	
	
}
