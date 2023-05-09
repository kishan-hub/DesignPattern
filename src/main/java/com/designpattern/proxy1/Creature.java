package com.designpattern.proxy1;

public class Creature {
	
	private Property<Integer> agility =new Property<Integer>(10);
	
	public void setAgility(Integer value) {
		agility.setValue(value);
	}
	
	public Integer getAgility() {
		return agility.getValue();
	}

}
