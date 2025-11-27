package classandMethods;

import java.util.Scanner;
/*
 * Define una clase con atributos base y altura, y los siguientes métodos:
 *  • void inicializar(double base, double altura)
 *  • double calcularHipotenusa() (usa Math.sqrt() y Math.pow())
 *  • double calcularPerimetro()
 *  • double calcularArea()
 *  Imprimir los resultados llamando desde un método mostrarDatos().
 *  Autor: Pablo Illescas
 */

/**
 * Clase para modelar un triángulo rectángulo
 */
public class MyTriangle {
	/**
	 * Base del triángulo
	 */
	public double base;

	/**
	 * Altura del triángulo
	 */
	public double altura;
	
	/**
	 * Constructor para crear un nuevo triángulo rectangulo
	 */
	public MyTriangle()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		double a, b;
		
		do {
			System.out.print("Introduzca la altura del triángulo: ");
			a = sc.nextDouble();
			
			if (a <= 0)
			System.out.println("Error. El altura debe ser mayor a 0.");
		} while (a <= 0);
		
		do {
			System.out.print("Introduzca la base del triángulo: ");
			b = sc.nextDouble();
			
			if (b <= 0)
			System.out.println("Error. El base debe ser mayor a 0.");
		} while (b <= 0);
		this.inicializar(b, a);
	}
	
	/**
	 * Constructor para crear un nuevo triángulo con valores específicos
	 * @param base		Base del tríangulo
	 * @param altura	Altura del tríangulo
	 */
	public MyTriangle(double base, double altura) {
		this.inicializar(base, altura);
	}

	/**
	 * Inicializar los valores del triángulo
	 * 
	 * @param base   Nueva base
	 * @param altura Nueva altura
	 */
	public void inicializar(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	/**
	 * Método que devuelve la Hipotenusa del triángulo
	 * 
	 * @return Double con la Hipotenusa
	 */
	public double calcularHipotenusa() {
		return Math.sqrt((Math.pow(base, 2) + Math.pow(altura, 2)));
	}

	/**
	 * Método que devuelve el Perímetro del triángulo
	 * 
	 * @return Double con el Perímetro
	 */
	public double calcularPerimetro() {
		return (base + altura + this.calcularHipotenusa());
	}

	/**
	 * Método que devuelve el Área del triángulo
	 * 
	 * @return Double con el Área
	 */
	public double calcularArea() {
		return (base * altura) / 2;
	}

	/**
	 * Mostrar los datos del triángulo
	 */
	public void mostrarDatos() {
		System.out.printf("Base: %.2f, Altura: %.2f, Hipotenusa: %.2f, Perimetro: %.2f, Área: %.2f%n", 
				base, altura, this.calcularHipotenusa(), this.calcularPerimetro(), this.calcularArea());
	}
	
	public static void main(String args[]) {
		MyTriangle triangle = new MyTriangle(5, 10);
		triangle.mostrarDatos();

		var triangle2 = new MyTriangle();
		triangle2.mostrarDatos();
	}
}
