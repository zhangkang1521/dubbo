package org.zk.dubbo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoProviderC {
	public static void main(String[] args) throws Throwable {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider-c.xml");
		context.start();
		System.in.read();
	}
}
