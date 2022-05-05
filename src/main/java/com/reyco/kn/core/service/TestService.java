package com.reyco.kn.core.service;

/**
 * @author reyco
 * @date 2022.01.04
 * @version v1.0.1
 */
public interface TestService {
	
	default Boolean support(String name) {
		return false;
	}
	
	public void test( String name);
}
