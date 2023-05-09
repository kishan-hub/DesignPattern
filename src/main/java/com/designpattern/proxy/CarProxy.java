package com.designpattern.proxy;

class CarProxy extends Car{
	
	private Driver driver;

	public CarProxy(Driver driver) {
		super(driver);
	}
	
	public void drive() {
		// TODO Auto-generated method stub
	    if(driver.age >=17)
	    	super.drive();
	    else
	    	System.out.println("Driver is too young");
	}

}
