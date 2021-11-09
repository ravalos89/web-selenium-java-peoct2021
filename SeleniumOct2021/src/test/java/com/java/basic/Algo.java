package com.java.basic;

public class Algo {
	
	public static void main(String[] args) {
		
		confirmSuma(2, 2, 4);
		
		System.out.println("La resta es "+resta(5,3));
		
		System.out.println("La resta2 es "+resta(100,99));	
		
	}
	
	public static int resta (int x, int y){
		return x-y; 		
	}
	
	
	public static String holaMundo() {
		System.out.println("Imprime");
		return "Hola Mundo";
		
	}
	
	public static int suma(int x, int y) {
		System.out.println(holaMundo());
		int suma = x+y;
		return suma;
	}
	
	public static void confirmSuma(int x, int y, int sumaTotal) {
		if(sumaTotal==suma(x,y)) {
			System.out.println("Se confirmo la suma que es correcta");
		}else {
			System.out.println("Se confirmo la suma que es Incorrecta");
		}
	}

}
