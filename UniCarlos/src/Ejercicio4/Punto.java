package Ejercicio4;

/**
 * <h1>Crea una clase Punto que represente un punto en un plano 2D.</h1>
 * <h2>Requisitos:</h2>
 * <p>
 * Atributos privados x e y (enteros).
 * <p>
 * Constructor por defecto que coloque el punto en el origen (0,0). (0, 0)
 * <p>
 * Constructor con parámetros Punto(int x, int y).
 * <p>
 * Constructor de copia Punto(Punto p).
 * <p>
 * Métodos get y set para x e y usando this cuando sea necesario.
 * <p>
 * Método mover(int dx, int dy) que desplace el punto.
 * <p>
 * Método distanciaOrigen() que devuelva la distancia al origen (como double).
 * (La distancia se calcula con el Teorema de Pitágoras (distancia euclidiana):
 * d = Raiz cuadrada (x^2 + y^2)
 * <p>
 * Sobrecarga de un método mover con la firma mover(Punto p) que mueva el punto
 * hasta la posición de otro punto.
 * 
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Punto {
	/**
	 * Posición en el eje x
	 */
	private int x;

	/**
	 * Posición en el eje y
	 */
	private int y;

	/**
	 * Crea un Punto en la posición indicada
	 * 
	 * @param x Posición en el eje x
	 * @param y Posición en el eje y
	 */
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Crea un punto en (0, 0)
	 */
	public Punto() {
		this(0, 0);
	}

	/**
	 * Duplica el punto p
	 * 
	 * @param p Punto a duplicar
	 */
	public Punto(Punto p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	/**
	 * Devuelve la posición en X
	 * 
	 * @return Posición en el eje X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Devuelve la posición en Y
	 * 
	 * @return Posición en el eje Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Asigna la posición en X
	 * 
	 * @param x nueva posición en X
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Asigna la posición en Y
	 * 
	 * @param Y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Desplaza el punto
	 * 
	 * @param dx Desplazamiento en el exe X
	 * @param dy Desplazamiento en el exe Y
	 */
	public void mover(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	/**
	 * Distancia al origen
	 * 
	 * @return Distancia euclidiana
	 */
	public double distanciaOrigen() {
		double distance = 0;

		distance = Math.sqrt((x * x) + (y * y));

		return distance;
	}

	/**
	 * Desplaza el punto a la posición de p
	 * 
	 * @param p Nueva posición
	 */
	public void mover(Punto p) {
		this.x = p.getX();
		this.y = p.getY();
	}
}
