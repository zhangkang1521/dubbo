package org.zk.dubbo.temp;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

public class ReturnTypeTest<T> {

	public String f1() {
		return "";
	}

	public  T f2() {
		return null;
	}

	public List<T> f3() {
		return null;
	}

	@Test
	public void test1() throws Exception{
		Method method = ReturnTypeTest.class.getMethod("f1");
		System.out.println(method.getReturnType());
		System.out.println(method.getGenericReturnType());
	}

	@Test
	public void test2() throws Exception{
		Method method = ReturnTypeTest.class.getMethod("f2");
		System.out.println(method.getReturnType());
		System.out.println(method.getGenericReturnType());
	}

	@Test
	public void test3() throws Exception{
		Method method = ReturnTypeTest.class.getMethod("f3");
		System.out.println(method.getReturnType());
		System.out.println(method.getGenericReturnType());
	}
}
