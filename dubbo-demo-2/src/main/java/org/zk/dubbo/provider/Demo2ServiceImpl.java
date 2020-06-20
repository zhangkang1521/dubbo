package org.zk.dubbo.provider;

import org.zk.dubbo.api.Demo2Service;
import org.zk.dubbo.api.User;

public class Demo2ServiceImpl implements Demo2Service {
	@Override
	public void saveUser(User user) {
		System.out.println(user);
	}
}
