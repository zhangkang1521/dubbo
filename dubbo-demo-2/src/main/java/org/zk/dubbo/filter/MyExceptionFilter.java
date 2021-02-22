/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.zk.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.filter.tps.DefaultTPSLimiter;
import com.alibaba.dubbo.rpc.filter.tps.TPSLimiter;


@Activate(group = Constants.PROVIDER, value = "myExceptionFilter")
public class MyExceptionFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("=== exception ===");
	    Result result = invoker.invoke(invocation);
		if (result.hasException()) {
			org.zk.dubbo.provider.Result myResult = new org.zk.dubbo.provider.Result();
			myResult.setSuccess(false);
			return new RpcResult("ss");
		}
	    return result;
    }

}
