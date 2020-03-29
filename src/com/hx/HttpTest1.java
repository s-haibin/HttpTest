package com.hx;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public class HttpTest1 {

	
 // private static  String URL="http://61.154.14.77:8083/dtam_service!";
//	private static  String URL="http://40.1.60.106:8087/dtam_service!";
//	private static  String URL="http://127.0.0.1:8083/dtam/dtam_service!";
//	private static  String URL="http://172.16.74.80:8083/dtam/dtam_service!";
//	private static  String URL="http://127.0.0.1:8083/dtam_service!";
//	private static  String URL="http://127.0.0.1:8005/dtam_service!";
	private static  String URL="http://127.0.0.1:8080/dtam/dtam_service!";
//	private static  String URL="http://app.fjpicc.com:8083/dtam_service!";
	
//	private static String URL="http://localhost:8080/wxtest/user/bean2json";

  public static void main(String[] args) {
	  //登录
//	  savePredict();//预计数
	 //queryPunchState();
	 //punchCard();
	 //insGather();
	  userLogin();//登录
	 //savePredict();
	 //queryPunchState();
//	 queryCustomerInfo();
	 //addCustomerInfo();
	 //statsCarInsInfo();
	 //statsAgentInsInfo();
//	 statsDayAgentInsInfo();
	 //getSubDepts();
//	 statsDayAgentInsSum();
	 //statsCustomerInfo();
//	 addRepairFee();
	 //getUserWorkGroups();
	 //saveAgentLocal();
//	  addInsInfo();//新车数据采集
	 // statsAttendance();
	 // addTrack();
//	  queryPushReq();
//	  addPushRepair();
	 //queryAgentDistInfo();
	  //auditDistInfo();
//	  queryAdminWorkGroups();
	 // queryClaimsProc();
	 // queryClaimHistory();
	  //queryOtherReg();
	//queryCheckTask();
	  //queryCompensateDis();
	// queryCompensateInfo();
	 // queryLossInfo();
	 // queryState();
	  
//	 showInsInfo();
	  
//	  modifyInsInfo();//新车数据采集补录
//	  modifyInsInfo();
//	  userLogin();
//	  addCarInsInfo();
//	  queryPushRepair();
//	  qryCarInsInfo();
//	  getleaveapplycount();
//	  getleaveapprovelist();
//	  getwx();
  }
  
  
  private static void getwx() {
	  String curUrl=URL;
	  JSONObject param=new JSONObject();
	  param.put("id",1);//07014108
//	  param.put("applyflag","0");//07014108
//	  System.out.println(param.toString());
	  post(curUrl,param.toString());	
}
  
  private static void getleaveapprovelist() {
	  String curUrl=URL+"getleaveapprovelist";
	  JSONObject param=new JSONObject();
	  param.put("operno","08028822");//07014108
	  param.put("applyflag","0");//07014108
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
	
}

private static void getleaveapplycount() {
	  String curUrl=URL+"getleaveapplycount";
	  JSONObject param=new JSONObject();
	  param.put("operno","08028822");//07014108
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
	
}

public static void userLogin(){
//	{"operNo":"07015195","userPwd":"1111","os":"android29","version":"10.0","deviceId":"start123456789","token":"18071adc0396c4968de"}
	  String curUrl=URL+"userLogin";
	  JSONObject param=new JSONObject();
//	  post(curUrl,"{'operNo':'07004009','userPwd':'1111'}");
//	  post(curUrl,"{'operNo':'35239860','userPwd':'1111','os':'ios11','version':'6.11'}");
//	  post(curUrl,"{'operNo':'35239860','userPwd':'1111','version':'4.1'}");
//	  param.put("operNo","83515191");//07014108
	  param.put("operNo","A351504099");//07015195
//	  param.put("userPwd","123");
	  param.put("userPwd","1111");
//	  param.put("version","6.3");
//	  param.put("version","6.30");
	  param.put("version","10.0");
	  param.put("os","android29");
//	  param.put("os","ios13.3");
//	  param.put("android","");
	  param.put("deviceId","HUAWEIunknownHUAWEIVOG-AL10");
	  param.put("deviceId","2540AEF9-4920-46EF-ACA3-7C18CBF49BF6");
//	  param.put("deviceId","start123456789");
//	  param.put("token","22140fe1da9eecee1097c");
	  param.put("token","18071adc0396c4968de");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
	 
  }
  
  public static void addPushRepair(){
	  String curUrl=URL+"addPushRepair";
	  JSONObject param=new JSONObject();
//	  param.put("operDate","2017-05-27 08:32:30");
//	  param.put("carNo","闽AU601Y");
//	  param.put("reportId","RDZA2017350100006");
//	  param.put("agentCode","3501003000061");
//	  param.put("userCode","admin");
//	  param.put("repairAmt",1.234);
//	  param.put("backFactory",1);
//	  param.put("selfCompanyType",2);
//	  param.put("cusPhone","1234");
//	  param.put("backFactoryText","1234");
	  param.put("reportId","3456");
	  param.put("repairAmt","55");
	  param.put("backFactory","1");
	  param.put("userCode","0001");
	  param.put("backFactoryText","我在这里的");
	  param.put("operDate","2019-04-18");
	  param.put("flag","0");
	  param.put("agentCode","3508721000041");
	  param.put("selfCompanyType","中华联");
	  param.put("cusPhone","34566");
	  post(curUrl,param.toString());
//	  "agentCode" : "3508721000041",  "selfCompanyType" : "中华联",  "cusPhone" : "34566"}
//	  2019-04-29 10:38:23 
  }
  
  
  public static void  savePredict(){
	  String curUrl=URL+"savePredict";
	  JSONObject param=new JSONObject();
	  param.put("sellNum","1");
	  param.put("insShare","1.12");
	  param.put("invoiceShare","0.33");
	  param.put("agentCode","3505049734007");
	  param.put("userCode","83514463");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  public static void queryPunchState(){
	  String curUrl=URL+"queryPunchState";
	  JSONObject param=new JSONObject();
	  param.put("userCode","83522863");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  public static void queryPushReq(){
	  String curUrl=URL+"queryPushRepInfos";
	  JSONObject param=new JSONObject();
//	  param.put("agentCode","3501003000061");
//	  param.put("agentCode","3506001037027");//2019-03-05
	  param.put("agentCode","3506028711004");//2019-03-05
	  param.put("operDate","2019-03-05");
	  param.put("endDate","2019-04-10");
	  param.put("flag","0");
	  param.put("page","1");
	  param.put("rows","20");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void statsAttendance(){
	  String curUrl=URL+"statsAttendance";
	  JSONObject param=new JSONObject();
	  param.put("deptId","35010000");
	  param.put("startDate","2017-04-19");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void statsDayAgentInsInfo(){
	  String curUrl=URL+"statsDayAgentInsInfo";
	  JSONObject param=new JSONObject();
	  param.put("agentCode","3505001000218");
	 // param.put("userCode","07003385");
	  param.put("deptId", "35058300");
	  param.put("orgType", "1");
//	  param.put("page", "2");	  
//	  param.put("rows", 15);
	 // param.put("deptId","3500");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void showInsInfo(){
	  String curUrl=URL+"showInsInfo";
	  JSONObject param=new JSONObject();
	  param.put("agentCode","3508721000041");
//	  param.put("agentCode","3503998000074");
	  param.put("userCode","0003");
//	  param.put("userCode","07012510");
	  param.put("createDate","2019-05-24");//可选 不选默认当天08:32:30
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  
  public static void punchCard(){
	  String curUrl=URL+"punchCard";
	  JSONObject param=new JSONObject();
//	  param.put("userCode","admin");
//	  param.put("punchtype",2);
//	  param.put("longitudeIn",360);
//	  param.put("latitudeIn", 360);
//	  System.out.println(param.toString());
//	  param.put("userCode","admin");
//	  param.put("punchtype",2);
//	  param.put("agentcode","2");
//	  param.put("longitudeOut",360);
//	  param.put("latitudeOut",360);
//	  String s="{userCode:\"83511241\",\"agentcode\":\"3501731000169\",\"punchtype\":2,\"longitudeOut\":119.355093,\"latitudeOut\":26.016362}";
	  
	  
	//  post(curUrl,s);
  }
  
  public static void statsCustomerInfo(){
	  String curUrl=URL+"statsCustomerInfo";
	  JSONObject param=new JSONObject();

	  param.put("groupType","2");
	  param.put("deptId", "35060300");
	  param.put("startDate", "2017-05-22");
	  param.put("endDate", "2017-05-22");
	  param.put("page",2);
	  param.put("rows",15);
	  System.out.println(param.toString());
	  post(curUrl,param.toString());    
	  
  }



 public static void addRepairFee(){
	  String curUrl=URL+"addRepairFee";
	  JSONObject param=new JSONObject();
	  param.put("agentCode","3515536000151");
	  param.put("userCode","07005279");
	  param.put("companyFee",1.1);
	  param.put("othCompanyFee",2);
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void addInsInfo(){
//	  insDetails22storesInsNum22companyType22ownership%22%20%3A%20%22%22%20%20%20%20%7D%2C%20%20%20%20%7B%20%20%20%20%20%20%22storesInsNum%22%20%3A%20%22%22%2C%20%20%20%20%20%20%22companyType%22%20%3A%202%2C%20%20%20%20%20%20%22ownership%22%20%3A%20%22%22%20%20%20%20%7D%2C%20%20%20%20%7B%20%20%20%20%20%20%22storesInsNum%22%20%3A%20%22%22%2C%20%20%20%20%20%20%22companyType%22%20%3A%203%2C%20%20%20%20%20%20%22ownership%22%20%3A%20%22%22%20%20%20%20%7D%2C%20%20%20%20%7B%20%20%20%20%20%20%22storesInsNum%22%20%3A%20%22%22%2C%20%20%20%20%20%20%22companyType%22%20%3A%200%2C%20%20%20%20%20%20%22ownership%22%20%3A%20%22%22%20%20%20%20%7D%20%20%5D%2C%20%20%22theftInsNum%22%20%3A%20%22%22%2C%20%20%22comCode%22%20%3A%20%2235030063%22%2C%20%20%22insNum%22%20%3A%20%220%22%2C%20%20%22recordType%22%20%3A%20%220%22%2C%20%20%22type%22%20%3A%202%2C%20%20%22thirdInsNum%22%20%3A%20%22%22%2C%20%20%22selfCompanyType%22%20%3A%201%2C%20%20%22totalPre%22%20%3A%20%22%22%2C%20%20%22userCode%22%20%3A%20%2207013070%22%2C%20%20%22currentDetails%22%20%3A%20%5B%20%20%5D%2C%20%20%22sCollectNum%22%20%3A%20%220%22%7D
//	  {"aInsInfoId":0,"agentCode":"3508721000041","totalPre":0,"selfCompanyType":1,"insNum":1,"sCollectNum":0,"comCode":"35082400","userCode":"0001","type":2,"storesInsNum":1,"insDetails":[{"companyType":0,"storesInsNum":0,"ownership":""},{"companyType":1,"storesInsNum":1,"ownership":""},{"companyType":2,"storesInsNum":0,"ownership":""},{"companyType":3,"storesInsNum":0,"ownership":""}],"currentDetails":[],"theftInsNum":0,"thirdInsNum":0,"sFromwNum":"","recordType":"1","createDate":"2019-4-20"}

	  String curUrl=URL+"addInsInfo";
//	 storesInsNum":11,"insDetails":[{"companyType":0,"storesInsNum":0,"ownership":""},{"companyType":1,"storesInsNum":11,"ownership":""},{"companyType":2,"storesInsNum":0,"ownership":""},{"companyType":3,"storesInsNum":0,"ownership":""}],"currentDetails":[],"theftInsNum":0,"thirdInsNum":0,"sFromwNum":"0","recordType":"1","createDate":"2019-4-23"}

	  JSONObject param=new JSONObject();
	  param.put("agentCode","3508721000041");
	  param.put("totalPre","0");
	  param.put("userCode","0001");
	  param.put("selfCompanyType",1);
	  param.put("createDate","2019-4-22");
//	  param.put("sellWkaNum", 11);
//	  param.put("sellWkaAttr","太平1");
	  param.put("comCode","35082400");
//	  param.put("userId","admin");
	  param.put("type",2);
	  param.put("insNum",11);
	  
//	  param.put("storesInsNum",22);
//	  param.put("sStoresInsNum",33);
//	  param.put("insShare",33.33);
//	  param.put("invoiceShare",44.44);
	  JSONArray jsonArray=new JSONArray();
	  JSONObject AgentInsDetail1=new JSONObject(); 
	  AgentInsDetail1.put("companyType", 1);
	  AgentInsDetail1.put("storesInsNum", 1);
	  AgentInsDetail1.put("sStoresInsNum", 1);
//	  AgentInsDetail1.put("attr","测试1"); 
	  JSONObject AgentInsDetail2=new JSONObject();
	  AgentInsDetail2.put("companyType", 2);
	  AgentInsDetail2.put("storesInsNum",2);
	  AgentInsDetail2.put("sStoresInsNum",2);
//	  AgentInsDetail2.put("attr","测试2");
	  JSONObject AgentInsDetail3=new JSONObject();
	  AgentInsDetail3.put("companyType", 3);
	  AgentInsDetail3.put("storesInsNum",3);
	  AgentInsDetail3.put("sStoresInsNum",3);
	  JSONObject AgentInsDetail4=new JSONObject();
	  AgentInsDetail4.put("companyType", 4);
	  AgentInsDetail4.put("storesInsNum",4);
	  AgentInsDetail4.put("sStoresInsNum",4);
//	  AgentInsDetail2.put("attr","测试2");
	  jsonArray.add(AgentInsDetail1);
	  jsonArray.add(AgentInsDetail2);
	  jsonArray.add(AgentInsDetail3);
	  jsonArray.add(AgentInsDetail4);
	  param.put("insDetails",jsonArray.toString());
	 
	  
	  System.out.println(param.toString());
	  //param.put("currentDetails",null);
	  post(curUrl,param.toString());
  }
  
  
  public static void modifyInsInfo(){
	  String curUrl=URL+"modifyInsInfo";
	  JSONObject param=new JSONObject();
	  param.put("aInsInfoId",617933);
	  param.put("agentCode","3507053000141");
	  param.put("userCode","11080023");
	  param.put("selfCompanyType",0);
	  param.put("comCode","35078300");
	  param.put("userId","11080023");
	  param.put("type",1);
	  param.put("insNum",12);
	  param.put("createDate","2019-04-07 22:33:33");//可选，不选默认当前时间
	  param.put("storesInsNum",22);
	  param.put("sStoresInsNum",33);
	  param.put("insShare",33.33);
	  param.put("sellWkaNum", 1);
	  param.put("invoiceShare",44.44);
	  JSONArray jsonArray=new JSONArray();
	  
	  JSONObject AgentInsDetail1=new JSONObject(); 
	  
	  JSONObject AgentInsDetail0=new JSONObject();
	  AgentInsDetail0.put("companyType", 0);
	  AgentInsDetail0.put("storesInsNum", 0);
	  AgentInsDetail0.put("sStoresInsNum",2);
	  AgentInsDetail0.put("ownership","33333");
	  
	 // AgentInsDetail1.put("id",186);
	  AgentInsDetail1.put("companyType", 1);
	  AgentInsDetail1.put("storesInsNum", 1);
	  AgentInsDetail1.put("sStoresInsNum",4);
	  AgentInsDetail1.put("ownership","22222");
	  
	  JSONObject AgentInsDetail2=new JSONObject();
	  
	 // AgentInsDetail2.put("id",187);
	  AgentInsDetail2.put("companyType", 2);
	  AgentInsDetail2.put("storesInsNum",2);
	  AgentInsDetail2.put("sStoresInsNum", 1567);
	  AgentInsDetail2.put("ownership","测试2");
	  
	  
	  JSONObject AgentInsDetail3=new JSONObject();
	  AgentInsDetail3.put("companyType", 3);
	  AgentInsDetail3.put("storesInsNum", 3);
	  AgentInsDetail3.put("sStoresInsNum",4);
	  AgentInsDetail3.put("ownership","测试11122");
	  
	  JSONObject AgentInsDetail4=new JSONObject();
	  AgentInsDetail4.put("companyType", 4);
	  AgentInsDetail4.put("storesInsNum", 4);
	  AgentInsDetail4.put("sStoresInsNum",4);
	  AgentInsDetail4.put("ownership","测试11122");
	  
	  jsonArray.add(AgentInsDetail0);
	  jsonArray.add(AgentInsDetail1);
	  jsonArray.add(AgentInsDetail2);
	  jsonArray.add(AgentInsDetail3);
	  jsonArray.add(AgentInsDetail4);
	  param.put("insDetails",jsonArray.toString());
	 
	  
	  post(curUrl,param.toString());
  }

  
  
  
  
  public static void statsCarInsInfo(){
	  String curUrl=URL+"statsCarInsInfo";
	  JSONObject jsonObject=new JSONObject();
	  jsonObject.put("deptId", "35060300");
	  jsonObject.put("startDate", "2017-05-22");
	  jsonObject.put("endDate", "2017-05-22");
	 // jsonObject.put("userCode", "08028820");
	  jsonObject.put("type", "1");
	  post(curUrl,jsonObject.toString());
  }
  
  public static void addTrack(){
	  String curUrl=URL+"addTrack";
	  JSONObject jsonObject=new JSONObject();
	 // jsonObject.put("deptId", "3500");
	  jsonObject.put("punchId","123");
	  JSONObject track=new JSONObject();
	  track.put("longitude",122);
	  track.put("latitude",122);
	  track.put("createDate","2017-05-20 22:33:33");
	  JSONArray jsonArray=new JSONArray();
	  jsonArray.add(track);
	  jsonObject.put("tracks",jsonArray);
	  System.out.println(jsonObject);
	 // jsonObject.put("type", "1");
	  post(curUrl,jsonObject.toString());
  }
  
  
  public static void addCustomerInfo(){
	  String curUrl=URL+"addCustomerInfo";
	  JSONObject jsonObject=new JSONObject();
	  jsonObject.put("carNo","cs1");
	  jsonObject.put("mobile", "cs123");
	  jsonObject.put("vinCode", "vincode");
	  jsonObject.put("endDate","2017-04-20");
	  post(curUrl,jsonObject.toString());
  }
  
  
  
  public static void queryCustomerInfo(){
	  String curUrl=URL+"queryCustomerInfo";
	  JSONObject jsonObject=new JSONObject();
	   jsonObject.put("userCode","A350600566");
	  //jsonObject.put("deptId","3500");
	  jsonObject.put("startDate","2019-08-15");
	  jsonObject.put("endDate","2019-08-15");
	  jsonObject.put("orgType","3");	  
	   jsonObject.put("page",1);
	  jsonObject.put("rows",6);
	  System.out.println(jsonObject.toString());
	  post(curUrl,jsonObject.toString());
  }
  
  
  public static void statsAgentInsInfo(){
	  String curUrl=URL+"statsAgentInsInfo";
	  JSONObject jsonObject=new JSONObject();
	  jsonObject.put("userCode","08028820");
	  System.out.println(jsonObject.toString());
	  post(curUrl,jsonObject.toString());
  }
  
  
  public static void statsDayAgentInsSum(){
	  String curUrl=URL+"statsDayAgentInsSum";
	  JSONObject jsonObject=new JSONObject();
	  jsonObject.put("deptId","35058300");
	  jsonObject.put("deptId","3505001000218");
	  jsonObject.put("orgType","1");
	  System.out.println(jsonObject.toString());
	  post(curUrl,jsonObject.toString());
  }
  
  public static void getUserWorkGroups(){
	  String curUrl=URL+"getUserWorkGroups";
	  JSONObject jsonObject=new JSONObject();
	  jsonObject.put("userCode","83510425");
	  System.out.println(jsonObject.toString());
	  post(curUrl,jsonObject.toString());
  }
  
  public static void saveAgentLocal(){
	  String curUrl=URL+"saveAgentLocal";
	  JSONObject jsonObject=new JSONObject();
	  jsonObject.put("agentCode","3501721000246");
	  jsonObject.put("longitude", 111);
	  jsonObject.put("latitude", 222);
	  System.out.println(jsonObject.toString());
	  post(curUrl,jsonObject.toString());
  }
  
  
  
  public static void queryAgentDistInfo(){
	  String curUrl=URL+"queryAgentDistInfo";
	  JSONObject param=new JSONObject();
	  param.put("userCode","83509216");
	  param.put("page",1);
	  param.put("rows",10);
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void auditDistInfo(){
	  String curUrl=URL+"auditDistInfo";
	  JSONObject param=new JSONObject();
	  param.put("id","21");
	  param.put("auditNum","21");
	  param.put("auditor","83509216"); 
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  

  
  public static void getSubDepts(){
	  String curUrl=URL+"getSubDepts";
	  JSONObject param=new JSONObject();
	  param.put("deptId","35050200");
	  post(curUrl,param.toString());
  }
  
  
  public static void queryAdminWorkGroups(){
	  String curUrl=URL+"queryAdminWorkGroups";
	  JSONObject param=new JSONObject();
//	  param.put("userCode","07009511");
	  param.put("userCode","35343557");
//	  param.put("userCode","83515191");
	  param.put("agentName", "国贸");
	  param.put("page",1);
	  param.put("rows",20);
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  public static void queryClaimsProc(){
	  String curUrl=URL+"queryClaimProc";
	  JSONObject param=new JSONObject();
	  param.put("registno","RDZA201635150000028846");
	  param.put("frameno", "LBEMDAFBXGZ911881");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void queryClaimHistory(){
	  String curUrl=URL+"queryClaimHistory";
	  JSONObject param=new JSONObject();
	  param.put("registno","RDZA201635150000028846");
	  param.put("frameno", "LBEMDAFBXGZ911881");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void queryOtherReg(){
	  String curUrl=URL+"queryOtherReg";
	  JSONObject param=new JSONObject();
	  param.put("registno","RDZA201635150000028846");
	  param.put("frameno", "LBEMDAFBXGZ911881");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  public static void queryCheckTask(){
	  String curUrl=URL+"queryCheckTask";
	  JSONObject param=new JSONObject();
	  param.put("registno","RDZA201635150000028846");
	  param.put("frameno", "LBEMDAFBXGZ911881");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void queryCompensateDis(){
	  String curUrl=URL+"queryCompensateDis";
	  JSONObject param=new JSONObject();
	  param.put("registno","RDZA201735050000009930");
	  param.put("frameno", "LSVAF4185A2351259");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  public static void queryCompensateInfo(){
	  String curUrl=URL+"queryCompensateInfo";
	  JSONObject param=new JSONObject();
	  param.put("registno","RDZA201735050000009930");
	  param.put("frameno", "LSVAF4185A2351259");
	  param.put("policyno", "PDZA201635050000088441");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  public static void queryLossInfo(){
	  String curUrl=URL+"queryLossInfo";
	  JSONObject param=new JSONObject();
	  param.put("registno","RDZA201735050000009930");
	  param.put("frameno", "LSVAF4185A2351259");
	  param.put("lossfeetype", "05");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void queryState(){
	  String curUrl=URL+"queryState";
	  JSONObject param=new JSONObject();
	  param.put("userCode","83509216");
	  param.put("agentCode", "3501002008042");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }

//  {"carNum":12,"carPre":1,"conNum":1,"conPre":1,"comNum":1,"comPre":1,"carInsInfoId":13388,"userCode":"0001","agentCode":"3508721000041"}

  public static void addCarInsInfo(){
	  String curUrl=URL+"addCarInsInfo";
	  JSONObject param=new JSONObject();
//	  param.put("type","1");
//	  param.put("vinCode", "0");
//	  param.put("carNo", "闽ARB87");
//	  param.put("totalPre", "1");
//	  param.put("userCode", "83519133");
//	  param.put("agentCode", "3501721000106");
	  param.put("comNum", "1");
	  param.put("carPre", "1");
	  param.put("conPre", "1");
	  param.put("carNum", "1");
	  param.put("userCode", "0001");
	  param.put("conNum", "1");
	  param.put("comPre", "1");
//	  param.put("carInsInfoId", "13388");
	  param.put("agentCode", "3508721000041");
	  param.put("carInsInfoId", "13387");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  public static void queryPushRepair(){
	  String curUrl=URL+"queryPushRepair";
	  JSONObject param=new JSONObject();
//	  param.put("reportId","RDZA201935060000012264");
////	  param.put("vinCode", "0");
//	  param.put("carNo", "闽OE0111");
	  param.put("carNo","闽OE0111");
	  param.put("reportId","RDZA201935060000012264");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  public static void qryCarInsInfo(){
	  String curUrl=URL+"qryCarInsInfo";
	  JSONObject param=new JSONObject();
	  param.put("createDate","2019-04-28");
	  param.put("agentCode","3508721000041");
	  param.put("userCode","0001");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static String post(String url, String param){
		String result="";
		try {
			HttpPost httpPost = new HttpPost(url);
			List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
			formParams.add(new BasicNameValuePair("content",param));
//			System.out.println("ssssssss"+new BasicNameValuePair("content",param));
//			System.out.println(new BasicNameValuePair("content",param).getClass().getName());
			HttpEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
			httpPost.setEntity(entity);
			HttpResponse response = getInstance().execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK){
				System.out.println(EntityUtils.toString(response.getEntity()));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shutdown();
		}
		return result;
	}
  
  
	private static int timeOut=30;
	
	private static String charSet;
	
	private static DefaultHttpClient instance = null;

	public static DefaultHttpClient getInstance() {
		if (instance == null) {
			BasicHttpParams localBasicHttpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(localBasicHttpParams,timeOut*1000);

			HttpConnectionParams.setSoTimeout(localBasicHttpParams, timeOut*1000);
			instance = new DefaultHttpClient(localBasicHttpParams);
			
		}
		return instance;
	}
	
	

	public static void shutdown() {
		if (instance != null) {
			instance.getConnectionManager().shutdown();
			instance = null;
		}
	}
}
