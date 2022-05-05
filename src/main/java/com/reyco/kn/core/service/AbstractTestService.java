package com.reyco.kn.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/** 
 * @author  reyco
 * @date    2022.04.26
 * @version v1.0.1 
 */
public abstract class AbstractTestService implements TestService{
	
	@Autowired
	private List<TestService> testService;
	
	public TestService getMatchTestService(String name) {
		for (TestService testService : testService) {
			if(testService.support(name)) {
				return testService;
			}
		}
		return null;
	}
}
