package ej01_09;

/**
 * Clase de cartas de la baraja española
 */
// implements Comparable para poder sobreescribir compareTo para permitir ordenar la lista con Collections.sort
public class Carta implements Comparable<Carta> {
	/**
	 * Palo de la carta
	 */
	private Palos palo;
	/**
	 * Número de la carta
	 */
	private int num;

	/**
	 * Nombre de los números
	 */
	private static final String[] NUMBER_NAME = { "As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" };

	/**
	 * Generar carta
	 * 
	 * @param palo Palo
	 * @param num  Número
	 */
	public Carta(Palos palo, int num) {
		if (num < 1 || num > NUMBER_NAME.length) {
			throw new IllegalArgumentException("Número debe estar entre 1 y " + NUMBER_NAME.length);
		}
		this.palo = palo;
		this.num = num;
	}

	@Override
	public String toString() {
		return String.format("%7s de %-7s", getNum(), palo);
	}

	/**
	 * @return El palo
	 */
	public Palos getPalo() {
		return palo;
	}

	/**
	 * @return El número
	 */
	public String getNum() {
		return NUMBER_NAME[num - 1];
	}

	// Creado equals y hashcode para poder usar contains

	/**
	 * Comprueba si dos cartas son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		// Si la carta y el objeto a comparar apuntan al mismo objeto en memoria, son
		// iguales
		if (this == obj)
			return true;

		// Si el objeto a comparar no es una carta, no pueden ser iguales
		if (!(obj instanceof Carta))
			return false;

		// Convertimos el objeto a Carta para poder compararlo
		Carta other = (Carta) obj;

		// Dos cartas son iguales si tienen el mismo número y el mismo palo
		return this.num == other.num && this.palo == other.palo;
	}

	/**
	 * Genera un código hash para la carta
	 */
	@Override
	public int hashCode() {
		// Se combina el número y el palo para generar el hash.
		// Multiplicado por 31 porque es primo y los números primos reducen colisiones
		// en tablas hash.
		return 31 * num + palo.hashCode();
	}

	// Generar compareTo para poder definir orden de cartas

	/**
	 * Comparar cartas
	 */
	@Override
	public int compareTo(Carta other) {

		// Comparar primero por palo
		int comparePalo = this.palo.compareTo(other.palo);

		// Si no son iguales devolver la comparación por palo
		if (comparePalo != 0) {
			return comparePalo;
		}

		// Si el palo es el mismo, comparar por número
		return Integer.compare(this.num, other.num);
	}
}
