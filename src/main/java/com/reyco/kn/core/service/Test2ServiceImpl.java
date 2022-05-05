package com.reyco.kn.core.service;

import org.springframework.stereotype.Service;

/** 
 * @author  reyco
 * @date    2022.04.26
 * @version v1.0.1 
 */
@Service
public class Test2ServiceImpl implements TestService{
	@Override
	public Boolean support(String name) {
		return name.equals("test2");
	}
	@Override
	public void test(String name) {
		System.out.println("Test2ServiceImpl:"+name);
	}

}
