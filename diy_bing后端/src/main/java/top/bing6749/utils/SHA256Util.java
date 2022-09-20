package top.bing6749.utils;
/*
 * @author  MaRui
 * @date  2022/6/18 16:17
 * @version 1.0
 */


import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author MaRui
 */
public class SHA256Util {
    //加密方式为SHA-256
    public final static String hashAlgorithmName = "SHA-256";
    //循环的次数
    public final static int hashIterations = 16;
    public static String encryptPassword(String password,String userName){
        return new SimpleHash(hashAlgorithmName,password,userName+"login",hashIterations).toString();
    }
}
