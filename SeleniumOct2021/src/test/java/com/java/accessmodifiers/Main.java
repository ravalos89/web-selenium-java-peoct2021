package com.java.accessmodifiers;

import com.java.intermedio.Padre;

public class Main extends Padre{

	public Main(double estatura, int edad, String sexo) {
		super(estatura, edad, sexo);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Padre object = new Padre(1.70, 40, "Masculino");

	}

}
