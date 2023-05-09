package com.designpattern.proxy;

public class ProtectionProxyDemo {
	
	public static void main(String[] args) {
		Drivable car=new CarProxy(new Driver("Kishan",21));
		car.drive();
	}

}
