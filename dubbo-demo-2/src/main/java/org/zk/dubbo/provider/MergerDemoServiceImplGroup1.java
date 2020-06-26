package org.zk.dubbo.provider;

import org.zk.dubbo.api.MergerDemoService;

import java.util.Arrays;
import java.util.List;

public class MergerDemoServiceImplGroup1 implements MergerDemoService {
	@Override
	public List<String> getAllMenus() {
		return Arrays.asList("group1");
	}
}
