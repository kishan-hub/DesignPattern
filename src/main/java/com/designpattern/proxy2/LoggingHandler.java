package com.designpattern.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class LoggingHandler implements InvocationHandler {
	
	private final Object target;
	private Map<String, Integer> calls =new HashMap<>();

	public LoggingHandler(Object target) {
		// TODO Auto-generated constructor stub
		this.target =target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		String name =method.getName();
		
		if(name.contains("toString")) {
			return calls.toString();
		}
		 //add or increment number of calls
		calls.merge(name, 1, Integer::sum);
		return method.invoke(target, args);
	}

}
