package org.zk.dubbo.provider;

import org.zk.dubbo.api.User;
import org.zk.dubbo.api.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(Integer id) {
		User user = new User();
		user.setId(id);
		return user;
	}
}
