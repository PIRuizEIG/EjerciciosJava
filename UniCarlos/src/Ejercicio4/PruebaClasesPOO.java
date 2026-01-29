package Ejercicio4;

/**
 * Crea una clase PruebaClasesPOO con un método main que instancie objetos de
 * todas las clases, llame a sus constructores sobrecargados, métodos
 * encapsulados y demuestre sobrecarga. El programa debe mostrar por consola
 * resultados que verifiquen el comportamiento correcto (sin errores de
 * compilación ni runtime). Incluye manejo básico de casos límite (ej. valores
 * negativos).
 * <h2>Autor: Pablo Illescas</h2>
 */
public class PruebaClasesPOO {

	public static void main(String args[]) {
		System.out.println("--- Prueba Punto ---");
		var p1 = new Punto();
		var p2 = new Punto(3, 4);
		System.out.printf("Punto origen: (%d,%d), distancia: %.2f%n", p1.getX(), p1.getY(), p1.distanciaOrigen());
		p1.mover(p2);
		System.out.printf("Tras mover a punto (%d,%d): (%d,%d), distancia: %.2f%n", p2.getX(), p2.getY(), p1.getX(),
				p1.getY(), p1.distanciaOrigen());
		System.out.printf("Punto (%d,%d): distancia %.2f%n", p2.getX(), p2.getY(), p2.distanciaOrigen());
		p2.mover(2, 1);
		System.out.printf("Tras mover(2,1): (%d,%d)%n", p2.getX(), p2.getY());

		System.out.println();
		
		System.out.println("--- Prueba Rectángulo ---");
		var r1 = new Rectangulo();
		var r2 = new Rectangulo(10, 5);
		var r3 = new Rectangulo(r2);
		var c1 = new Rectangulo(4);
		System.out.printf("Rectángulo 1 (%.1fx%.1f): área %.1f, perímetro %.1f%n", r1.getWidth(), r1.getHeight(),
				r1.area(), r1.perimetro());
		System.out.printf("Rectángulo 2 (%.1fx%.1f): área %.1f, perímetro %.1f%n", r2.getWidth(), r2.getHeight(),
				r2.area(), r2.perimetro());
		r2.redimensionar(2);
		System.out.printf("Tras redimensionar(2.0): Rectángulo (%.1fx%.1f): área %.1f, perímetro %.1f%n", r2.getWidth(),
				r2.getHeight(), r2.area(), r2.perimetro());
		System.out.printf("Rectángulo 3 (%.1fx%.1f): área %.1f, perímetro %.1f%n", r3.getWidth(), r3.getHeight(),
				r3.area(), r3.perimetro());
		r3.redimensionar(6, 3);
		System.out.printf("Tras redimensionar(6,3): Rectángulo (%.1fx%.1f): área %.1f, perímetro %.1f%n", r3.getWidth(),
				r3.getHeight(), r3.area(), r3.perimetro());
		System.out.printf("Cuadrado (%.1fx%.1f): área %.1f, perímetro %.1f%n", c1.getWidth(), c1.getHeight(), c1.area(),
				c1.perimetro());
		
		System.out.println();

		System.out.println("--- Prueba CuentaBancaria ---");
		var b1 = new CuentaBancaria("Juan", 1000);
		var b2 = new CuentaBancaria("Alberto");
		System.out.printf("%s%n", b1.toString());
		b1.ingresar(500);
		System.out.printf("Tras ingresar 500: %.2f €%n", b1.getSaldo());
		b1.retirar(200);
		System.out.printf("Tras retirar 200: %.2f €%n", b1.getSaldo());
		System.out.printf("%s%n", b2.toString());
		b2.ingresar(-300);
		b2.retirar(-100);
		b2.retirar(1000);
		
		System.out.println();
		
		System.out.println("--- Prueba NIF ---");
		var n1 = new NIF(12345678);
		System.out.printf("NIF 12345678: %s%n", n1.getNIFCompleto());
		System.out.printf("Letra calculada para 87654321: %c%n", NIF.calcularLetra(87654321));
		var n2 = new NIF(n1);
		System.out.printf("NIF duplicado: %s%n", n2.getNIFCompleto());
	}
}
