package org.zk.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import org.zk.dubbo.api.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
	@Override
	public String sayHi(String message) {
		return "hi," +message;
	}
}
