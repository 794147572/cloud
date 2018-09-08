package com.jxph.cloud.service.auth.server.common.utils;


import com.google.common.base.Throwables;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author 谢秋豪
 * @date 2018/9/3 21:36
 */
public class MD5Helper {
    private static final HashFunction FUNCTION = Hashing.md5();

    private static final HashFunction MURMUR_FUNC = Hashing.murmur3_128();

    public static String[] chars = new String[] { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    public static String encryPassword(String password,String salt){
        HashCode code = FUNCTION.hashString(password+salt, Charset.forName("UTF-8"));
        return code.toString();
    }

    public static String hashString(String input){
        HashCode code = null;
        try {
            code = MURMUR_FUNC.hashBytes(input.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            Throwables.propagate(e);
        }
        return code.toString();
    }

    public static String getUUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 16; i++) {
            String str = uuid.substring(i * 2, i * 2 + 2);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 36]);
        }
        return shortBuffer.toString();
    }

}
