// suma de impares 
package com.java.basic;

public class SumOddAngel {
	/*
	 * * Escriba un método llamado isOdd con un parámetro int y llámelo número. El
	 * método debe devolver un valor booleano. Verifique que el número sea> 0,si no
	 * es devuelve falso. Si el número es impar, devuelve verdadero; de lo
	 * contrario, devuelve falso. Escriba un segundo método llamado sumOdd que tenga
	 * 2 parámetros int start y end, que representan un rango de números. El método
	 * debe usar un bucle for para sumar todos los números impares en ese rango,
	 * incluido el final y devolver la suma. Debería llamar al método isOdd para
	 * comprobar si cada número es impar. El final del parámetro debe ser mayor o
	 * igual que el inicio y los parámetros de inicio y finalización deben ser
	 * mayores que 0. Si esas condiciones no se cumplen, devuelva -1 del método para
	 * indicar una entrada no válida. Ejemplo de entrada / salida: sumOdd (1, 100);
	 * → debe devolver 2500 sumOdd (-1, 100); → debe devolver -1 sumOdd (100, 100);
	 * → debe devolver 0 sumOdd (13, 13); → debe devolver 13 (este conjunto contiene
	 * un número, 13, y es impar) sumOdd (100, -100); → debe devolver -1 sumOdd
	 * (100, 1000); → debe devolver 247500 SUGERENCIA: use el operador restante para
	 * verificar si el número es impar. NOTA: Ambos métodos deben definirse como
	 * estáticos públicos como lo hemos estado haciendo hasta ahora en el curso.
	 * NOTA: No agregue un método principal al código de la solución.
	 * 
	 */

	public static void main(String[] args) {

		// isOdd(-72);
		sumOdd(100, 1000);
	}

	public static void sumOdd(int start, int end) {
		int suma = 0;
		// boolean r =true;
		for (int i = start; i <= end; i++) {
			isOdd(i);
			if (i > 0 && i % 2 == 1) {
				suma = suma + i;
			} else {
				System.out.println(-1);
			}
		}
		System.out.println(suma);
	}

	public static boolean isOdd(int número) {
		boolean r;
		if (número > 0 && número % 2 == 1) {
			r = true;
		} else {
			r = false;
		}
		return r;
	}
}
