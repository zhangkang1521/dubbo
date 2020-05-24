package org.zk.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import org.zk.dubbo.api.DemoService;

import java.util.Date;

@Service
public class DemoServiceImpl implements DemoService {
	@Override
	public String sayHi(String message) {
		System.out.println("invoke " + new Date());
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return "hi," +message;
	}
}
