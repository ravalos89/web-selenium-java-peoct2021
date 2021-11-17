package com.java.polimorfismo;

public class Perro extends Animal{
	
	int numeroPatas;
	String largoCola;

	@Override
	public void speak() {
		
		System.out.println("Woof-Woof");
	}

}
