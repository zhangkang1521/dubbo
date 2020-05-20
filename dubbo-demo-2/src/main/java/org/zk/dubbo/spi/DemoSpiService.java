package org.zk.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("first") // 指定默认的Extension
public interface DemoSpiService {

	@Adaptive("key")
	void sayHi(URL url);

}
