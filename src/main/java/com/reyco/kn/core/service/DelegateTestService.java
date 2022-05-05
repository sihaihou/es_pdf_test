package com.reyco.kn.core.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.reyco.kn.core.service.DelegateTestService.TestEvent;

/**
 * @author reyco
 * @date 2022.04.21
 * @version v1.0.1
 */
@Service("delegateService")
public class DelegateTestService extends AbstractTestService implements ApplicationListener<TestEvent> {
	
	@Resource(name="delegateService")
	private TestService testService;
	
	public void onApplicationEvent(TestEvent event) {
		testService.test(event.getName());
	}
	
	@Override
	public void test(String name) {
		TestService testService = getMatchTestService(name);
		testService.test(name);
	}

	public static class TestEvent extends ApplicationEvent {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3099680854669213675L;
		private String name;

		/**
		 * @param source
		 */
		public TestEvent(Object source, String name) {
			super(source);
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
