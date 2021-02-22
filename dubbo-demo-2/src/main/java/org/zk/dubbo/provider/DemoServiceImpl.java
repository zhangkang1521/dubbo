package org.zk.dubbo.provider;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import org.zk.dubbo.api.DemoService;
import org.zk.dubbo.api.User;
import org.zk.dubbo.api.UserService;

import java.util.Date;

@Service
public class DemoServiceImpl implements DemoService {

	private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

//	private UserService userService;

	@Override
	public String sayHi(String message) {
		RpcContext rpcContext = RpcContext.getContext();
		System.out.println(rpcContext.getAttachment("application"));
		logger.info("调用服务,参数" + message);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		logger.info("开始调用getUser");
//		User user = userService.getUser(1);
//		logger.info("调用getUser结束" + user.getId());
		throw new RuntimeException("xx");
//		return "hi,local," + message;
	}

	@Override
	public Result testException() {
		throw new RuntimeException("xx");
	}

//	public UserService getUserService() {
//		return userService;
//	}
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
}
