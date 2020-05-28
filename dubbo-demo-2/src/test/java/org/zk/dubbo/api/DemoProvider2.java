package org.zk.dubbo.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import org.zk.dubbo.provider.DemoServiceImpl;

public class DemoProvider2 {

	public static void main(String[] args) throws Exception {
		ServiceConfig<DemoService> service = new ServiceConfig<DemoService>();
		service.setApplication(new ApplicationConfig("demo-provider"));
		service.setRegistry(new RegistryConfig("zookeeper://localhost:2181"));
//		service.setRegistry(new RegistryConfig("redis://localhost:6379"));
		service.setInterface(DemoService.class);
		service.setRef(new DemoServiceImpl());
		service.export();
		System.in.read();
	}
}
