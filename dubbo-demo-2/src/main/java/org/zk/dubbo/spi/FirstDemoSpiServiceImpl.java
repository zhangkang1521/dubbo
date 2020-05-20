package org.zk.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.extension.Adaptive;

//@Adaptive
@Activate(group = {"group_1"})
public class FirstDemoSpiServiceImpl implements DemoSpiService {

	static {
		System.out.println("first static");
	}

	private Ext ext;

	public void setExt(Ext ext) {
		this.ext = ext;
	}

	@Override
	public void sayHi(URL url) {
		System.out.println("I am first spi impl ");
	}
}
