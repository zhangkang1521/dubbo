package org.zk.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;

@Activate(group = {"group_2"}, value = {"second_value"})
public class SecondDemoSpiServiceImpl implements DemoSpiService {

	static {
		System.out.println("second static");
	}

	@Override
	public void sayHi(URL url) {
		System.out.println("I am second spi impl");
	}
}
