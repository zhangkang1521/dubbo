package org.zk.dubbo;

public class DemoServiceImpl implements DemoService {
	@Override
	public String sayHi(String message) {
		return "hi," +message;
	}
}
