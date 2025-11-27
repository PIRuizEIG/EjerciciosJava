package classandMethods;

import java.util.Scanner;
/* Crear una clase que modele un círculo con un atributo radio.
 * Debe contener:
 *  • Un constructor que inicialice el radio.
 *  • Métodos que devuelvan el área y la longitud de la circunferencia.
 *  • Un método imprimirDatos() que muestre todos los valores.
 *  Indicaciones
 *  • Utiliza Math.PI y Math.pow().
 *  Autor: Pablo Illescas
 */

/**
 * Clase para modelar un círculo
 */
public class Mycircle {
	/**
	 * Radio del círculo
	 */
	public double radius;

	/**
	 * Constructor para crear un nuevo círculo con radio específico
	 * 
	 * @param radius Radio del círculo
	 */
	public Mycircle(double radius) {
		this.radius = radius;
	}

	/**
	 * Constructor para crear un nuevo círculo con valor por teclado
	 */
	public Mycircle() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Introduzca el radio del círculo: ");
			this.radius = sc.nextDouble();
			
			if (radius <= 0)
			System.out.println("Error. El radio debe ser mayor a 0.");
		} while (radius <= 0);
	}

	/**
	 * Método que devuelve el área del círculo
	 * 
	 * @return Double con el área del circulo
	 */
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	/**
	 * Método que devuelve la longitud de la circunferencia
	 * 
	 * @return Double con la longitud
	 */
	public double circumference() {
		return (2 * Math.PI * radius);
	}

	/***
	 * Método que muestra todos los valores
	 */
	public void showData() {
		System.out.printf("Radio: %.2f, Área: %.2f, Longitud de la circunferencia: %.2f%n", radius, this.area(),
				this.circumference());
	}

	public static void main(String args[]) {
		Mycircle circle = new Mycircle(5);
		circle.showData();

		var circle2 = new Mycircle();
		circle2.showData();
	}
}
