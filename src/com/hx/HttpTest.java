package com.hx;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
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

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

public class HttpTest {

//	 http://192.168.66.237:8080/dtam/dtam_service!
  private static  String URL="http://127.0.0.1:8080/dtam/dtam_service!";
//  private static  String URL="http://192.168.127.129:8010/dtam/dtam_service!";
//  private static  String URL="http://172.16.63.16:8084/dram/dram/dram_service!";
	
	//private static String URL="http://61.154.14.77:8083/dtam_service!";
  
  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
	 //登录
//	 savePredict();
//	 queryPunchState();
	//punchCard();
	login();
//	  savaShopInfo();
	 //savePredict();
	 //queryPunchState();
	 //addCarInsInfo();
	//queryAttendance();
	 //addInsInfo();
//	 queryCustomerInfo();
	// statsCarInsInfo();
	//  addPushRepair();
	 //addCarVipTarget();
	//addTrack();
	//queryAgency();
	// queryNotVisitAgency();
	 // getTodayInsInfo();
	//statsAgentInsInfo();
	  //addRepairFee();
	 //  statsCustomerInfo();
	 //statsDayAgentInsSum();
	 // statsCarInsInfo();
	 // statsCustomerInfo();
	 // saveAgentLocal();
	//  System.out.println(new DecimalFormat("0000000000000000000").format(16011100000108201l));
	//  queryAttendance();
//	 TestBean test=new TestBean();
//	 TestBean2 test2=new TestBean2();
//	 test.setS(11.1d);
//	 test.setI(123);
//	 test.setB(true);
//	 test.setI1(1);
//	 test.setList(new ArrayList());
//	 test.setS(1234d);
//	 queryadmin();
//	 getSubDepts();
//	 getDeptandAgency();
//	 savaShopInfo1();
//	  savaBranchesInfo();
//	  savaInsuranceInfo();
//	  getInsuranceInfo();
//	  savaRepInsuranceInfo();
//	  savaRepCarInfo();
//	  getRepCarInfo();
//	  getRepInsuranceInfo();
//	  getDeptBranchInfo();
//	 getDeptShopInfo();
//	  BeanUtils.copyProperties(test,test2);
	  
	 // System.out.println("c");
	//  addInsInfo();
//	  Integer in=new Integer(1);
//	  Boolean b=new Boolean(true);
//	  
//	  System.out.println(b);
  
  }
  
  
//  public static void push(){
//	   JPushClient client = new JPushClient("2b915fe2fcb6674d1d99865e", masterSecret);
//	   PushPayload payload= PushPayload.alertAll("测试中!!!!");  
//	   PushResult result = client.sendPush(payload);  
//  }
  
  public static void login(){
	  String curUrl=URL+"userLogin";
//	  post(curUrl,"{operNo:'11109069',userPwd:'1111',os:'ios',version:'2.11',deviceId:'1111'}");	 
	  post(curUrl,"{operNo:'11109069',userPwd:'1111',os:'android',version:'2.0',deviceId:'1111'}");	 
  }
  
  public static void queryadmin(){
	  String curUrl=URL+"queryAdminWorkGroups";
	  JSONObject param=new JSONObject();
//	  jsonObject.put("userCode", SharedPreferencesUtils.getString(this, Resources.OPERNO));
//	  jsonObject.put("agentName", info);
//	  jsonObject.put("rows", 100);
//	  jsonObject.put("page", 1);盈众  星睿
	  post(curUrl,"{userCode:'18259252',agentName:'吉诺',rows:'100',page:'1'}");
//	  ｛"userCode":'',"agentName":"","rows":'100',"page":'1'｝
	  
  }
  
  public static void saveAgentLocal(){
	  String curUrl=URL+"saveAgentLocal";
	  JSONObject param=new JSONObject();
	  param.put("agentCode","3501001764023");
	  param.put("longitude",0.0);
	  param.put("latitude",0.0);
	  post(curUrl,param.toString());
	 
  }
  
  
  
  public static void  savePredict(){
	  String curUrl=URL+"savePredict";
	  JSONObject param=new JSONObject();
	  param.put("sellNum","1");
	  param.put("insShare","1.12");
	  param.put("invoiceShare","0.33");
	  param.put("agentCode","123456");
	  param.put("userCode","admin");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void  addCarVipTarget(){
	  String curUrl=URL+"addCarVipTarget";
	  JSONObject param=new JSONObject();
	  param.put("userCode","10001");
	  param.put("agentCode","223345677");
	  param.put("insNum",2);
	  param.put("vipNum",1);
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void  addCarInsInfo(){
	  String curUrl=URL+"addCarInsInfo";
	  JSONObject param=new JSONObject();
	  param.put("userCode","10001");
	  param.put("agentCode","223345677");
	  param.put("vinCode","F112");
	  param.put("mobile","135010123434");
	  param.put("totalPre",112);
	  param.put("carNo","A1112");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  
  public static void  addTrack(){
	  String curUrl=URL+"addTrack";
	  JSONObject param=new JSONObject();
//	  param.put("userCode","10001");
//	  param.put("agentCode","102213123");
//	  param.put("longitude",111.11);
//	  param.put("latitude",111.11);
	  
	  param.put("punchId", 11);
	  JSONObject track=new JSONObject();
	  track.put("longitude", 1);
	  track.put("latitude", 123);
	  JSONObject track1=new JSONObject();
	  track1.put("longitude", 1);
	  track1.put("latitude", 123);
	  JSONArray array=new JSONArray();
	  array.add(track);
	  array.add(track1);
	  param.put("tracks", array);
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void  addPushRepair(){
	  String curUrl=URL+"addPushRepair";
	  JSONObject param=new JSONObject();
	  param.put("reportId","RDAA201735030000010801");
	  param.put("carId","闽D9001Y");
	  param.put("backFactory",0);
	  param.put("repairAmt",1);
	  param.put("agentCode","3501503711004");
	  param.put("userCode","08027486");
	 // param.put("operDate","2017-01-02");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  
  
  public static void queryPunchState(){
	  String curUrl=URL+"queryPunchState";
	  JSONObject param=new JSONObject();
	  param.put("userCode","10001");
	 // System.out.println(param.toString());
	  post(curUrl,param.toString());
  }
  
  
  public static void punchCard(){
	  String curUrl=URL+"punchCard";
	  JSONObject param=new JSONObject();
//	 param.put("userCode","admin");
//	  param.put("punchtype",2);
//	  param.put("longitudeIn",360);
//	   param.put("latitudeIn", 360);
//	  param.put("userCode","10001");
//	  param.put("punchtype",2);
//	  param.put("agentcode","3501001000028");
//	  param.put("longitudeOut",1);
//	  param.put("latitudeOut",1);
//	  param.put("longitudeIn",1);
//	  param.put("latitudeIn",1);
	String s="{userCode:\"83512958\",\"agentcode\":\"3511018000083\",\"punchtype\":1,\"longitudeIn\":119.201207,\"latitudeIn\":26.076072}";
	
	  post(curUrl,s.toString());
  }
  
  
  public static void addInsInfo(){
	  String curUrl=URL+"addInsInfo";
	  JSONObject param=new JSONObject();
	  param.put("agentCode","3505019000290");
	  param.put("userCode","07003385");
	  param.put("totalPre",1);
	  param.put("selfCompanyType",1);
	  param.put("sellWkaNum", 11);
	  param.put("sellWkaAttr","太平1");
	  param.put("comCode","22");
	  param.put("userId","admin");
	  param.put("type",1);
	  param.put("insNum",12);
	  param.put("storesInsNum",22);
	  param.put("sStoresInsNum",33);
	  param.put("insShare",33.33);
	  param.put("invoiceShare",44.44);
	  JSONArray jsonArray1=new JSONArray();
	  JSONObject AgentInsDetail1=new JSONObject();
	  
	  AgentInsDetail1.put("companyType", 1);
	  AgentInsDetail1.put("storesInsNum", 123);
	  AgentInsDetail1.put("sStoresInsNum", 1234);
	 // AgentInsDetail1.put("attr","测试1");
	  
	  JSONObject AgentInsDetail2=new JSONObject();
	  
	  AgentInsDetail2.put("companyType", 2);
	  AgentInsDetail2.put("storesInsNum",156);
	  AgentInsDetail2.put("sStoresInsNum", 1567);
	  //AgentInsDetail2.put("attr","测试2");
	  jsonArray1.add(AgentInsDetail1);
	  jsonArray1.add(AgentInsDetail2);
	  
	  
	  JSONArray jsonArray2=new JSONArray();
	  JSONObject currentDetail1=new JSONObject();
	  
	  currentDetail1.put("agentCode","3501009000058");
	  currentDetail1.put("currentNum", 1);
	  
	  JSONObject currentDetail2=new JSONObject();
	  
	  currentDetail2.put("agentCode","3501009000057");
	  currentDetail2.put("currentNum",2);
	  
	  jsonArray2.add(currentDetail1);
	  jsonArray2.add(currentDetail2);
	  param.put("insDetails",jsonArray1.toString());
	  param.put("currentDetails",jsonArray2.toString());
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
	  post(curUrl,param.toString());
  }
  
  
  
  public static void queryAttendance(){
	  String curUrl=URL+"statsAttendance";
	  JSONObject param=new JSONObject();
	  param.put("startDate","2017-08-01");
	  param.put("endDate", "2017-08-02");
	  param.put("deptId", "35010000");
	  param.put("page",1);
	  param.put("rows",211);
	  
	  //param.put("userCode","83516372");
	  //String s="{\"startDate\":\"2017-06-22\",\"endDate\":\"2017-06-22\",\"rows\":20,\"page\":1,\"deptId\":\"35019300\"}";
	  System.out.println(param.toString());
	  post(curUrl,param.toString());  
  }
  
  
  
  public static void queryCustomerInfo(){
	  String curUrl=URL+"queryCustomerInfo";
	  JSONObject param=new JSONObject();
	  param.put("startDate","2017-04-02");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());    
	  
  }
  
  public static void statsCustomerInfo(){
	  String curUrl=URL+"statsCustomerInfo";
	  JSONObject param=new JSONObject();
	  param.put("deptId","35011100");
	  param.put("groupType","2");
	  param.put("startDate","2017-07-04");
	  param.put("endDate","2017-07-04");
	  param.put("page", 1);
	 // String s=" {\"groupType\":1,\"startDate\":\"2017-05-19\",\"endDate\":\"2017-05-19\",\"page\":1,\"deptId\":\"35058300\",\"rows\":15}";
	  post(curUrl,param.toString());    
	  
  }
  
  
  public static void statsCarInsInfo(){
	  String curUrl=URL+"statsCarInsInfo";
	  JSONObject param=new JSONObject();
	 // param.put("userCode","10002");
	 // param.put("agentCode","3501009000057");
	  param.put("deptId","35000000");
	  param.put("type", "1");
	 // param.put("deptId","35058300");
	 // param.put("startDate","2017-04-21");
	  //param.put("userCode","07016079");
	 // {"deptId":"35058300","endDate":"2017-05-19","startDate":"2017-05-19","userCode":"07016079","rows":"20","type":"","page":"1"}
	  System.out.println(param.toString());
	  post(curUrl,param.toString());      
  }
  
  
  
  public static void queryAgency(){
	  String curUrl=URL+"queryAgency";
	  JSONObject param=new JSONObject();
	  param.put("orgType",1);
	  param.put("agentName","");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());      
  }
  
  
  public static void statsDayAgentInsSum(){
	  String curUrl=URL+"statsDayAgentInsSum";
	  JSONObject param=new JSONObject();
	  param.put("orgType",1);
	  param.put("deptId","35000000");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());      
  }
  
  
  public static void queryNotVisitAgency(){
	  String curUrl=URL+"queryNotVisitAgency";
	  JSONObject param=new JSONObject();
	  param.put("userCode","10001");
	  System.out.println(param.toString());
	  post(curUrl,param.toString());      
  }
  
  
  
  public static void statsAgentInsInfo(){
	  String curUrl=URL+"statsAgentInsInfo";
	  JSONObject param=new JSONObject();
	  param.put("startDate","2017-04-02");
	//  param.put("userCode","10001");
	  post(curUrl,param.toString());  
  }
  
  
  public static void getTodayInsInfo(){
	  String curUrl=URL+"getTodayInsInfo";
	  JSONObject param=new JSONObject();
	  param.put("userCode","10001");
	  param.put("agentCode","3501009000058");
	  post(curUrl,param.toString());
  }
  
  public static void getSubDepts(){
	  String curUrl=URL+"getSubDepts";
	  JSONObject param=new JSONObject();
	  param.put("deptId","35060010");
//	  param.put("agentCode","3501009000058");
	  post(curUrl,param.toString());
  }
  
  public static void getDeptandAgency(){
	  String curUrl=URL+"getDeptandAgency";
	  JSONObject param=new JSONObject();
	  param.put("orgType","1");
	  param.put("deptId","62010040");
	  post(curUrl,param.toString());
  }
  
  public static void savaShopInfo(){
	  String curUrl=URL+"savaShopInfo";
	  JSONObject param=new JSONObject();
	  param.put("userCode","A520100678");
	  param.put("agentCode","5201001722024");
	  param.put("fee","15");
	  param.put("recordDate","2019-6-20");
	  param.put("totalInsured","2");
	  param.put("comCode","52010900");
	  param.put("userCode","62010040");
	  param.put("shopInsured","1"); 
	  param.put("comCar","1"); 
	  param.put("comBusinessCar","1"); 
	  param.put("allInsured","1"); 
	  param.put("insuranceShare","1"); 
	  param.put("carFee","1"); 
	  param.put("businessFee","0.11"); 
	  param.put("totalInsureFee","1"); 
	  param.put("toBranches","1"); 
	  param.put("peaceNum","1"); 
	  param.put("peaceShare","1"); 
	  param.put("peaceFee","0.11"); 
	  param.put("taipingNum","1"); 
	  param.put("taipingShare","1"); 
	  param.put("taipingFee","1"); 
	  
	  param.put("comInsuredxb","1");//店内总承保
	param.put("comCarxb","1");//我司承保（家非车）
	param.put("comBusinessCarxb","1");//我司承保（营业车辆）
	param.put("allInsuredxb","1");//我司总承保续保
	param.put("carFeexb","1");//续保保费（家非车）
	param.put("businessFeexb","0.11");//续保保费（营业车辆）
	param.put("feexb","0.11");//续保总保费
	param.put("peaceNumxb","1");//平安台数
	param.put("peaceFeexb","0.11");//平安续保保费
	param.put("taipingNumxb","0.11");//太平洋台数
	param.put("taipingFeexb","0.11");//太平洋续保保费
		
	param.put("comInsuredzb","1");//店内总承保
	param.put("comCarzb","1");//我司承保（家非车）
	param.put("comBusinessCarzb","1");//我司承保（营业车辆）
	param.put("allInsuredzb","1");//我司总承保续保
	param.put("carFeezb","0.11");//续保保费（家非车）
	param.put("businessFeezb","0.11");//续保保费（营业车辆）
	param.put("feezb","0.11");//续保总保费
	param.put("peaceNumzb","1");//平安台数
	param.put("peaceFeezb","0.11");//平安续保保费
	param.put("taipingNumzb","1");//太平洋台数
	param.put("taipingFeezb","0.11");//太平洋续保保费
		
	param.put("myRepMesgCar","1");//我司送修短信推送车辆
	param.put("carSuessShop","1");//成功到店车辆
	param.put("carOwnShop","1");//自行到店车辆
	param.put("repSuessRate","0.11");//送修达成率
	param.put("myRepRate","0.11");//我司送修比
	param.put("pinganRepMesgCar","1");//平安送修短信推送车辆
	param.put("pingancarSuessShop","1");//平安成功到店车辆（含自行到店）
	param.put("pinganRepRate","0.11");//平安送修比
	param.put("taipingRepMesgCar","1");//太平洋送修短信推送车辆
	param.put("taipingcarSuessShop","1");//成功到店车辆（含自行到店）
	param.put("taipingRepRate","0.11");//太平洋送修比	
	  post(curUrl,param.toString());
  }
  
  public static void savaShopInfo1(){
	  String curUrl=URL+"savaGarageInfo";
	  JSONObject param=new JSONObject();  
	  param.put("userCode","07002996");
	  param.put("agentCode","5201503031004");
	  param.put("membership","0");
	  param.put("recordDate","2019-6-23");
	  param.put("totalInsured","9");
	  param.put("comCode","");
	  param.put("userCode","62010040");
	  param.put("shopInsured","1"); 
	  param.put("comCar","1"); 
	  param.put("comBusinessCar","1"); 
	  param.put("allInsured","1"); 
	  param.put("insuranceShare","1"); 
	  param.put("carFee","1"); 
	  param.put("businessFee","1"); 
	  param.put("totalInsureFee","1"); 
	  param.put("toBranches","1"); 
	  param.put("peaceNum","1"); 
	  param.put("peaceShare","1"); 
	  param.put("peaceFee","1"); 
	  param.put("taipingNum","1"); 
	  param.put("taipingShare","1"); 
	  param.put("taipingFee","1"); 
	  
	param.put("comInsuredxb","1");//店内总承保
	param.put("comCarxb","1");//我司承保（家非车）
	param.put("comBusinessCarxb","1");//我司承保（营业车辆）
	param.put("allInsuredxb","1");//我司总承保续保
	param.put("carFeexb","1");//续保保费（家非车）
	param.put("businessFeexb","1");//续保保费（营业车辆）
	param.put("feexb","1");//续保总保费
	param.put("peaceNumxb","1");//平安台数
	param.put("peaceFeexb","1");//平安续保保费
	param.put("taipingNumxb","1");//太平洋台数
	param.put("taipingFeexb","1");//太平洋续保保费
		
	param.put("comInsuredzb","1");//店内总承保
	param.put("comCarzb","1");//我司承保（家非车）
	param.put("comBusinessCarzb","1");//我司承保（营业车辆）
	param.put("allInsuredzb","1");//我司总承保续保
	param.put("carFeezb","1");//续保保费（家非车）
	param.put("businessFeezb","1");//续保保费（营业车辆）
	param.put("feezb","1");//续保总保费
	param.put("peaceNumzb","1");//平安台数
	param.put("peaceFeezb","1");//平安续保保费
	param.put("taipingNumzb","1");//太平洋台数
	param.put("taipingFeezb","1");//太平洋续保保费
		
	param.put("myRepMesgCar","1");//我司送修短信推送车辆
	param.put("carSuessShop","1");//成功到店车辆
	param.put("carOwnShop","1");//自行到店车辆
	param.put("repSuessRate","1");//送修达成率
	param.put("myRepRate","1");//我司送修比
	param.put("pinganRepMesgCar","1");//平安送修短信推送车辆
	param.put("pingancarSuessShop","1");//平安成功到店车辆（含自行到店）
	param.put("pinganRepRate","1");//平安送修比
	param.put("taipingRepMesgCar","1");//太平洋送修短信推送车辆
	param.put("taipingcarSuessShop","1");//成功到店车辆（含自行到店）
	param.put("taipingRepRate","1");//太平洋送修比	
	post(curUrl,param.toString());
  }
  
  public static void getDeptBranchInfo(){
	  String curUrl=URL+"getDeptBranchInfo";
	  JSONObject param=new JSONObject();
	  param.put("orgType","1");
	  param.put("deptId","52010900");
	  param.put("agentCode","");
	  param.put("recordDate","2019-07-08");
	  post(curUrl,param.toString());
  }
  
  public static void getDeptShopInfo(){
	  String curUrl=URL+"getDeptShopInfo";
	  JSONObject param=new JSONObject();
	  param.put("orgType","1");
	  param.put("deptId","52010900");
	  param.put("agentCode","");
	  param.put("recordDate","2019-06-20");
	  post(curUrl,param.toString());
  }
  
  public static void savaBranchesInfo(){
	  String curUrl=URL+"savaBranchesInfo";
	  JSONObject param=new JSONObject();
	  param.put("userCode","A520100678");
	  param.put("agentCode","5201001722024");
	  param.put("fee","10");
	  param.put("recordDate","2019-6-19");
	  param.put("totalInsured","2");
	  param.put("comInsured","2");
	  param.put("comCode","52010900");
//	  param.put("userCode","62010040");
	  param.put("ticket","5");
	  param.put("shopInsured","1");
	  param.put("comCar","1");
	  param.put("comBusinessCar","1");
	  param.put("carFee","1");
	  param.put("businessFee","1");
//	  param.put("toBranches","1");
	  param.put("stealInsured","1");
	  param.put("millionInsured","1");
	  param.put("sales","2");
	  param.put("membership","1");
	  param.put("peaceNum","1");
	  param.put("taipingNum","1");
	  param.put("peaceFee","2");
	  param.put("taipingFee","8");
	  post(curUrl,param.toString());
  }
  
  
  public static void savaInsuranceInfo(){
	  String curUrl=URL+"savaInsuranceInfo";
	  JSONObject param=new JSONObject();
//		private String orgType; //机构类型
//		private String deptId; //机构编码
//		private String agentCode;//车行机构
//		private Date recordDate;//日期
//		private String userCode;//用户编码
//		private String deptName;//机构名称
//
//		//今日
//		private String comInsured; //本日店内总承保                     	
//		private String comCar; //本日我司承保（家非车）        
//	 	private String comBusinessCar;//本日我司承保（营业车辆）   
//	 	private String allInsured;//本日我司总承保续保       
//		private String carFee;//	本日续保保费（家非车）
//	 	private String businessFee;//	本日续保保费（营业车辆）
//	 	private String fee;//	本日续保总保费
//	    private String peaceNum;//本日平安台数 	
//		private String peaceFee;//本日平安续保保费
//		private String taipingNum;//本日太平洋台数   
//		private String taipingFee;//本日太平洋续保保费
	  param.put("deptId","52010900");
	  param.put("userCode","A520100678");
	  param.put("agentCode","5201001722024");
	  param.put("comInsured","10");
	  param.put("recordDate","2019-6-19");
	  param.put("comCar","2");
	  param.put("comBusinessCar","2");
	  param.put("allInsured","9");
	  param.put("carFee","5");
	  param.put("businessFee","1");
	  param.put("fee","1");
	  param.put("peaceNum","1");
	  param.put("peaceFee","1");
	  param.put("taipingNum","1");
	  param.put("taipingFee","1");	  
	  param.put("comInsured","1");
	  
	  param.put("comInsuredxb","1");//店内总承保
	param.put("comCarxb","1");//我司承保（家非车）
	param.put("comBusinessCarxb","1");//我司承保（营业车辆）
	param.put("allInsuredxb","1");//我司总承保续保
	param.put("carFeexb","1");//续保保费（家非车）
	param.put("businessFeexb","1");//续保保费（营业车辆）
	param.put("feexb","1");//续保总保费
	param.put("peaceNumxb","1");//平安台数
	param.put("peaceFeexb","1");//平安续保保费
	param.put("taipingNumxb","1");//太平洋台数
	param.put("taipingFeexb","1");//太平洋续保保费
		
	param.put("comInsuredzb","1");//店内总承保
	param.put("comCarzb","1");//我司承保（家非车）
	param.put("comBusinessCarzb","1");//我司承保（营业车辆）
	param.put("allInsuredzb","1");//我司总承保续保
	param.put("carFeezb","1");//续保保费（家非车）
	param.put("businessFeezb","1");//续保保费（营业车辆）
	param.put("feezb","1");//续保总保费
	param.put("peaceNumzb","1");//平安台数
	param.put("peaceFeezb","1");//平安续保保费
	param.put("taipingNumzb","1");//太平洋台数
	param.put("taipingFeezb","1");//太平洋续保保费
		
	param.put("myRepMesgCar","1");//我司送修短信推送车辆
	param.put("carSuessShop","1");//成功到店车辆
	param.put("carOwnShopv","1");//自行到店车辆
	param.put("repSuessRate","1");//送修达成率
	param.put("myRepRate","1");//我司送修比
	param.put("pinganRepMesgCar","1");//平安送修短信推送车辆
	param.put("pingancarSuessShop","1");//平安成功到店车辆（含自行到店）
	param.put("pinganRepRate","1");//平安送修比
	param.put("taipingRepMesgCar","1");//太平洋送修短信推送车辆
	param.put("taipingcarSuessShop","1");//成功到店车辆（含自行到店）
	param.put("taipingRepRate","1");//太平洋送修比		
	  post(curUrl,param.toString());
  }
  
  
  public static void getInsuranceInfo(){
	  String curUrl=URL+"getInsuranceInfo";
	  JSONObject param=new JSONObject();
	  param.put("orgType","1");
	  param.put("deptId","52010900");
	  param.put("agentCode","5201001722024");
	  param.put("recordDate","2019-06-19");
	  post(curUrl,param.toString());
  }
  
  public static void savaRepInsuranceInfo(){
	  String curUrl=URL+"savaRepInsuranceInfo";
	  JSONObject param=new JSONObject();
	  
	  param.put("deptId","52010900");
	  param.put("userCode","A520100678");
	  param.put("agentCode","5201001722024");
	  param.put("comInsured","10");
	  param.put("recordDate","2019-6-19");
	  param.put("comCar","2");
	  param.put("comBusinessCar","2");
	  param.put("allRepInsured","9");
	  param.put("carFee","5");
	  param.put("businessFee","1");
	  param.put("fee","1");
	  param.put("peaceNum","1");
	  param.put("peaceFee","1");
	  param.put("taipingNum","1");
	  param.put("taipingFee","1");
	  post(curUrl,param.toString());
  }
  
  public static void getRepInsuranceInfo(){
	  String curUrl=URL+"getRepInsuranceInfo";
	  JSONObject param=new JSONObject();
	  param.put("orgType","1");
	  param.put("deptId","52010900");
	  param.put("agentCode","5201001722024");
	  param.put("recordDate","2019-06-19");
	  post(curUrl,param.toString());
  }

  
  public static void savaRepCarInfo(){
	  String curUrl=URL+"savaRepCarInfo";
	  JSONObject param=new JSONObject();
	  
	  param.put("deptId","52010900");
	  param.put("userCode","A520100678");
	  param.put("agentCode","5201001722024");
//	  param.put("comInsured","10");
	  param.put("recordDate","2019-6-19");
	  param.put("myRepMesgCar","1");
	  param.put("carSuessShop","1");
	  param.put("carOwnShop","1");
	  param.put("repSuessRate","1");
	  param.put("myRepRate","1");
	  param.put("mmyRepRate","66");
	  param.put("pinganRepMesgCar","1");
	  param.put("pingancarSuessShop","1");
	  param.put("pinganRepRate","1");
	  param.put("mpinganRepRate","66");
	  param.put("taipingRepMesgCar","1");
	  param.put("taipingcarSuessShop","1");
	  param.put("taipingRepRate","1");
	  param.put("mtaipingRepRate","66");

	  post(curUrl,param.toString());
  }
  
  
  public static void getRepCarInfo(){
	  String curUrl=URL+"getRepCarInfo";
	  JSONObject param=new JSONObject();
	  param.put("orgType","1");
	  param.put("deptId","52010900");
	  param.put("agentCode","5201001722024");
//	  param.put("agentCode","");
	  param.put("recordDate","2019-06-19");
	  post(curUrl,param.toString());
  }
  
  
  public static String post(String url, String param){
		String result="";
		try {
			HttpPost httpPost = new HttpPost(url);
			List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
			formParams.add(new BasicNameValuePair("content",param));
			System.out.println("formParams的值为"+formParams);
			HttpEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
			System.out.println("entity的值为"+entity);
			httpPost.setEntity(entity);
			System.out.println("httpPost的值为"+httpPost);
			HttpResponse response = getInstance().execute(httpPost);
			System.out.println("response的值为"+response);
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("statusCode的值为"+statusCode);
			if (statusCode == HttpStatus.SC_OK){
				//System.out.println(EntityUtils.toString(response.getEntity()));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shutdown();
		}
		System.out.println("result的值为"+result);
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
