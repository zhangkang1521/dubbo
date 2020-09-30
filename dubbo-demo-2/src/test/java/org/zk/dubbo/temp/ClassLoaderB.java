package org.zk.dubbo.temp;

import com.google.common.io.Files;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class ClassLoaderB extends ClassLoader {

	private ByteArrayOutputStream baos;

	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] bytes = Files.toByteArray(new File("E:/B.class"));
			Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}


}
