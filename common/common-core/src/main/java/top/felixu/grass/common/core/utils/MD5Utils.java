package top.felixu.grass.common.core.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * MD5工具类
 *
 * @author felixu
 * @date 2019.06.14
 */
@Slf4j
public class MD5Utils {

    public static String encode(String key) {
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(key.getBytes());
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.error("Sign Error:" + e.getLocalizedMessage(), e);
            return "";
        }
    }

    public static boolean matches(String rawKey, String encodeKey) {
        return encode(rawKey).equals(encodeKey);
    }

    public static void main(String[] args) {
        System.out.println(encode("felixu"));
    }
}
