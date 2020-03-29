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
	//测试输入字段汇总
	static String manage_com="330903";//出单机构代码
	static	String   store_code="21030006";//e门店编码
	static		String  order_no="1234567890";//单证号
	static	String name="王大";//用户姓名
	static	String phone="13012345678";//用户电话
	static		String agencyNo="21030006";//网点代码
	static	String operNo="21030006";//出单员代码
	static	String operName="";//出单员姓名
	
	static	String AppKey="hmmdyeo5wfocjoudek";//密钥
	static	String getAppSecret="562bc38ded3646fd96afaeede40b2aae";//密钥
	
	static String birthday="1993-09-20";//生日日期
	static String cert_no="350128199309200637";//被保人证件号
	static String product_code="P330000000025";//产品代码
	static String meal_code="P330000000025-001";//产品代码
	static Integer sumAmounti=50;//产品保额
	static Integer sum_prem=2;//总保费
	static String co_vali_date="2020-04-15";//起保日期
	static String pol_apply_date="2020-03-17";//投保申请日期
	static String insur_dur="D3";//保险期间
	static String storeid="33090321030006CYX";//保险期间
	
	public static void main(String[] args) throws Exception
	{	
		//出单
		chudan();
		
		//退单
//		cancelByNew();
		
		//执行退单操作
//		cancelByNew( policyNo,Agency agency,operNo, deptId);
	}
	
	
	
	//出单
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
		// 销售管理信息
//		JSONObject manageData = new JSONObject();
		
//		投保人信息
		JSONObject appinsuresData = new JSONObject();
		//被保人信息
		JSONObject insuredvosData = new JSONObject();
		//销售员信息
		JSONObject saleinfosData = new JSONObject();
		
		
		//接入来源系统(EDY-掌上保险；e 宝-eb；e店-ed)
		reqData.put("access_source", "EDY");
		//产品代码(必传)
		reqData.put("product_code", product_code);
		//套餐代码(必传)
		reqData.put("meal_code", meal_code);
		//产品保额
		reqData.put("amnt", sumAmounti);
		//总保费(必传)
		reqData.put("sum_prem", sum_prem);
		//总份数
		reqData.put("mult", new Integer(1));
		//交费方式(D：天 M：月 Y：年 A：岁 W：终身 C：约定 #：无关)
		reqData.put("pay_intv", "W");
		//门店编码(必传)
		reqData.put("storeid", storeid);
		//缴费形式(C-现金 T-银行转账 G-网上交费 Q-支票 P-POS机 D-社保结算 R-银行交款单 W-贷记凭证 M-事后收费 V-银行代收 Z-万能划转)
		reqData.put("pay_mode", "");
		//保险期间(Y1;M12;D365；Y-年；M-月；D-日)
//		String insurdur = "";
//		if ("1".equals(ration.getTimeType())) {
//			insurdur = "D" + ration.getInsperiod();// 按日
//		} else if ("2".equals(ration.getTimeType())) {
//			insurdur = "M" + ration.getInsperiod();// 按月
//		} else if ("3".equals(ration.getTimeType())) {
//			insurdur = "Y" + ration.getInsperiod();// 按月
//		}
		reqData.put("insu_year", "D3");
		//管理机构
		reqData.put("manage_com", manage_com);
		// 销售渠道
		reqData.put("sale_chnl", "OA");
		// 门店编码
		reqData.put("store_code", store_code);
		// 订单号
		reqData.put("order_no",order_no);
		//销售平台
		reqData.put("sale_plateform","EDY");
			
		//投保人信息
		JSONArray appinsuresArray = new JSONArray();
		//投保人地址
		appinsuresData.put("app_addr", "");
		//投保人地址合并
		appinsuresData.put("app_addr_merge", "");
		//投保人电子邮件
		appinsuresData.put("app_email", "");
		//家庭年收入
		appinsuresData.put("app_family_earning", "");
		//传真
		appinsuresData.put("app_fax", "");
		//投保人手机号
//		String appMobile="";
//		if(StringUtils.isNotBlank(transAppNo.getAppMobile())){
//			appMobile=transAppNo.getAppMobile();
//		}else if(StringUtils.isNotBlank(transAppNo.getIsdMobile())){
//			appMobile=transAppNo.getIsdMobile();
//				}
		appinsuresData.put("app_mobile",phone);
		//客户姓名
		appinsuresData.put("cust_name", name);
		//客户性别
		appinsuresData.put("cust_sex","M");	// 性别--必填(F-女 M-男)
		//证件类型
		appinsuresData.put("cert_type", "I");// 证件类型--必填(I-身份证,P--护照,S-军人证,R-在华居住证,O-其他)
		//证件号
		appinsuresData.put("cert_no", cert_no);// 证件号码--必填
		//出生日期
//		Date appInsureBirth = transAppNo.getAppinsureBirth();
//		if(appInsureBirth!=null){
//			int age=getAge(appInsureBirth);
//			appInsureBirth=age>100?DateUtils.getDateTimeByFormat("1980-01-01",GlobeConstants.DATE_SHORT_FORMAT):appInsureBirth;
//		}else{
//			appInsureBirth=DateUtils.getDateTimeByFormat("1980-01-01",GlobeConstants.DATE_SHORT_FORMAT);
//		}
		appinsuresData.put("cust_birthday", birthday);
		//投保人电话
		appinsuresData.put("app_tel","");// 电话号码--非必填
		appinsuresArray.element(appinsuresData);	
		reqData.put("app_insures", appinsuresArray);
		
		//投保总人数
		reqData.put("app_peoples", new Integer(1));
		//结算方式(C-现金 T-银行转账 G-网上交费 Q-支票 P-POS机 D-社保结算 R-银行交款单 W-贷记凭证 M-事后收费 V-银行代收 Z-万能划转)
		reqData.put("balance_mode", "C");	
		//合合同打印方式(0：电子保单||1：纸质保单)
		reqData.put("cntr_print_type", "");
		// 保单生效日期  date类型
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		reqData.put("co_vali_date", df.format(getDateTimeByFormat(co_vali_date, "yyyy-MM-dd")));
		//投保单申请日(必传)
		reqData.put("pol_apply_date", df.format(getDateTimeByFormat(pol_apply_date, "yyyy-MM-dd")));
		
		
		//保单类型(gd-个单;L-清汇;O-团单;G-团单，e门店用O表团单)
		reqData.put("cont_type", "gd");
		
		// 保险期间--必传(D1-1天,M1-1月,Y1-1年)
//		String insurdur = "";
//		if ("1".equals(ration.getTimeType())) {
//			insurdur = "D" + ration.getInsperiod();// 按日
//		} else if ("2".equals(ration.getTimeType())) {
//			insurdur = "M" + ration.getInsperiod();// 按月
//		} else if ("3".equals(ration.getTimeType())) {
//			insurdur = "Y" + ration.getInsperiod();// 按月
//		}
		reqData.put("insur_dur", insur_dur);
		//被保总人数
		reqData.put("insure_peoples", new Integer(1));
		
		//被保人信息
		JSONArray insuredvosArray = new JSONArray();
		//开户名
		insuredvosData.put("account_name", name);
		//被保人与投保人关系
//		if ("0".equals(transAppNo.getInsAndInsedRela())) {
			insuredvosData.put("apprlt", "M");
		//被保人与主保人关系
		insuredvosData.put("ipsn_rt_mst_ipsn", "M");
//		} else {
//			insuredvosData.put("apprlt", getInsAndInsedRela(transAppNo.getInsAndInsedRela()));
//		}
		//被保人证件号  
		insuredvosData.put("cert_no", cert_no);// 被保人证件号码--必填
		//证件类型  
		insuredvosData.put("cert_type", "I");
		//国家代码
		insuredvosData.put("county_code", "CHN");
		//出生日期
//		Date insuredBirth = transAppNo.getInsuredBirth();
//		String insuredBirths="1980-01-01";
//		if(transAppNo.getInsuredBirth()!=null){
//			int age=getAge(insuredBirth);
//			insuredBirths=age>100?"1980-01-01":DateUtils.getDateTimeStrByFormat(insuredBirth,GlobeConstants.DATE_SHORT_FORMAT);
//		}
		insuredvosData.put("cust_birthday",birthday );
		//客户姓名
		insuredvosData.put("cust_name", name);
		//客户性别
		insuredvosData.put("cust_sex", "M");
		//被保人地址
		insuredvosData.put("isd_addr", "");
		//证件有效日期
		insuredvosData.put("isd_cert_validate", "");
		//城乡类型{1:城市,2:农村}
		insuredvosData.put("isd_city_flag", "");
		//被保人工作单位
		insuredvosData.put("isd_company_name", "");
		//被保人电子邮件
		insuredvosData.put("isd_email", "");
		//被保人邮编
		insuredvosData.put("isd_post", "");
		//被保人职业代码
		insuredvosData.put("isd_prof_code", "");
		//被保人电话
//		insuredvosData.put("isd_tel", "24338214");
		//被保人手机(必传)
		insuredvosData.put("isd_mobile", "18850587367");
		//被保人类型 M||R(必传)
		insuredvosData.put("isd_type", "M");
		//被保人序号(必传)
		insuredvosData.put("isd_id", "1");
		insuredvosArray.element(insuredvosData);
		reqData.put("insured_vos", insuredvosArray);
		
		//销售员信息
		JSONArray saleinfosArray = new JSONArray();
		//管理机构
		saleinfosData.put("sales_branch_no", manage_com);
		//销售渠道(PA：个人代理 BS：业务员 OA：代理机构 SD：营业网点 SP：（银保通）代理点 RD：农村网点 EB：网上直销 PH：电话销售)
		saleinfosData.put("sales_channel", "OA");
		//网点号
		saleinfosData.put("sales_dept_no", agencyNo);
		//销售员工号
		saleinfosData.put("sales_no", operNo);
		//共同展业主副标记
		saleinfosData.put("devel_main_flag", "1");
		saleinfosArray.element(saleinfosData);
		reqData.put("sale_infos", saleinfosArray);
		
		logger.info("个单请求报文: " + reqData.toString());
		String token=getAccessToken(AppKey, getAppSecret);
//		String token=callBgrsjk(reqData.toString(),"https://api.hm.longqueyun.com/sandbox/oauth2/token");
		logger.info("token: " + token);
//		taWTdxxa083l4ipZRgH3h64fC4z-HOmr1KrjhfUByiqglA-LOIHyxvvM_3Pkrp1cMryhvssI-xI_IS-iV9Lt00F9ATRKTiI3MYA_gVkWFQYmWxuP7glfaE9SLOHARuPSYlOhqVaZlH
//		String resultStr=callBgrsjk(reqData.toString(),httpUrl,token);
		String resultStr = HttpClientUtil.sendHttpPostJson(httpUrl,reqData.toString(),token);
		logger.info("应答报文: " + resultStr);
		if ("".equals(resultStr) || resultStr == null) {
			logger.info("核心服务超时");
//			return resultDto;
		}
		JSONObject resJson = JSONObject.fromObject(resultStr);
//		if ("40102".equals(resJson.getString("code"))) {// token过期
//			token = TokenUtil.getAccessToken(redisClientTemplate,agency.getAppKey(),agency.getAppSecret());
//			resultStr = HttpClientUtil.sendHttpPostJson(httpUrl, reqData.toString(),token);
//			resJson = JSONObject.fromObject(resultStr);
//			logger.info("二次应答报文: " + resultStr);
//		}
//		if (!"0".equals(resJson.getString("code"))) {
//			resultDto.setMsg(resJson.getString("msg"));
//			return resultDto;
//		}
		JSONObject resultJson = JSONObject.fromObject(resJson.getString("result"));
		logger.info("出单响应--投保单号："+ resultJson.getString("app_no"));
		logger.info("出单响应--保单号："+ resultJson.getString("cntr_no"));
		logger.info("出单响应--交易状态："+ resultJson.getString("retcode"));// 0000:成功 其他失败
		logger.info("出单响应--交易信息："+ resultJson.getString("retmsg"));
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
            logger.error("调用Dat+"
                    + ".aService接口超时,超时时间:" + 300
                    + "秒,url:" + url + ",参数：" + requestParams, e);
            return jb.toString();
        } catch (Exception e) {
            logger.error("调用DataService接口失败,url:" + url + ",参数：" + requestParams,
                    e);
            return jb.toString();
        }
    }
	
	
    public static String sendHttpPostJson(String httpUrl, String paramsJson,String token) {
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
        try {
            // 设置参数
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
//        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
//        try {
//            // 设置参数
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
        // 响应内容
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
        	 httpClient = HttpClients.createDefault();
            // 配置请求信息
        	RequestConfig requestConfig;
        	 requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000)
                     .setConnectionRequestTimeout(60000).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Accept", "application/json;charset=utf-8"); 
           
            //设置头部-业务信息 
            // 执行请求
            response = httpClient.execute(httpPost);
            // 得到响应实例
            HttpEntity entity = response.getEntity();
 
            // 判断响应状态
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
                // 释放资源
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
  
    
    //获取token接口
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
				// 如果请求成功 
				JSONObject resObject = JSONObject.fromObject(repsonse);  
				if("0".equals(resObject.getString("code"))){
					String resultStr = resObject.getString("result");
					JSONObject resultObject = JSONObject.fromObject(resultStr); 
//					redisClientTemplate.setex(key,resultObject.getInt("expires_in")-200,resultObject.getString("access_token"));
					token=resultObject.getString("access_token");
				}else{
					logger.info("获取token失败-错误代码"+resObject.getString("code")+",错误信息"+resObject.getString("msg"));
				}
//			}
		}
		
		return token;
	}
    
    //执行退单操作
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
		// 投保单号
		reqData.put("appl_no",policyNo);
		//接入来源系统(EDY-掌上保险；e 宝-eb；e店-ed)
		reqData.put("access_source", "EDY");
		//销售员机构
		tracenodeData.put("pclk_branch_no", deptId);
		//销售员姓名
		tracenodeData.put("pclk_name", operName);//退单操作员
		//销售员工号
		tracenodeData.put("pclk_no", operNo);
		reqData.put("trace_node", tracenodeData);
	
		
//		reqData.put("cntr_no", "");
		String token=getAccessToken(AppKey,getAppSecret);
		logger.info("请求报文: " + reqData.toString());
		String resultStr = sendHttpPostJson(httpUrl,reqData.toString(),token);
		logger.info("应答报文: " + resultStr);
		if ("".equals(resultStr) || resultStr == null) {
			logger.info("核心服务超时");
//			return cancelResultDto;
		}
		JSONObject resJson = JSONObject.fromObject(resultStr);
		if ("40102".equals(resJson.getString("code"))) {
			token = getAccessToken(AppKey,getAppSecret);
			resultStr = sendHttpPostJson(httpUrl, reqData.toString(), token);
			logger.info("二次应答报文: " + resultStr);
			resJson = JSONObject.fromObject(resultStr);
		}
		if (!"0".equals(resJson.getString("code"))) {
			logger.info(resJson.getString("msg"));
//			return cancelResultDto;
		}
		JSONObject resultJson = resJson.getJSONObject("result");
		JSONObject cancelorderresponseJson = JSONObject.fromObject(resultJson.getString("cancel_order_response"));
//		JSONObject resultJson = JSONObject.fromObject(resJson.getString("result"));
		logger.info("撤单响应--交易状态："+ cancelorderresponseJson.getString("ret_code"));// 0000:成功 其他失败
		logger.info("撤单响应--交易信息："+ cancelorderresponseJson.getString("msg"));
		logger.info("撤单响应--错误描述："+ cancelorderresponseJson.getString("err_msg"));//错误描述
		logger.info("撤单响应--错误编码："+ cancelorderresponseJson.getString("ret_code"));//错误编码
		logger.info("撤单响应--合同状态："+ cancelorderresponseJson.getString("sg_no"));//合同状态
		if ("0".equals(resultJson.getString("code")) || "0000".equals(resultJson.getString("code"))) {
			logger.info("撤单响应--投保单号："+ cancelorderresponseJson.getString("appl_no"));
			logger.info(cancelorderresponseJson.getString("appl_no"));//投保单号
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