package org.zk.dubbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoConsumer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
		ctx.start();
		DemoService demoService = (DemoService) ctx.getBean("demoService");
		String str = demoService.sayHi("zhangxuan");
		System.out.println(str);
	}
}
