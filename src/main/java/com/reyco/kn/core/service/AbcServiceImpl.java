package com.reyco.kn.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.reyco.kn.core.service.DelegateTestService.TestEvent;

/** 
 * @author  reyco
 * @date    2022.04.26
 * @version v1.0.1 
 */
@Service
public class AbcServiceImpl implements AbcService{
	@Autowired
	private ApplicationContext applicationContext;
	@Override
	public void send(String name) {
		applicationContext.publishEvent(new TestEvent(this,name));
	}

}
