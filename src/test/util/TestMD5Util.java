package test.util;

import util.MD5Util;

public class TestMD5Util {

	public static void main(String[] args) {
		String src = "gc";
		String result = MD5Util.MD5ToString(src);
		System.out.println(result);
		
		System.out.println(MD5Util.compareStringAndMD5(src, result));
		
	}

}
