package com.java.basic;

public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Loops
		
		// While
		// Do While
		// For
		
		//WHILE
		int numero = 1;
		
		while(numero<=10) {
			System.out.println("Contador: "+numero);
			++numero;
		}
		
		System.out.println("While Loop finish");
		
		// DO-WHILE
		
		// Cuantas veces se tiene que sumar un mismo numero para llegar
		// a 100?
		
		int numeroLimite = 10;
		int sumTotal=0;
		int count = 0;
		
		do {
			
			sumTotal = sumTotal + numeroLimite;
			++count;
			
		}while(sumTotal<100);
		
		System.out.println("El numero se sumo: "+count);
		
		// FOR
		
		int numeroFor = 10;
		
		for(int i = 1; i <= numeroFor; i++) {
			System.out.println("El numero FOR es: "+i);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
