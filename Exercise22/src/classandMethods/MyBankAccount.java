package classandMethods;

import java.util.Scanner;

/* Desarrollar una clase que permita:
 *  • Cargar nombre del titular y monto inicial.
 *  • Un método depositar(double monto) que incremente el saldo.
 *  • Un método extraer(double monto) que lo disminuya, siempre que haya saldo.
 *  • Un método double obtenerSaldo() que devuelva el valor actual.
 *  • Un método para inicializarlo.
 *  Autor: Pablo Illescas
 */

/**
 * Clase que controla una cuenta bancaria
 */
public class MyBankAccount {
	/**
	 * Atributo con el nombre del titular
	 */
	public String name;
	/**
	 * Atributo con el saldo en la cuenta
	 */
	public double balance;

	/**
	 * Constructor para crear cuenta con valores iniciales
	 * 
	 * @param nombre Nombre del titular
	 * @param monto  Saldo inicial
	 */
	public MyBankAccount(String nombre, double monto) {
		init(nombre, monto);
	}
	
	/**
	 * Constructor para crear cuenta sin valores iniciales
	 */
	public MyBankAccount() {
	}

	/**
	 * Inicializar los valores de la cuenta
	 * 
	 * @param nombre Nombre del titular
	 * @param monto  Saldo inicial
	 */
	public void init(String nombre, double monto) {
		name = nombre;
		balance = monto;
	}

	/**
	 * Depositar una cantidad de dinero en la cuenta
	 * 
	 * @param monto Cantidad a añadir
	 */
	public void depositar(double monto) {
		if (monto == 0) {
			System.out.println("Error. No hay nada a modificar.");
		} else if (monto < 0) {
			System.out.println("Error. No se puede añadir una cantidad negativa.");
		} else
			balance += monto;
	}

	/**
	 * Extraer saldo de la cuenta
	 * 
	 * @param monto Cantidad a extraer
	 */
	public void extraer(double monto) {
		if (monto == 0) {
			System.out.println("Error. No hay nada a modificar.");
		} else if (monto < 0) {
			System.out.println("Error. No se puede retirar una cantidad negativa.");
		} else if (monto > balance) {
			System.out.println("Error. No hay saldo suficiente para la operación.");
		} else
			balance -= monto;
	}
	
	/**
	 * Saldo actual en la cuenta
	 * @return Double con el saldo
	 */
	public double obtenerSaldo()
	{
		return balance;
	}
	
	/**
	 * Muestra la información de la cuenta
	 */
	public void ShowData()
	{
		System.out.printf("Titular: %s, Saldo: %.2f€.%n", name, balance);
	}
	
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		var miCuenta = new MyBankAccount("Pedro Sanchez", 300);
		miCuenta.ShowData();
		System.out.printf("Añadir %.2f€.%n", 50.00);
		miCuenta.depositar(50);
		System.out.printf("Saldo tras la operación: %.2f€.%n", miCuenta.obtenerSaldo());
		System.out.printf("Retirar %.2f€.%n", 25.00);
		miCuenta.extraer(25);
		System.out.printf("Saldo tras la operación: %.2f€.%n", miCuenta.obtenerSaldo());
		
		System.out.print("Introduzca el nombre del titular: ");
		var miCuenta2 = new MyBankAccount();
		String name = sc.nextLine();
				double saldo;
		do {
			System.out.print("Introduzca el saldo inicial: ");
			saldo = sc.nextDouble();
			
			if (saldo < 0)
			System.out.println("Error. El saldo debe ser positivo");
		} while (saldo < 0);
		miCuenta2.init(name, saldo);
		miCuenta2.ShowData();
		
		System.out.print("Introduzca el nombre del titular: ");
		sc.nextLine();
		String name2 = sc.nextLine();
				double saldo2;
		do {
			System.out.print("Introduzca el saldo inicial: ");
			saldo2 = sc.nextDouble();
			
			if (saldo2 < 0)
			System.out.println("Error. El saldo debe ser positivo");
		} while (saldo2 < 0);
		var miCuenta3 = new MyBankAccount(name2, saldo2);
		miCuenta3.ShowData();
	}
}
