package cn.ddnd.huayun.log.request;

import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @program: huayun
 * @description: 签名
 * @author: Xue 8
 * @create: 2019-05-21 22:20
 **/
public class Signature {

    public String getSignature(Map<String, String> parameters, String accessKey) {
        String key = accessKey;
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            sb.append("&" + entry);
        }
        sb = sb.deleteCharAt(0);
        String parametersStr = sb.toString();
        parametersStr = encode(parametersStr);
        String md5 = MD5(parametersStr);
        String var = "GET\n" + md5 + "\n" +
                "application/json;charset=UTF-8\n" +
                encode(parameters.get("Date")) + "\n";
        String signature = HMACSHA256(var.getBytes(), key.getBytes());
        signature = encode(signature);
        signature = signature.replace("=", "%3D");
        return parametersStr + "&Signature=" + signature;
    }

    private String encode(String var) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < var.length(); i++) {
            if (var.charAt(i) != '=' && var.charAt(i) != '&') {
                 if (var.charAt(i) == ' ') {
                     sb.append("%20");
                     continue;
                 }
                try {
                    sb.append(URLEncoder.encode(String.valueOf(var.charAt(i)), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                sb.append(String.valueOf(var.charAt(i)));
            }
        }
        return sb.toString();
    }

    private String MD5(String str) {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            bytes = md.digest();
            return byteArrayToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String byteArrayToHex(byte[] byteArray) {
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f' };
        char[] resultCharArray =new char[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }
        return new String(resultCharArray);
    }

    private String HMACSHA256(byte[] data, byte[] key) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            byte[] bytes = mac.doFinal(data);
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String str = base64Encoder.encodeBuffer(bytes);
            str = str.trim();
            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

}
