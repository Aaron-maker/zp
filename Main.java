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
		System.out.println("#########################初始化中#########################");
		UCPClinetFactory factory = new UCPClinetFactory();
		UCPClient client = factory.getUCPClient();
		try {
			String sessionId = client.login("sjgxptdx", "111111b");
			client.checkSession(sessionId);
			//检查会话是否超期
			System.out.println(client.checkSession(sessionId));
			System.out.println(sessionId);
			//发送短信
			String taskId=client.sendSMS(sessionId,"1","13157131627",new Date(),"短信测试哈哈",null,false);
			//获取接收短信
			client.receiveSMS(sessionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
