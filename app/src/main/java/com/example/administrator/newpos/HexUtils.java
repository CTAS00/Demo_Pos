package com.example.administrator.newpos;

/**
 * 十六进制处理工具类
 * 
 * @author Administrator
 * 
 */
public class HexUtils {

	/**
	 * 功能描述：将16进制的字符串转换为字节数组,例如有16进制字符串"12345678"<br/>
	 * 转换后的结果为：{18, 52 ,86 ,120 };
	 * 
	 * @param hex
	 *            需要转换的16进制字符串
	 * @return 以字节数组返回转换后的结果
	 */
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toUpperCase().toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	/**
	 * 功能描述：把字节数组转换为十六进制字符串，例如有字节数组<br/>
	 * byte [] data = new byte[]{18, 52 ,86 ,120 };转换之后的结果为："12 34 56 78"
	 * 
	 * @param bArray
	 *            所要进行转换的数组内容
	 * @return 返回转换后的结果，内容用空格隔开
	 */
	public static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		int j = 0; // 此处定义的j用于控制每行输出的数据个�?
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2) {
				sb.append(0);
			}
			sb.append(sTemp.toUpperCase());
			j++;
		}
		return sb.toString();
	}

	/**
	 * 十六进制字符转换成十六进制字节
	 * 
	 * @param c
	 *            十六进制字符
	 * @return 返回十六进制字节
	 */
	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	/**
	 * 将16位int转换为长度为2的byte数组
	 * 
	 * @param num
	 *            整数值
	 * @return
	 */
	public static byte[] int2bytes(int num) {
		byte[] b = new byte[4];
		int mask = 0xff;
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (num >>> (24 - i * 8));
		}
		return b;
	}

	/**
	 * 将长度为2的byte数组转换为16位int
	 * 
	 * @param b
	 *            字节数组
	 * @return
	 */
	public static int bytes2int(byte[] b) {
		// byte[] b=new byte[]{1,2,3,4};
		int mask = 0xff;
		int temp = 0;
		int res = 0;
		for (int i = 0; i < 4; i++) {
			res <<= 8;
			temp = b[i] & mask;
			res |= temp;
		}
		return res;
	}

	/**
	 * 将长度为2的byte数组转换为16位int
	 * 
	 * @param
	 *
	 * @return int
	 * */
	public static int bytes2short(byte[] b) {
		// byte[] b=new byte[]{1,2,3,4};
		int mask = 0xff;
		int temp = 0;
		int res = 0;
		for (int i = 0; i < 2; i++) {
			res <<= 8;
			temp = b[i] & mask;
			res |= temp;
		}
		return res;
	}

	/**
	 * bcd码转换为字符串
	 * 
	 * @author: Administrator
	 * @date:2014-4-1 下午6:58:23
	 * @param bcds
	 * @return
	 */
	public static String bcd2str(byte[] bcds) {
		char[] ascii = "0123456789abcdef".toCharArray();
		byte[] temp = new byte[bcds.length * 2];
		for (int i = 0; i < bcds.length; i++) {
			temp[i * 2] = (byte) ((bcds[i] >> 4) & 0x0f);
			temp[i * 2 + 1] = (byte) (bcds[i] & 0x0f);
		}
		StringBuffer res = new StringBuffer();

		for (int i = 0; i < temp.length; i++) {
			res.append(ascii[temp[i]]);
		}
		return res.toString().toUpperCase();
	}

    /**
     * 将二进制转为16进制字符串,StringBuilder单线程安全,效率高(推荐)
     * @param bytes
     * @return
     */
    public static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }



	/**
	 * 十六进制字符串转换字符串
	 * 35353637 ==> 5567
	 *
	 * @return String
	 */
	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
						i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	/**
	 * HEX字符串前补0，主要用于长度位数不足。
	 *
	 * @param str
	 *            String 需要补充长度的十六进制字符串
	 * @param maxLength
	 *            int 补充后十六进制字符串的长度
	 * @return 补充结果
	 */
	static public String patchHexString(String str, int maxLength) {
		String temp = "";
		for (int i = 0; i < maxLength - str.length(); i++) {
			temp = "0" + temp;
		}
		str = (temp + str).substring(0, maxLength);
		return str;
	}
	/**
	 * ascii 码转16进制
	 * @param str
	 * @return
	 */
	public static String convertStringToHex(String str){

		char[] chars = str.toCharArray();

		StringBuffer hex = new StringBuffer();
		for(int i = 0; i < chars.length; i++){
			hex.append(Integer.toHexString((int)chars[i]));
		}

		return hex.toString();
	}



	public static <T> String addHeadZero(T t, int length) {
		String src = t.toString();
		if (src.length() >= length) {
			return src;
		}
		String rest = String.format("%1$0" + (length - src.length()) + "d", 0)
				+ src;
		return rest;
	}

	/**
	 * 16进制转ascii码
	 * @param hex
	 * @return
	 */
	public static String convertHexToString(String hex){

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		//49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for( int i=0; i<hex.length()-1; i+=2 ){

			//grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			//convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			//convert the decimal to character
			sb.append((char)decimal);

			temp.append(decimal);
		}

		return sb.toString();
	}


}
