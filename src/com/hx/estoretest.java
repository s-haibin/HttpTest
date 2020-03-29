package com.hx;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.io.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class estoretest
{
	private static final Log logger = LogFactory.getLog(estoretest.class);
	//���������ֶλ���
	static String manage_com="330903";//������������
	static	String   store_code="21030006";//e�ŵ����
	static		String  order_no="1234567890";//��֤��
	static	String name="����";//�û�����
	static	String phone="13012345678";//�û��绰
	static		String agencyNo="21030006";//�������
	static	String operNo="21030006";//����Ա����
	static	String operName="";//����Ա����
	
	static	String AppKey="hmmdyeo5wfocjoudek";//��Կ
	static	String getAppSecret="562bc38ded3646fd96afaeede40b2aae";//��Կ
	
	static String birthday="1993-09-20";//��������
	static String cert_no="350128199309200637";//������֤����
	static String product_code="P330000000025";//��Ʒ����
	static String meal_code="P330000000025-001";//��Ʒ����
	static Integer sumAmounti=50;//��Ʒ����
	static Integer sum_prem=2;//�ܱ���
	static String co_vali_date="2020-04-15";//������
	static String pol_apply_date="2020-03-17";//Ͷ����������
	static String insur_dur="D3";//�����ڼ�
	static String storeid="33090321030006CYX";//�����ڼ�
	
	public static void main(String[] args) throws Exception
	{	
		//����
		chudan();
		
		//�˵�
//		cancelByNew();
		
		//ִ���˵�����
//		cancelByNew( policyNo,Agency agency,operNo, deptId);
	}
	
	
	
	//����
	public static void chudan(){
		String httpUrl = "https://api.hm.longqueyun.com/api/stiss/singleappl/insureapplcommit";
		JSONObject reqData = new JSONObject();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		
//		Ration ration = rationDao.get(Ration.class,transAppNo.getRationId());
		Map<String, Object> paraMap = new HashMap<String, Object>();
//		String hql = "FROM RationPre WHERE ration.rationId=:rationId Order By preId";
//		paraMap.put("rationId", transAppNo.getRationId());
//		List<RationPre> pres = rationPreDao.find(hql, paraMap); 
		double sumAmnt=50;
		
//		for (RationPre rationPre : pres) {
//			if(rationPre.getAmount()!=null){
//				sumAmnt=sumAmnt+rationPre.getAmount();
//				sumAmounti=Integer.valueOf((int)sumAmnt);
//			}
//		}
//		String deptId=agency.getDept().getDeptId();
		String keyCode = "25367498".substring(0, 2) + "0000Sd";
//		String keyCode = deptId.substring(0, 2) + "0000Sd";
		// ���۹�����Ϣ
//		JSONObject manageData = new JSONObject();
		
//		Ͷ������Ϣ
		JSONObject appinsuresData = new JSONObject();
		//��������Ϣ
		JSONObject insuredvosData = new JSONObject();
		//����Ա��Ϣ
		JSONObject saleinfosData = new JSONObject();
		
		
		//������Դϵͳ(EDY-���ϱ��գ�e ��-eb��e��-ed)
		reqData.put("access_source", "EDY");
		//��Ʒ����(�ش�)
		reqData.put("product_code", product_code);
		//�ײʹ���(�ش�)
		reqData.put("meal_code", meal_code);
		//��Ʒ����
		reqData.put("amnt", sumAmounti);
		//�ܱ���(�ش�)
		reqData.put("sum_prem", sum_prem);
		//�ܷ���
		reqData.put("mult", new Integer(1));
		//���ѷ�ʽ(D���� M���� Y���� A���� W������ C��Լ�� #���޹�)
		reqData.put("pay_intv", "W");
		//�ŵ����(�ش�)
		reqData.put("storeid", storeid);
		//�ɷ���ʽ(C-�ֽ� T-����ת�� G-���Ͻ��� Q-֧Ʊ P-POS�� D-�籣���� R-���н�� W-����ƾ֤ M-�º��շ� V-���д��� Z-���ܻ�ת)
		reqData.put("pay_mode", "");
		//�����ڼ�(Y1;M12;D365��Y-�ꣻM-�£�D-��)
//		String insurdur = "";
//		if ("1".equals(ration.getTimeType())) {
//			insurdur = "D" + ration.getInsperiod();// ����
//		} else if ("2".equals(ration.getTimeType())) {
//			insurdur = "M" + ration.getInsperiod();// ����
//		} else if ("3".equals(ration.getTimeType())) {
//			insurdur = "Y" + ration.getInsperiod();// ����
//		}
		reqData.put("insu_year", "D3");
		//�������
		reqData.put("manage_com", manage_com);
		// ��������
		reqData.put("sale_chnl", "OA");
		// �ŵ����
		reqData.put("store_code", store_code);
		// ������
		reqData.put("order_no",order_no);
		//����ƽ̨
		reqData.put("sale_plateform","EDY");
			
		//Ͷ������Ϣ
		JSONArray appinsuresArray = new JSONArray();
		//Ͷ���˵�ַ
		appinsuresData.put("app_addr", "");
		//Ͷ���˵�ַ�ϲ�
		appinsuresData.put("app_addr_merge", "");
		//Ͷ���˵����ʼ�
		appinsuresData.put("app_email", "");
		//��ͥ������
		appinsuresData.put("app_family_earning", "");
		//����
		appinsuresData.put("app_fax", "");
		//Ͷ�����ֻ���
//		String appMobile="";
//		if(StringUtils.isNotBlank(transAppNo.getAppMobile())){
//			appMobile=transAppNo.getAppMobile();
//		}else if(StringUtils.isNotBlank(transAppNo.getIsdMobile())){
//			appMobile=transAppNo.getIsdMobile();
//				}
		appinsuresData.put("app_mobile",phone);
		//�ͻ�����
		appinsuresData.put("cust_name", name);
		//�ͻ��Ա�
		appinsuresData.put("cust_sex","M");	// �Ա�--����(F-Ů M-��)
		//֤������
		appinsuresData.put("cert_type", "I");// ֤������--����(I-���֤,P--����,S-����֤,R-�ڻ���ס֤,O-����)
		//֤����
		appinsuresData.put("cert_no", cert_no);// ֤������--����
		//��������
//		Date appInsureBirth = transAppNo.getAppinsureBirth();
//		if(appInsureBirth!=null){
//			int age=getAge(appInsureBirth);
//			appInsureBirth=age>100?DateUtils.getDateTimeByFormat("1980-01-01",GlobeConstants.DATE_SHORT_FORMAT):appInsureBirth;
//		}else{
//			appInsureBirth=DateUtils.getDateTimeByFormat("1980-01-01",GlobeConstants.DATE_SHORT_FORMAT);
//		}
		appinsuresData.put("cust_birthday", birthday);
		//Ͷ���˵绰
		appinsuresData.put("app_tel","");// �绰����--�Ǳ���
		appinsuresArray.element(appinsuresData);	
		reqData.put("app_insures", appinsuresArray);
		
		//Ͷ��������
		reqData.put("app_peoples", new Integer(1));
		//���㷽ʽ(C-�ֽ� T-����ת�� G-���Ͻ��� Q-֧Ʊ P-POS�� D-�籣���� R-���н�� W-����ƾ֤ M-�º��շ� V-���д��� Z-���ܻ�ת)
		reqData.put("balance_mode", "C");	
		//�Ϻ�ͬ��ӡ��ʽ(0�����ӱ���||1��ֽ�ʱ���)
		reqData.put("cntr_print_type", "");
		// ������Ч����  date����
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		reqData.put("co_vali_date", df.format(getDateTimeByFormat(co_vali_date, "yyyy-MM-dd")));
		//Ͷ����������(�ش�)
		reqData.put("pol_apply_date", df.format(getDateTimeByFormat(pol_apply_date, "yyyy-MM-dd")));
		
		
		//��������(gd-����;L-���;O-�ŵ�;G-�ŵ���e�ŵ���O���ŵ�)
		reqData.put("cont_type", "gd");
		
		// �����ڼ�--�ش�(D1-1��,M1-1��,Y1-1��)
//		String insurdur = "";
//		if ("1".equals(ration.getTimeType())) {
//			insurdur = "D" + ration.getInsperiod();// ����
//		} else if ("2".equals(ration.getTimeType())) {
//			insurdur = "M" + ration.getInsperiod();// ����
//		} else if ("3".equals(ration.getTimeType())) {
//			insurdur = "Y" + ration.getInsperiod();// ����
//		}
		reqData.put("insur_dur", insur_dur);
		//����������
		reqData.put("insure_peoples", new Integer(1));
		
		//��������Ϣ
		JSONArray insuredvosArray = new JSONArray();
		//������
		insuredvosData.put("account_name", name);
		//��������Ͷ���˹�ϵ
//		if ("0".equals(transAppNo.getInsAndInsedRela())) {
			insuredvosData.put("apprlt", "M");
		//�������������˹�ϵ
		insuredvosData.put("ipsn_rt_mst_ipsn", "M");
//		} else {
//			insuredvosData.put("apprlt", getInsAndInsedRela(transAppNo.getInsAndInsedRela()));
//		}
		//������֤����  
		insuredvosData.put("cert_no", cert_no);// ������֤������--����
		//֤������  
		insuredvosData.put("cert_type", "I");
		//���Ҵ���
		insuredvosData.put("county_code", "CHN");
		//��������
//		Date insuredBirth = transAppNo.getInsuredBirth();
//		String insuredBirths="1980-01-01";
//		if(transAppNo.getInsuredBirth()!=null){
//			int age=getAge(insuredBirth);
//			insuredBirths=age>100?"1980-01-01":DateUtils.getDateTimeStrByFormat(insuredBirth,GlobeConstants.DATE_SHORT_FORMAT);
//		}
		insuredvosData.put("cust_birthday",birthday );
		//�ͻ�����
		insuredvosData.put("cust_name", name);
		//�ͻ��Ա�
		insuredvosData.put("cust_sex", "M");
		//�����˵�ַ
		insuredvosData.put("isd_addr", "");
		//֤����Ч����
		insuredvosData.put("isd_cert_validate", "");
		//��������{1:����,2:ũ��}
		insuredvosData.put("isd_city_flag", "");
		//�����˹�����λ
		insuredvosData.put("isd_company_name", "");
		//�����˵����ʼ�
		insuredvosData.put("isd_email", "");
		//�������ʱ�
		insuredvosData.put("isd_post", "");
		//������ְҵ����
		insuredvosData.put("isd_prof_code", "");
		//�����˵绰
//		insuredvosData.put("isd_tel", "24338214");
		//�������ֻ�(�ش�)
		insuredvosData.put("isd_mobile", "18850587367");
		//���������� M||R(�ش�)
		insuredvosData.put("isd_type", "M");
		//���������(�ش�)
		insuredvosData.put("isd_id", "1");
		insuredvosArray.element(insuredvosData);
		reqData.put("insured_vos", insuredvosArray);
		
		//����Ա��Ϣ
		JSONArray saleinfosArray = new JSONArray();
		//�������
		saleinfosData.put("sales_branch_no", manage_com);
		//��������(PA�����˴��� BS��ҵ��Ա OA��������� SD��Ӫҵ���� SP��������ͨ������� RD��ũ������ EB������ֱ�� PH���绰����)
		saleinfosData.put("sales_channel", "OA");
		//�����
		saleinfosData.put("sales_dept_no", agencyNo);
		//����Ա����
		saleinfosData.put("sales_no", operNo);
		//��ͬչҵ�������
		saleinfosData.put("devel_main_flag", "1");
		saleinfosArray.element(saleinfosData);
		reqData.put("sale_infos", saleinfosArray);
		
		logger.info("����������: " + reqData.toString());
		String token=getAccessToken(AppKey, getAppSecret);
//		String token=callBgrsjk(reqData.toString(),"https://api.hm.longqueyun.com/sandbox/oauth2/token");
		logger.info("token: " + token);
//		taWTdxxa083l4ipZRgH3h64fC4z-HOmr1KrjhfUByiqglA-LOIHyxvvM_3Pkrp1cMryhvssI-xI_IS-iV9Lt00F9ATRKTiI3MYA_gVkWFQYmWxuP7glfaE9SLOHARuPSYlOhqVaZlH
//		String resultStr=callBgrsjk(reqData.toString(),httpUrl,token);
		String resultStr = HttpClientUtil.sendHttpPostJson(httpUrl,reqData.toString(),token);
		logger.info("Ӧ����: " + resultStr);
		if ("".equals(resultStr) || resultStr == null) {
			logger.info("���ķ���ʱ");
//			return resultDto;
		}
		JSONObject resJson = JSONObject.fromObject(resultStr);
//		if ("40102".equals(resJson.getString("code"))) {// token����
//			token = TokenUtil.getAccessToken(redisClientTemplate,agency.getAppKey(),agency.getAppSecret());
//			resultStr = HttpClientUtil.sendHttpPostJson(httpUrl, reqData.toString(),token);
//			resJson = JSONObject.fromObject(resultStr);
//			logger.info("����Ӧ����: " + resultStr);
//		}
//		if (!"0".equals(resJson.getString("code"))) {
//			resultDto.setMsg(resJson.getString("msg"));
//			return resultDto;
//		}
		JSONObject resultJson = JSONObject.fromObject(resJson.getString("result"));
		logger.info("������Ӧ--Ͷ�����ţ�"+ resultJson.getString("app_no"));
		logger.info("������Ӧ--�����ţ�"+ resultJson.getString("cntr_no"));
		logger.info("������Ӧ--����״̬��"+ resultJson.getString("retcode"));// 0000:�ɹ� ����ʧ��
		logger.info("������Ӧ--������Ϣ��"+ resultJson.getString("retmsg"));
//		if ("0000".equals(resultJson.getString("retcode"))) {
//			String appNo=resultJson.getString("app_no");
//			resultDto.setAppNo(appNo);
//			resultDto.setSuccess(true);
//		} else {
//			resultDto.setMsg(resultJson.getString("retmsg"));
//		} 
		
	}
	
	
	
	
	public static String callBgrsjk(String requestParams,String url,String token) {
//        String url = null;
        JSONObject jb=new JSONObject();
        jb.put("code",0);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(300 * 1000)
                    .setConnectTimeout(300 * 1000)
                    .build();
//            url = "https://api.hm.longqueyun.com/api/stiss/singleappl/insureapplcommit";
         
            HttpPost post = new HttpPost(url);
            post.setConfig(requestConfig);
//            post.setHeader("Content-Type","application/json;charset=utf-8");
            if(token != null){
            	 post.setHeader("Authorization", "Bearer " + token);
           }
            StringEntity postingString = new StringEntity(requestParams,
                    "utf-8");
            post.setEntity(postingString);
            HttpResponse response = httpClient.execute(post);
            String content = EntityUtils.toString(response.getEntity());
            System.out.println(content);
            return content;
        } catch (SocketTimeoutException e) {
            logger.error("����Dat+"
                    + ".aService�ӿڳ�ʱ,��ʱʱ��:" + 300
                    + "��,url:" + url + ",������" + requestParams, e);
            return jb.toString();
        } catch (Exception e) {
            logger.error("����DataService�ӿ�ʧ��,url:" + url + ",������" + requestParams,
                    e);
            return jb.toString();
        }
    }
	
	
    public static String sendHttpPostJson(String httpUrl, String paramsJson,String token) {
        HttpPost httpPost = new HttpPost(httpUrl);// ����httpPost
        try {
            // ���ò���
            if (paramsJson != null && paramsJson.trim().length() > 0) {
                StringEntity stringEntity = new StringEntity(paramsJson, "UTF-8");
                stringEntity.setContentType("application/json;charset=utf-8");
                httpPost.setEntity(stringEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(token != null){
        	 httpPost.setHeader("Authorization", "Bearer " + token);
        } 
        return HttpClientUtil.sendHttpPost(httpPost);
    }
    
//    public static String sendHttpPostJson(String httpUrl, String paramsJson,String token) {
//        HttpPost httpPost = new HttpPost(httpUrl);// ����httpPost
//        try {
//            // ���ò���
//            if (paramsJson != null && paramsJson.trim().length() > 0) {
//                StringEntity stringEntity = new StringEntity(paramsJson, "UTF-8");
//                stringEntity.setContentType("application/json;charset=utf-8");
//                httpPost.setEntity(stringEntity);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if(token != null){
//        	 httpPost.setHeader("Authorization", "Bearer " + token);
//        } 
//        return sendHttpPost(httpPost);
//    }
    
    public static String sendHttpPost(HttpPost httpPost) { 
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        // ��Ӧ����
        String responseContent = null;
        try {
            // ����Ĭ�ϵ�httpClientʵ��.
        	 httpClient = HttpClients.createDefault();
            // ����������Ϣ
        	RequestConfig requestConfig;
        	 requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000)
                     .setConnectionRequestTimeout(60000).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Accept", "application/json;charset=utf-8"); 
           
            //����ͷ��-ҵ����Ϣ 
            // ִ������
            response = httpClient.execute(httpPost);
            // �õ���Ӧʵ��
            HttpEntity entity = response.getEntity();
 
            // �ж���Ӧ״̬
            if (response.getStatusLine().getStatusCode() >= 300) {
                logger.error("Response code is " + response.getStatusLine().getStatusCode());
            	throw new Exception(
                        "HTTP Request is not success, Response code is " + response.getStatusLine().getStatusCode());
            }

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                responseContent = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // �ͷ���Դ
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
  
    
    //��ȡtoken�ӿ�
    public static String getAccessToken(String appid, String appsecret) {
		String token="";
		String key=appid+appsecret;
//		if(StringUtils.isBlank(redisClientTemplate.get(key))){
			JSONObject paramObject = new JSONObject();
			paramObject.put("app_key", appid); 
			paramObject.put("app_secret", appsecret); 
			String repsonse = sendHttpPostJson("https://api.hm.longqueyun.com/oauth2/token", paramObject.toString(),null); 
			logger.info("repsonse: " +repsonse);
			if(repsonse!=null){
				// �������ɹ� 
				JSONObject resObject = JSONObject.fromObject(repsonse);  
				if("0".equals(resObject.getString("code"))){
					String resultStr = resObject.getString("result");
					JSONObject resultObject = JSONObject.fromObject(resultStr); 
//					redisClientTemplate.setex(key,resultObject.getInt("expires_in")-200,resultObject.getString("access_token"));
					token=resultObject.getString("access_token");
				}else{
					logger.info("��ȡtokenʧ��-�������"+resObject.getString("code")+",������Ϣ"+resObject.getString("msg"));
				}
//			}
		}
		
		return token;
	}
    
    //ִ���˵�����
	private static String cancelByNew(){
		
//		String  policyNo="1220203301993307";
//		String  policyNo="122020330199330799999";
		String  policyNo="1220203302001489";
		String agency="21030006";
		String operNo="21030006";
		String deptId="330903";
//		CancelResultDto cancelResultDto=new CancelResultDto();
//		String httpUrl=(String)CacheManager.getCacheInfo(GlobeConstants.CONFIG_CANCEL_APPL_URL).getValue();
		String httpUrl="https://api.hm.longqueyun.com/api/stiss/cancelorder";
//		Map<String, Object> mapParam = new HashMap<String, Object>();
//		String hql = "FROM PosUser WHERE operNo=:operNo AND deptId= :deptId";
//		mapParam.clear();
//		mapParam.put("operNo", operNo);
//		mapParam.put("deptId", deptId);
//		PosUser posUser = posUserDao.get(hql, mapParam);
		JSONObject reqData = new JSONObject();
		JSONObject tracenodeData = new JSONObject();
		// Ͷ������
		reqData.put("appl_no",policyNo);
		//������Դϵͳ(EDY-���ϱ��գ�e ��-eb��e��-ed)
		reqData.put("access_source", "EDY");
		//����Ա����
		tracenodeData.put("pclk_branch_no", deptId);
		//����Ա����
		tracenodeData.put("pclk_name", operName);//�˵�����Ա
		//����Ա����
		tracenodeData.put("pclk_no", operNo);
		reqData.put("trace_node", tracenodeData);
	
		
//		reqData.put("cntr_no", "");
		String token=getAccessToken(AppKey,getAppSecret);
		logger.info("������: " + reqData.toString());
		String resultStr = sendHttpPostJson(httpUrl,reqData.toString(),token);
		logger.info("Ӧ����: " + resultStr);
		if ("".equals(resultStr) || resultStr == null) {
			logger.info("���ķ���ʱ");
//			return cancelResultDto;
		}
		JSONObject resJson = JSONObject.fromObject(resultStr);
		if ("40102".equals(resJson.getString("code"))) {
			token = getAccessToken(AppKey,getAppSecret);
			resultStr = sendHttpPostJson(httpUrl, reqData.toString(), token);
			logger.info("����Ӧ����: " + resultStr);
			resJson = JSONObject.fromObject(resultStr);
		}
		if (!"0".equals(resJson.getString("code"))) {
			logger.info(resJson.getString("msg"));
//			return cancelResultDto;
		}
		JSONObject resultJson = resJson.getJSONObject("result");
		JSONObject cancelorderresponseJson = JSONObject.fromObject(resultJson.getString("cancel_order_response"));
//		JSONObject resultJson = JSONObject.fromObject(resJson.getString("result"));
		logger.info("������Ӧ--����״̬��"+ cancelorderresponseJson.getString("ret_code"));// 0000:�ɹ� ����ʧ��
		logger.info("������Ӧ--������Ϣ��"+ cancelorderresponseJson.getString("msg"));
		logger.info("������Ӧ--����������"+ cancelorderresponseJson.getString("err_msg"));//��������
		logger.info("������Ӧ--������룺"+ cancelorderresponseJson.getString("ret_code"));//�������
		logger.info("������Ӧ--��ͬ״̬��"+ cancelorderresponseJson.getString("sg_no"));//��ͬ״̬
		if ("0".equals(resultJson.getString("code")) || "0000".equals(resultJson.getString("code"))) {
			logger.info("������Ӧ--Ͷ�����ţ�"+ cancelorderresponseJson.getString("appl_no"));
			logger.info(cancelorderresponseJson.getString("appl_no"));//Ͷ������
			logger.info(resultJson.getString("msg"));
//			cancelResultDto.setSuccess(true);
		} else {
			logger.info(resultJson.getString("msg"));
		}
//		return cancelResultDto;
		return resultStr;
	}
	
	public static Date getDateTimeByFormat(String dateStr, String format) {
		Date date=null;
		if(null==dateStr){
			return date;
		}
		SimpleDateFormat sFormat = new SimpleDateFormat(format);
		try {
			date = sFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}