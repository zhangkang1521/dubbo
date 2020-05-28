package org.zk.dubbo.spi;

import com.alibaba.dubbo.common.URL;

/**
 * 自动包装
 */
public class DemoWrapper implements DemoSpiService {

	private DemoSpiService demoSpiService;

	public DemoWrapper(DemoSpiService demoSpiService) {
		this.demoSpiService = demoSpiService;
	}

	@Override
	public void sayHi(URL url) {
		System.out.println("包装类执行");
		this.demoSpiService.sayHi(url);
	}
}
