package org.zk.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DubboSpiTest {

	@Test
	public void testExtension() {
		ExtensionLoader<DemoSpiService> extensionLoader = ExtensionLoader.getExtensionLoader(DemoSpiService.class);
		DemoSpiService demoSpiService = extensionLoader.getExtension("first");
		demoSpiService.sayHi(null);
	}



	@Test
	public void testAdaptive() {
		// 会编译产生一个新类
		DemoSpiService demoSpiService = ExtensionLoader.getExtensionLoader(DemoSpiService.class).getAdaptiveExtension();
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("key", "second");
		URL url = new URL("xxx", "localhost", 8000, parameters);
		System.out.println(url.getMethodParameter("a", "1"));
		demoSpiService.sayHi(url);
	}

	@Test
	public void testActive() {
		ExtensionLoader<DemoSpiService> extensionLoader = ExtensionLoader.getExtensionLoader(DemoSpiService.class);
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("second_value", "xx");
		URL url = new URL("xxx", "localhost", 8000, parameters);
		List<DemoSpiService> demoSpiService = extensionLoader.getActivateExtension(url, new String[]{}, "group_2");
	}
}
