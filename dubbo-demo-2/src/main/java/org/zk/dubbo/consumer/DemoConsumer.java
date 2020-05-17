package org.zk.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.zk.dubbo.api.DemoService;

@Component
public class DemoConsumer {

	@Reference
	private DemoService demoService;

	public void hi() {
		String str = demoService.sayHi("ss");
		System.out.println(str);
	}
}
