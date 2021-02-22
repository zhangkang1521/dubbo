package org.zk.dubbo.consumer;

import org.zk.dubbo.api.DemoService;
import org.zk.dubbo.provider.Result;

public class DemoServiceMock implements DemoService {

	@Override
	public String sayHi(String message) {
		return "hi";
	}

	@Override
	public Result testException() {
		return null;
	}
}
