package org.zk.dubbo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoProvider {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
		context.start();
		System.in.read();
	}
}
