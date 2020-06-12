package org.zk.dubbo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.dubbo.api.DemoService;

import java.io.Serializable;

public class DemoConsumer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
		ctx.start();
		// ReferenceBean 已经注册
		DemoService demoService = (DemoService) ctx.getBean("demoService");
		//for (int i = 0; i < 5; i++) {
			// InvokerInvocationHandler
		//RpcContext.getContext().setAttachment("index", "1");
			String str = demoService.sayHi("zhangxuan");
			System.out.println(str);
		//}
	}


}
