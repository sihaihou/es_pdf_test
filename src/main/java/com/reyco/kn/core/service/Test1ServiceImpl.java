package com.reyco.kn.core.service;

import org.springframework.stereotype.Service;

/** 
 * @author  reyco
 * @date    2022.04.26
 * @version v1.0.1 
 */
@Service
public class Test1ServiceImpl implements TestService{
	@Override
	public Boolean support(String name) {
		return name.equals("test1");
	}
	@Override
	public void test(String name) {
		System.out.println("Test1ServiceImpl:"+name);
	}

}
