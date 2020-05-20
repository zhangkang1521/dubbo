package org.zk.dubbo.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.zk.dubbo.api.DemoService;

public class DemoConsumer2 {

	public static void main(String[] args) {
		ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>();
		reference.setApplication(new ApplicationConfig("demo-consumer"));
//		reference.setRegistry(new RegistryConfig("zookeeper://localhost:2181"));
		reference.setRegistry(new RegistryConfig("redis://localhost:6379"));
		reference.setInterface(DemoService.class);
		DemoService demoService = reference.get();
		String str = demoService.sayHi("zhangxuan");
		System.out.println(str);
	}
}
