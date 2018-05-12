package com.carryit.base.fam.hpb;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.Arrays;
public class ChangeUtils {
    final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z' };

    /**
     * 将十进制的数字转换为指定进制的字符串
     *
     * @param n 十进制的数字
     * @param base 指定的进制
     * @return
     */
    public String toOtherBaseString(long n, int base) {
        long num = 0;
        if (n < 0) {
            num = ((long) 2 * 0x7fffffff) + n + 2;
        } else {
            num = n;
        }
        char[] buf = new char[32];
        int charPos = 32;
        while ((num / base) > 0) {
            buf[--charPos] = digits[(int) (num % base)];
            num /= base;
        }
        buf[--charPos] = digits[(int) (num % base)];
        return new String(buf, charPos, (32 - charPos));
    }

    /**
     * 将其它进制的数字（字符串形式）转换为十进制的数字
     *
     * @param str 其它进制的数字（字符串形式）
     * @param base 指定的进制
     * @return
     */
    public static long toDecimalism(String str, int base) {
        char[] buf = new char[str.length()];
        str.getChars(0, str.length(), buf, 0);
        long num = 0;
        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (digits[j] == buf[i]) {
                    num += j * Math.pow(base, buf.length - i - 1);
                    break;
                }
            }
        }
        return num;
    }

    /*
    * 将二进制数，不足8位的，补全8位
    * */
    public static String finishedBinary(String binary, int size) {
        int length = binary.length();
        if(length >= size) {
            return binary;
        } else {
            Optional<String> zeroOp = Stream.iterate(String.valueOf(0), i -> i).limit(size - length).reduce((s1, s2) -> s1 + s2);
            return zeroOp.get() + binary;
        }
    }

    /*
    * 将十六进制数转成8位的二进制数
    *
    * */
    public static String transferHexToFormattedBinary(String hex) {
        int val = Integer.parseInt(hex, 16);
        String binVal = Integer.toBinaryString(val);
        return finishedBinary(binVal, 8);
    }

    /*
    * 将两位连在一起的十六进制数转变成格式化的二进制数
    * */
    public static String transferHexToBinary(String hexStr) {
        String[] hexs = hexStr.trim().split("\\s+");
        return Arrays.stream(hexs).map(hex -> transferHexToFormattedBinary(hex)).reduce((hex1, hex2) -> hex1 +hex2).get();


    }

}
