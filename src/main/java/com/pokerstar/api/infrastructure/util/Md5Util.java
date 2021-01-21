package com.pokerstar.api.infrastructure.util;

import org.asynchttpclient.util.MessageDigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Base64;

public class Md5Util {
    private static Logger Log = LoggerFactory.getLogger(Md5Util.class);

    public static String md5(String source) {
        byte[] bytes = source.getBytes();
        return md5(bytes);
    }

    public static String md5(byte[] bytes) {
        return md5(bytes, 0, bytes.length);
    }

    private static String md5(byte[] bytes, int offset, int len) {
        try {
            MessageDigest md = MessageDigestUtils.pooledMd5MessageDigest();
            md.update(bytes, offset, len);
            return Base64.getEncoder().encodeToString(md.digest());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
