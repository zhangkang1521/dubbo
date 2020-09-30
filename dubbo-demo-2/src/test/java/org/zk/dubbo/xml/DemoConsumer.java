package org.zk.dubbo.xml;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.dubbo.api.Demo2Service;
import org.zk.dubbo.api.DemoService;
import org.zk.dubbo.api.MergerDemoService;
import org.zk.dubbo.api.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

public class DemoConsumer {

	private static Logger logger = LoggerFactory.getLogger(DemoConsumer.class);

	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
		ctx.start();
		// ReferenceBean 已经注册
//		for (int i = 0; i < 3; i++) {
			final DemoService demoService = (DemoService) ctx.getBean("demoService");
			// InvokerInvocationHandler
			logger.info("开始调用sayHi");
			Object result = demoService.sayHi("ss");
			logger.info("拿到结果" + result);
//		}
//		MergerDemoService mergerDemoService = (MergerDemoService)ctx.getBean("mergerDemoService");
//		List list = mergerDemoService.getAllMenus();
//		System.out.println(list);
	}


}
