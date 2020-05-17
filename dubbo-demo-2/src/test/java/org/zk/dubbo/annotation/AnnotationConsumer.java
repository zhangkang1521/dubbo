package org.zk.dubbo.annotation;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.zk.dubbo.api.DemoService;
import org.zk.dubbo.consumer.DemoConsumer;

public class AnnotationConsumer {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
		ctx.start();
		DemoConsumer demoConsumer = ctx.getBean(DemoConsumer.class);
		demoConsumer.hi();
	}

	@Configuration
	@EnableDubbo(scanBasePackages = "org.zk.dubbo.consumer")
	@ComponentScan(value = "org.zk.dubbo.consumer")
	static class ConsumerConfiguration {

		@Bean
		public ConsumerConfig consumerConfig() {
			return new ConsumerConfig();
		}

		@Bean
		public ApplicationConfig applicationConfig() {
			ApplicationConfig applicationConfig = new ApplicationConfig();
			applicationConfig.setName("demo-consumer");
			return applicationConfig;
		}

		@Bean
		public RegistryConfig registryConfig() {
			RegistryConfig registryConfig = new RegistryConfig();
			registryConfig.setProtocol("zookeeper"); // ?
			registryConfig.setAddress("localhost");
			registryConfig.setPort(2181);
			return registryConfig;
		}
	}
}
