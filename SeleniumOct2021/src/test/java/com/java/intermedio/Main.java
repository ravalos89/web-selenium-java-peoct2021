package com.java.intermedio;

public class Main {

	public static void main(String[] args) {
		
		Padre angel = new Padre(1.70, 40, "Masculino");
		Padre jorge = new Padre(1.75, 30, "Masculino");
		Padre sandra = new Padre(1.60, 33, "Femenino");
		
		Padre juan = new Padre(1.75, 60, "Masculino");
		System.out.println("Juan tiene el color de ojos: " + juan.colorOjos());
		
		Hijo juan2do = new Hijo(1.78, 38, "Masculino");
		System.out.println("Juan 2do tiene el color de ojos "+ juan2do.colorOjos("Verdes"));
		
		Nieto juanita = new Nieto(1.65, 20, "Femenino");
		System.out.println("Juanita tiene el color de ojos "+ juanita.colorOjos("Cafes", true));
		
		Nieto juanito3ro = new Nieto(1.20, 10, "Masculino");
		System.out.println("Juanito tiene una estatura de "+ juanito3ro.getEstatura());
		
		System.out.println("Paso 1 año...");
		juanito3ro.setEdad(11);
		juanito3ro.setEstatura(1.23);
		
		System.out.println("Ahora Juanito3ro tiene una edad de "+ juanito3ro.getEdad());
		System.out.println("Juanito3ro mide : "+ juanito3ro.getEstatura());
	}

}
