package com.java.basic;

public class Operators {

	public static void main(String[] args) {
		
		/*
		 * Operadores
		 * 
		 * Aritmeticos
		 * Unarios
		 * Relacionales
		 * condicionales
		 */
		
		// ARITMETICOS
		int var1 =3;
		int var2 =2;
		
		int suma=var1+var2;
		
		int resta=var1-var2;
		
		int multiplicacion = var1*var2;
		System.out.println(multiplicacion);
		
		System.out.println(suma+"--"+resta);
		
		double var3 = 3.34;
		double var4 = 2.56;
		
		System.out.println("La suma de las variables es "+(var3+var4));
		
		// UNARIOS
		
		int var5 = 3;
		
		--var5;
		
		++var5;
		++var5;
		
		System.out.println(var5);
		
		// RELACIONALES
		
		int var6 = 1;
		int var7 = 2;
		
		if(var6>var7) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
		
		String var8 = "Hola";
		String var9 = "Hello";
		
		if(var8!=var9) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
		
		// CONDICIONALES (&&=AND - ||=OR)
		
		boolean isDog = true;
		boolean isCat = true;
		
		if(isDog && isCat) {
			System.out.println("Los animales son TRUE");
		}else {
			System.out.println("Los animales son FALSE");
		}
		

	}

}
