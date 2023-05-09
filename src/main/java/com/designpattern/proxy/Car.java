package com.designpattern.proxy;

class Car implements Drivable {
	 
	private final Driver driver;
	
	public Car(Driver driver) {
		this.driver=driver;
	}

	@Override
	public void drive() {
		// TODO Auto-generated m  ethod stub
		System.out.println("Car being Driven "+driver.toString());
	}
	

}
