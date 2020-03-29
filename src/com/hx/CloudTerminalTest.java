package com.hx;
import java.net.*;
import java.io.*;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class CloudTerminalTest
{
	
	public static void main(String[] args) throws Exception
	{
		String inStr = "{\"manu_facturer\":\"start\",\"model_name\":\"ST6110\",\"serial_number\":\"000B00FF25EA\",\"ip_address\":\"172.16.63.28\""
					+  ",\"mac_address\":\"00:0B:00:FF:25:EA\",\"hardware_version\":\"v1.0.1\",\"software_version\":\"v1.0.1\",\"patch_version\":\"v1.0.1\"}";
//		{"hardware_version":"v1.0.1","ip_address":"172.16.63.28","mac_address":"00:0B:00:FF:25:EA","manu_facturer":"start","model_name":"ST6110","patch_version":"v1.0.1","serial_number":"11708036871","software_version":"v1.0.1"}
		PostMethod post = new PostMethod("http://120.36.56.148:9091/iptv/CloudTerminal"); 
		post.setRequestBody(CryptTool4CT.encode(inStr));

		try
		{
			HttpClient httpClient = new HttpClient();
			httpClient.setTimeout(5000);
	
			int status = httpClient.executeMethod(post);
			String res = post.getResponseBodyAsString();

			if(status == 200)
				System.out.println(CryptTool4CT.decode(res.trim()));
			else
				System.out.println(status);
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if (post != null) post.releaseConnection();
		}
		
	}
}