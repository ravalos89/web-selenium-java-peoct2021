package com.java.intermedio;

public class Padre {
	double estatura;
	int edad;
	String sexo;
	
	// Constructor	
	public Padre(double estatura, int edad, String sexo) {
		this.estatura = estatura;
		this.edad = edad;
		this.sexo = sexo;	
	}
	
	public String colorOjos() {
		return "Azul";
	}
	
	// Overloading
	public String colorOjos(String colorOjos) {
		return colorOjos;
	}
	
	// Overloading
	public String colorOjos(String colorOjos, boolean x) {
		return colorOjos;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
