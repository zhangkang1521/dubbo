package org.zk.dubbo.consumer;

import org.zk.dubbo.api.DemoService;

public class DemoServiceMock implements DemoService {

	@Override
	public String sayHi(String message) {
		return "hi";
	}
}
