package com.example.administrator.newpos;



import java.text.DecimalFormat;
import java.util.zip.CRC32;

/**
 * author:wanliang527</br>
 * date:2017/3/24</br>
 */

public class DataUtils {

    /**
     * 异或校验方法
     *
     * @param datas 数据域
     * @return 校验结果
     */
    public static byte getXor(byte[] datas) {
        byte temp = datas[0];
        for (int i = 1; i < datas.length; i++) {
            temp ^= datas[i];
        }
        return temp;
    }

    /**
     * 循环冗余校验
     *
     * @param datas
     * @return
     */
    public static byte[] getCrc32(byte[] datas) {
        CRC32 crc32 = new CRC32();
        crc32.update(datas);
        String str = Long.toHexString(crc32.getValue());
        str = formatCRC32Str(str);
        byte[] bytes = HexUtils.hexStringToByte(str);
        return bytes;
    }

    /**
     * 格式化CRC32校验后的字符串
     * @param str
     * @return
     */
    public static String formatCRC32Str(String str) {
        String zeros = "00000000";
        if (str == null || str.length() == 0) {
            return zeros;
        }
        int num = str.length();
        if (num >= 8) {
            return str;
        }
        return zeros.substring(0, 8 - num) + str;
    }

    public static int hexByte2Int(byte[] hex) {
        return Integer.parseInt(HexUtils.bytesToHexString(hex), 16);
       /* StringBuilder sBuilder = new StringBuilder("0x");
        sBuilder.append(HexUtils.bytesToHexString(hex));
        LogTool.w("test == >" + sBuilder.toString());
        return Integer.valueOf("0x0007");*/
    }

    public static int byte2Int(byte b) {
        return b & 0xFF;
    }

    public static String unformatMount(String mount) {
        if ("".equals(mount) || mount == null) {
            return "0.00";
        }
        if ("0".equals(mount) || "0.0".equals(mount)) {
            return "0.00";
        }
        if (mount.contains(".")) {
            return mount;
        }
        mount = mount.replace("+-", "-");
        double money = Double.parseDouble(mount) * 0.01;
        DecimalFormat df = new DecimalFormat("##0.00");
        return df.format(money);
    }

    /**
     * int转换成2字节的byte数组
     *
     * @param value int值
     * @return 2字节byte数组，高位在前，低位在后
     */
    public static byte[] intToBytes(int value) {
        byte[] src = new byte[2];
        src[0] = (byte) ((value >> 8) & 0xFF);
        src[1] = (byte) (value & 0xFF);
        return src;
    }

    //long类型转成byte数组
    public static byte[] longToByte(long number) {
        long temp = number;
        byte[] b = new byte[4];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    public static String byte2BinaryString(byte b) {
        String value = Integer.toBinaryString(byte2Int(b));
        if (value.length() < 8) {
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < 8 - value.length(); i++) {
                sBuilder.append("0");
            }
            sBuilder.append(value);
            value = sBuilder.toString();
        }
        return value;
    }

}
