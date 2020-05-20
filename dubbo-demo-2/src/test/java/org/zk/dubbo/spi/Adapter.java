package org.zk.dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

// 自动生成的类
public class Adapter implements org.zk.dubbo.spi.DemoSpiService {
	public void sayHi(com.alibaba.dubbo.common.URL arg0) {
		if (arg0 == null) throw new IllegalArgumentException("url == null");
		com.alibaba.dubbo.common.URL url = arg0;
		String extName = url.getParameter("key", "first");
		if (extName == null)
			throw new IllegalStateException("Fail to get extension(org.zk.dubbo.spi.DemoSpiService) name from url(" + url.toString() + ") use keys([key])");
		org.zk.dubbo.spi.DemoSpiService extension = (org.zk.dubbo.spi.DemoSpiService) ExtensionLoader.getExtensionLoader(org.zk.dubbo.spi.DemoSpiService.class).getExtension(extName);
		extension.sayHi(arg0);
	}
}
