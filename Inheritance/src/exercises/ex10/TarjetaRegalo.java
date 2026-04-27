package exercises.ex10;

import java.util.ArrayList;
import java.util.Random;

/**
 * <h1>Ejercicio 10</h1> La empresa El Corte Islandés nos ha encargado una
 * aplicación para gestionar las tarjetas regalo. Como primer paso para
 * implementar la aplicación, es necesario crear la clase principal.<br>
 * Implementa la clase TarjetaRegalo. Cuando se crea una nueva tarjeta, se le da
 * un saldo y se asigna de forma automática un número de 5 dígitos.<br>
 * Si se intenta gastar más dinero del que tiene la tarjeta, se debe mostrar un
 * mensaje de error.<br>
 * Dos tarjetas regalo se pueden fusionar creando una nueva tarjeta con la suma
 * del saldo que tenga cada una y un nuevo número aleatorio de 5 cifras. Al
 * fusionar dos tarjetas en una, las dos tarjetas originales se quedarían con 0
 * € de saldo.<br>
 * <h2>Autor: Pablo Illescas</h2>
 */
public class TarjetaRegalo {
	/** ID Límite */
	public static final int MAX_ID = 100000;
	/** Random para generar números de tarjeta */
	private static final Random rnd = new Random();

	/** Tarjetas activas */
	private static ArrayList<Integer> activeCards = new ArrayList<>();

	/** Número identificador de tarjeta */
	private int id;
	/** Saldo */
	private double balance;

	/**
	 * Generar tarjeta regalo con un saldo predeterminado
	 * 
	 * @param balance Saldo de la nueva tarjeta
	 */
	public TarjetaRegalo(double balance) {
		if (balance < 0)
			throw new IllegalArgumentException("El saldo no puede ser negativo");
		if (activeCards.size() >= MAX_ID)
			throw new IllegalStateException("No se pueden crear más tarjetas");
		this.balance = balance;
		this.id = generateUniqueId();
		activeCards.add(this.id);
	}

	/** @return Número de tarjeta disponible */
	private int generateUniqueId() {
		int number = 0;
		do {
			number = rnd.nextInt(0, MAX_ID);
		} while (activeCards.contains(number));
		return number;
	}

	/** @return Random */
	public static Random getRnd() {
		return rnd;
	}

	/** @return Número de tarjeta */
	public int getId() {
		return id;
	}

	/** @return Saldo */
	public double getBalance() {
		return balance;
	}

	/** @return Cantidad de tarjetas activas */
	public static int getCardAmount() {
		return activeCards.size();
	}

	/** @return Tarjetas Activas */
	public ArrayList<Integer> getActiveCards() {
		return new ArrayList<>(activeCards);
	}

	/**
	 * Gastar saldo de la tarjeta
	 * 
	 * @param amount Cantidad a gastar
	 */
	public void gasta(double amount) {
		if (amount > balance)
			System.err.printf("No tiene suficiente saldo para gastar %.2f€\n", amount);
		else
			balance -= amount;
	}

	/**
	 * Fusionar saldo con otra tarjeta Regalo
	 * 
	 * @param other Tarjeta nueva
	 * @return Tarjeta con el saldo conmbinado
	 * @throws InvalidAttributesException
	 */
	public TarjetaRegalo fusionaCon(TarjetaRegalo other) {
		var newCard = new TarjetaRegalo(this.balance + other.balance);
		this.balance = 0;
		other.balance = 0;
		return newCard;
	}

	/** Cadena de tarjeta regalo con formato Tarjeta nº "Número" – Saldo "Saldo"€ */
	@Override
	public String toString() {
		return String.format("Tarjeta nº %05d – Saldo %.2f€", id, balance);
	}
}
