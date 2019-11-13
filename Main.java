package com.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Element;

import java.util.Date;

@Controller
@RequestMapping(value = "${adminPath}/sms")
public class Main {

	@RequestMapping(value = "send")
	public void test() {
		System.out.println("#########################��ʼ����#########################");
		UCPClinetFactory factory = new UCPClinetFactory();
		UCPClient client = factory.getUCPClient();
		try {
			String sessionId = client.login("sjgxptdx", "111111b");
			client.checkSession(sessionId);
			//���Ự�Ƿ���
			System.out.println(client.checkSession(sessionId));
			System.out.println(sessionId);
			//���Ͷ���
			String taskId=client.sendSMS(sessionId,"1","13157131627",new Date(),"���Ų��Թ���",null,false);
			//��ȡ���ն���
			client.receiveSMS(sessionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
