package com.reyco.kn.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reyco.kn.core.service.AbcService;

/** 
 * @author  reyco
 * @date    2022.04.21
 * @version v1.0.1 
 */
@RestController
@RequestMapping("event")
public class EventController {
	
	@Autowired
	private AbcService abcService;
	
	@GetMapping("test")
	public String test(String name) {
		abcService.send(name);
		return name;
	}
	
}
