package org.zk.dubbo.consumer;

import org.zk.dubbo.api.DemoService;
import org.zk.dubbo.provider.Result;

/**
 * 本地存根
 */
public class DemoServiceStub implements DemoService {

	private DemoService demoService;

	public DemoServiceStub(DemoService demoService) {
		this.demoService = demoService;
	}


	@Override
	public String sayHi(String message) {
		try {
			return demoService.sayHi(message);
		} catch (Exception e) {
			return "error";
		}
	}

	@Override
	public Result testException() {
		return null;
	}
}
