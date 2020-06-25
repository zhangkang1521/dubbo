package org.zk.dubbo.xml;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcContext;
import org.junit.Before;
import org.junit.Test;

import javax.script.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Router {

	Registry registry;

	@Before
	public void initRegistry() {
		RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
		 registry = registryFactory.getRegistry(URL.valueOf("zookeeper://localhost:2181"));
	}

	@Test
	public void addConditionRoute() {
		// 添加条件路由
		// runtime:是否在每次调用时执行路由规则，默认false
		// router=condition 条件路由
		registry.register(URL.valueOf("route://0.0.0.0/org.zk.dubbo.api.DemoService?runtime=true&category=routers&dynamic=false&enabled=true&force=false&name=router-1&priority=0&router=condition&rule="
				+ URL.encode("host = 10.43.2.101 => host = 192.168.127.130")));
	}

	@Test
	public void addScriptRoute() {
		// 添加脚本路由
		// runtime:是否在每次调用时执行路由规则，默认false
		// router=script 条件路由
		registry.register(URL.valueOf("route://0.0.0.0/org.zk.dubbo.api.DemoService?runtime=true&category=routers&dynamic=false&enabled=true&force=false&name=router-1&priority=0&router=script&rule="
				+ URL.encode("(function route(invokers) {\n" +
				"\tvar result = new java.util.ArrayList(invokers.size());\n" +
				"\tfor (var i = 0; i < invokers.size(); i++) {\n" +
				"\t\tif (\"192.168.3.2\".equals(invokers.get(i).getUrl().getHost())) {\n" +
				"\t\t\tresult.add(invokers.get(i));\n" +
				"\t\t}\n" +
				"\t}\n" +
				"\treturn result;\n" +
				"} (invokers));")));

	}

	@Test
	public void testJavascript() throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		Compilable compilable = (Compilable) engine;
		Bindings bindings = engine.createBindings();
		bindings.put("str", "aa");
		bindings.put("b", "bb");
		CompiledScript function = compilable.compile("(function route(str, b) {\n" +
					" return '123' + str + b" +
				"} (str, b))");
		Object obj = function.eval(bindings);
		System.out.println(obj);
	}

	@Test
	public void test2() {
		Pattern ROUTE_PATTERN = Pattern.compile("([&!=,]*)\\s*([^&!=,\\s]+)");
		Matcher matcher = ROUTE_PATTERN.matcher("host != 192.168.1.1");
		while (matcher.find()) {
			System.out.println("分隔符:" + matcher.group(1));
			System.out.println("数据:" + matcher.group(2));
		}
	}
}
