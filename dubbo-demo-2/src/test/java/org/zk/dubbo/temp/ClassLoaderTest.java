package org.zk.dubbo.temp;

import org.junit.Test;

import java.lang.reflect.Method;

public class ClassLoaderTest {

	@Test
	public void test1() throws Exception {
//		Class clazz = Class.forName("Person");
		ClassLoaderA classLoaderA = new ClassLoaderA();
		ClassLoaderB classLoaderB = new ClassLoaderB();
		Class<?> a = Class.forName("A", true, classLoaderA);
		Class<?> b = Class.forName("B", true, classLoaderB);

		System.out.println(a.getClassLoader());
		System.out.println(b.getClassLoader());

		Object obj = a.newInstance();
		Method method = a.getMethod("callB");
		method.invoke(obj);

	}
}
