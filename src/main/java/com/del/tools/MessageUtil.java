package com.del.tools;

import org.springframework.web.context.support.XmlWebApplicationContext;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class MessageUtil {

	public String getJSON(){
	//���ó�ʱʱ��-�����е���
	System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
	System.setProperty("sun.net.client.defaultReadTimeout", "10000");
	//��ʼ��ascClient��Ҫ�ļ�������
	final String product = "Dysmsapi";//����API��Ʒ���ƣ����Ų�Ʒ���̶��������޸ģ�
	final String domain = "dysmsapi.aliyuncs.com";//����API��Ʒ�������ӿڵ�ַ�̶��������޸ģ�
	//�滻�����AK
	final String accessKeyId = "LTAIaWqIFXcQVY6e";//���accessKeyId,�ο����ĵ�����2
	final String accessKeySecret = "sgEBY0QgYUPi6BeYBaA86Lg9rFTqZZ";//���accessKeySecret���ο����ĵ�����2
	//��ʼ��ascClient,��ʱ��֧�ֶ�region
	IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
	accessKeySecret);
	try {
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
	} catch (ClientException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	IAcsClient acsClient = new DefaultAcsClient(profile);
	 //��װ�������
	 SendSmsRequest request = new SendSmsRequest();
	 //ʹ��post�ύ
	 request.setMethod(MethodType.POST);
	 //����:�������ֻ��š�֧���Զ��ŷָ�����ʽ�����������ã���������Ϊ1000���ֻ�����,������������ڵ������ü�ʱ�������ӳ�,��֤�����͵Ķ����Ƽ�ʹ�õ������õķ�ʽ
	 request.setPhoneNumbers("18938034940");
	 //����:����ǩ��-���ڶ��ſ���̨���ҵ�
	 request.setSignName("����");
	 //����:����ģ��-���ڶ��ſ���̨���ҵ�
	 request.setTemplateCode("SMS_1000000");
	 //��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ
	 //������ʾ:���JSON����Ҫ�����з�,����ձ�׼��JSONЭ��Ի��з���Ҫ��,������������а���\r\n�������JSON����Ҫ��ʾ��\\r\\n,����ᵼ��JSON�ڷ���˽���ʧ��
	 request.setTemplateParam("{\"name\":\"�û�\", \"code\":\"123456\"}");
	 //��ѡ-���ж�����չ��(�����������û�����Դ��ֶ�)
	 //request.setSmsUpExtendCode("90997");
	 //��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
	 //request.setOutId("yourOutId");
	//����ʧ���������ClientException�쳣
	SendSmsResponse sendSmsResponse=null;
	try {
		sendSmsResponse = acsClient.getAcsResponse(request);
	} catch (ServerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClientException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
	//����ɹ�
		
		return "ok";
	
	}else{
		int[] a = {1,3,9,4,5};
		for (int i = 0;  i< a.length-1; i++) {
			for (int j = i; j < a.length-1-i; j++) {
				if (a[j]>a[j+1]) {
					int tt  = a[j];
					a[j]  = a[j+1];
					a[j+1]  = tt;					
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+",");
		}
		
		 
		
		return "error";
	}
	
	
	
	}
	
	
	
	public static void main(String[] args) {
		MessageUtil su = new MessageUtil();
		System.out.println(su.getJSON());
		
	}
	
}
