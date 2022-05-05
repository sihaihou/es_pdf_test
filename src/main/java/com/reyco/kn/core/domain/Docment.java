package com.reyco.kn.core.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/** 
 * @author  reyco
 * @date    2022.01.06
 * @version v1.0.1 
 */
public class Docment{
	
	public static void main(String[] args) {
		test1();     //1,000,000:3816,3710,4188    5,000,000:,
		//test2();   //1,000,000:3927,4037,4004
		//test3();   //1,000,000:2796,2635,2636
		//test4();   //1,000,000:3260,3078,2971
	}
	
	public static void test1() {
		Map<String,String> map = new HashMap<>(7000000);
		for(int i=0;i++<5000000;) {
			map.put("key"+i, "value"+i);
		}
		long start = System.currentTimeMillis();
		for(Entry<String, String> entry: map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("end1-start:"+(end1-start));
	}
	public static void test2() {
		Map<String,String> map = new HashMap<>();
		for(int i=0;i++<5000000;) {
			map.put("key"+i, "value"+i);
		}
		long start = System.currentTimeMillis();
		for(Iterator<Entry<String, String>> iterator= map.entrySet().iterator();iterator.hasNext();) {
			Entry<String, String> entry = iterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("end1-start:"+(end1-start));
	}
	public static void test3() {
		Map<String,String> map = new HashMap<>();
		for(int i=0;i++<5000000;) {
			map.put("key"+i, "value"+i);
		}
		long start = System.currentTimeMillis();
		for(String key :map.keySet()) {
			System.out.println(key);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("end1-start:"+(end1-start));
	}
	public static void test4() {
		Map<String,String> map = new HashMap<>();
		for(int i=0;i++<5000000;) {
			map.put("key"+i, "value"+i);
		}
		long start = System.currentTimeMillis();
		for(String value :map.values()) {
			System.out.println(value);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("end1-start:"+(end1-start));
	}
}