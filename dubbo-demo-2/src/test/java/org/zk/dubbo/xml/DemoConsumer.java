package org.zk.dubbo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.dubbo.api.Demo2Service;
import org.zk.dubbo.api.DemoService;
import org.zk.dubbo.api.MergerDemoService;
import org.zk.dubbo.api.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DemoConsumer {

	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
		ctx.start();
		// ReferenceBean 已经注册
		DemoService demoService = (DemoService) ctx.getBean("demoService");
		for (int i = 0; i < 10; i++) {
			// InvokerInvocationHandler
			String result = demoService.sayHi("ss");
			System.out.println(new Date() + " => " + result);
			Thread.sleep(1000);
		}
//		MergerDemoService mergerDemoService = (MergerDemoService)ctx.getBean("mergerDemoService");
//		List list = mergerDemoService.getAllMenus();
//		System.out.println(list);
	}


}
