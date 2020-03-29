package com.hx;
import javax.crypto.*;
import javax.crypto.spec.*;


public class CryptTool4CT {
  private static String algorithm = "DESede";
  private static String key = "CLOUD_TERMINAL_MANAGER";
  private static String encCharsetName = "UTF-8";
  private static String iv = "87654321";
  private static SecretKeySpec keySpec = null;
  private static IvParameterSpec ivSpec = null;


  private static SecretKey genDESKey(byte[] key_byte) throws  Exception {
    javax.crypto.SecretKey key = new SecretKeySpec(key_byte, algorithm);
    return key;
  }

  private static byte[] md5Digest(byte[] src) throws Exception {
    java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5");
    return alg.digest(src);
  }

  private static String md5Digest(String src) throws Exception {
    return new String(md5Digest(src.getBytes()));
  }

  private static String base64Encode(String src) {
    sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    return encoder.encode(src.getBytes());
  }

  private static String base64Encode(byte[] src) {
    sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    return encoder.encode(src);
  }

  private static String base64Decode(String src) {
    sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    try {
      return new String(decoder.decodeBuffer(src));
    }catch (Exception ex) {
      return null;
    }
  }

  private static byte[] base64DecodeToBytes(String src) {
    sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    try {
      return decoder.decodeBuffer(src);
    }catch (Exception ex) {
      return null;
    }

  }

  private static String urlEncode(String src) {
    try {
      src = java.net.URLEncoder.encode(src, encCharsetName);
      return src;
    }catch (Exception ex) {
      ex.printStackTrace();
    }
    return src;
  }

  private static String urlDecode(String value) {
    try {
      return java.net.URLDecoder.decode(value, encCharsetName);
    }catch (Exception ex) {
      ex.printStackTrace();
    }
    return value;
  }

  private static byte[] desEncrypt(SecretKey deskey, byte[] src) {
     try {
          Cipher cipher = Cipher.getInstance(algorithm);
          cipher.init(Cipher.ENCRYPT_MODE, deskey);
          return cipher.doFinal(src);
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      return null;
  }

  private static byte[] desDecrypt(SecretKey deskey, byte[] src) {
       try {
          Cipher cipher = Cipher.getInstance(algorithm);
          cipher.init(Cipher.DECRYPT_MODE, deskey);
          return cipher.doFinal(src);
      } catch (java.lang.Exception ex) {
          ex.printStackTrace();
      }
      return null;
  }

  private static void genAESKey() throws  Exception {
          byte[] keyBytes= new byte[16];
          byte[] ivBytes = new byte[16];
		  byte[] kbyte = key.getBytes(encCharsetName);
          byte[] vbyte = iv.getBytes(encCharsetName);
          int klen = kbyte.length;
          int vlen = vbyte.length;
		  if (klen > keyBytes.length) klen = keyBytes.length;
          if (vlen > ivBytes.length) vlen = ivBytes.length;
          System.arraycopy(kbyte, 0, keyBytes, 0, klen);
          System.arraycopy(vbyte,0,ivBytes,0,vlen);
          keySpec = new SecretKeySpec(keyBytes, "AES");
          ivSpec = new IvParameterSpec(ivBytes);
  }

  private static byte[] encrypt(byte[] text) throws Exception
  {
		  if( keySpec==null || ivSpec==null ) genAESKey();	
          Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
          cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);
          byte [] results = cipher.doFinal(text);
          return results;
  }

  private static byte[] decrypt(byte[] text) throws Exception
  {
   		  if( keySpec==null || ivSpec==null ) genAESKey();	
          Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
          cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
          byte [] results = cipher.doFinal(text);
          return results;
  }

  //加密
  public static String encode(String str) throws Exception
  {
	  if (str == null || str.trim().equals("")) return str;
	  
	  return base64Encode(encrypt(str.getBytes()));
  }
  
  //解密
  public static String decode(String str) throws Exception
  {
	  if (str == null || str.trim().equals("")) return str;
	  
	  return new String(decrypt(base64DecodeToBytes(str)));
  }
  

  public static void main(String[] args) throws Exception {
	  String src = "123456";
	  
	  System.out.println(base64Encode(src));
	  System.out.println(base64Decode("MTIzNDU2"));
	  
	  String res = encode(src);
	  System.out.println(res);
	  
	  String crs = decode(res);
	  System.out.println(crs);
	  
  }

  public static void help(){
    System.out.println("Usage:");
    System.out.println("  java com.ffcs.commons.CryptTool Account [Password] [NewPassword]");
    System.out.println("    for this message.");
  }

}