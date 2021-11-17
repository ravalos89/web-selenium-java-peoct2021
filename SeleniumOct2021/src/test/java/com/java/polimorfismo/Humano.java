package com.java.polimorfismo;

public class Humano extends Animal{
	
	int estatura;
	String nacionalidad;

	@Override
	public void speak() {
		System.out.println("Habla");
	}

}
