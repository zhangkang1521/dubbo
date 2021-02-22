package org.zk.dubbo.api;

import org.zk.dubbo.provider.Result;

public interface DemoService {
	String sayHi(String message);

	Result testException();

	//String testCallback(String key, final CallbackListener listener);
}
