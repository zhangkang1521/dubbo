package org.zk.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("ext1")
public interface Ext {

	@Adaptive("s")
	void echo(URL url);
}
