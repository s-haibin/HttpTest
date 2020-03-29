package com.hx;



import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
//import org.apache.log4j.Logger;



public class HttpClientUtil {

	private static final Log logger = LogFactory.getLog(HttpClientUtil.class); 
    
 	
	//璁剧疆缂栫爜
    public static final String CHARSET_UTF_8 = "utf-8";
    
    public static final String CHARSET_GBK = "GBK";

    // HTTP鍐呭绫诲瀷
    public static final String CONTENT_TYPE_TEXT_HTML = "text/xml";

    public static final String CONTENT_TYPE_FORM_URL = "application/x-www-form-urlencoded";

    public static final String CONTENT_TYPE_JSON_URL = "application/json;charset=utf-8";
   
  
    
    // 杩炴帴绠＄悊鍣�
    private static PoolingHttpClientConnectionManager pool;

    // 璇锋眰閰嶇疆
    private static RequestConfig requestConfig;

    static {
        
        try {
        	logger.info("鍒濆鍖朒ttpClient...");
           // SSLContextBuilder builder = new SSLContextBuilder();
            
           // builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            
           // SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
            //        builder.build());
        	SSLContext sslcontext = createIgnoreVerifySSL(); 
            
            
            // 閰嶇疆鍚屾椂鏀寔 HTTP 鍜� HTPPS
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                    "https", new SSLConnectionSocketFactory(sslcontext)).build();
            // 鍒濆鍖栬繛鎺ョ鐞嗗櫒
            pool = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry);
            // 灏嗘渶澶ц繛鎺ユ暟澧炲姞鍒�200
            pool.setMaxTotal(300);
            // 璁剧疆鏈�澶ц矾鐢�
            pool.setDefaultMaxPerRoute(2);
            /** connectionRequestTimeout  浠庤繛鎺ユ睜鑾峰彇杩炴帴鐨勮秴鏃舵椂闂�
             *  connectTimeout 杩炴帴寤虹珛鏃堕棿锛屼笁娆℃彙鎵嬪畬鎴愭椂闂�
             *  寤虹珛杩炴帴鏃讹紝瀹㈡埛绔彂閫乻yn鍖呫�佹湇鍔″櫒鏀跺埌syn鍖呫�佸鎴风鏀跺埌鏈嶅姟鍣ㄧ殑SYN+ACK鍖�
             *  socketTimeout  涓�娆℃暟鎹紶杈撹繃绋嬩腑鏁版嵁鍖呬箣闂撮棿闅旂殑鏈�澶ф椂闂�
             */
            int socketTimeout = 120000;
            int connectTimeout = 60000;
            int connectionRequestTimeout = 20000;
            requestConfig = RequestConfig.custom().setConnectionRequestTimeout(
                    connectionRequestTimeout).setSocketTimeout(socketTimeout).setConnectTimeout(
                    connectTimeout).build();

            logger.info("瀹屾垚鍒濆鍖朒ttpClient...");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (KeyManagementException e) {
            e.printStackTrace();
        } 
        // 璁剧疆璇锋眰瓒呮椂鏃堕棿
        requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000)
                .setConnectionRequestTimeout(60000).build();
    }

    public static CloseableHttpClient getHttpClient() {
     
        CloseableHttpClient httpClient = HttpClients.custom()
                // 璁剧疆杩炴帴姹犵鐞�
                .setConnectionManager(pool)
                // 璁剧疆璇锋眰閰嶇疆
                .setDefaultRequestConfig(requestConfig)
                // 璁剧疆閲嶈瘯娆℃暟
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();
        
        return httpClient;
    }

    /**
     * 鍙戦�丳ost璇锋眰
     * 
     * @param httpPost
     * @return
     */
    public static String sendHttpPost(HttpPost httpPost) { 
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        // 鍝嶅簲鍐呭
        String responseContent = null;
        try {
            // 鍒涘缓榛樿鐨刪ttpClient瀹炰緥.
            httpClient = getHttpClient();
            // 閰嶇疆璇锋眰淇℃伅
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Accept", CONTENT_TYPE_JSON_URL); 
           
            //璁剧疆澶撮儴-涓氬姟淇℃伅 
            // 鎵ц璇锋眰
            response = httpClient.execute(httpPost);
            // 寰楀埌鍝嶅簲瀹炰緥
            HttpEntity entity = response.getEntity();
 
            // 鍒ゆ柇鍝嶅簲鐘舵��
            if (response.getStatusLine().getStatusCode() >= 300) {
                logger.error("Response code is " + response.getStatusLine().getStatusCode());
            	throw new Exception(
                        "HTTP Request is not success, Response code is " + response.getStatusLine().getStatusCode());
            }

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                responseContent = EntityUtils.toString(entity, CHARSET_UTF_8);
                EntityUtils.consume(entity); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 閲婃斁璧勬簮
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
    
    /**
     * 鍙戦�� post璇锋眰 鍙戦�乯son鏁版嵁
     * 
     * @param httpUrl  鍦板潃
     * @param paramsJson  鍙傛暟(鏍煎紡 json)
     * 
     */
    public static String sendHttpPostJson(String httpUrl, String paramsJson,String token) {
        HttpPost httpPost = new HttpPost(httpUrl);// 鍒涘缓httpPost
        try {
            // 璁剧疆鍙傛暟
            if (paramsJson != null && paramsJson.trim().length() > 0) {
                StringEntity stringEntity = new StringEntity(paramsJson, "UTF-8");
                stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
                httpPost.setEntity(stringEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(token != null){
        	 httpPost.setHeader("Authorization", "Bearer " + token);
        } 
        return sendHttpPost(httpPost);
    }
     
    
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {  
        SSLContext sc = SSLContext.getInstance("SSLv3");  
      
        // 瀹炵幇涓�涓猉509TrustManager鎺ュ彛锛岀敤浜庣粫杩囬獙璇侊紝涓嶇敤淇敼閲岄潰鐨勬柟娉�  
        X509TrustManager trustManager = new X509TrustManager() {  
              
            public void checkClientTrusted(  
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,  
                    String paramString) throws CertificateException {  
            }  
      
            
            public void checkServerTrusted(  
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,  
                    String paramString) throws CertificateException {  
            }  
      
            
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {  
                return null;  
            }  
        };  
      
        sc.init(null, new TrustManager[] { trustManager }, null);  
        return sc;  
    }  
    
    public static void main(String[] args) throws Exception {
        
     
    
    }
}