package Ejercicio4;

/**
 * <h1>Implementa una clase CuentaBancaria que simule una cuenta sencilla.</h1>
 * <h2>Requisitos:</h2>
 * <p>
 * Atributos privados:
 * <ul>
 * <li>titular (String).</li>
 * <li>saldo (double).</li>
 * </ul>
 * <p>
 * Constructores:
 * <ul>
 * <li>CuentaBancaria(String titular) con saldo inicial 0.</li>
 * <li>CuentaBancaria(String titular, double saldoInicial) (si el saldo inicial
 * es negativo, se pone a 0).</li>
 * </ul>
 * <p>
 * Métodos públicos:
 * <ul>
 * <li>getTitular(), getSaldo() (no hay setSaldo, se controla con métodos).</li>
 * <li>ingresar(double cantidad): solo admite cantidades positivas.</li>
 * <li>retirar(double cantidad): solo si hay saldo suficiente y la cantidad es
 * positiva.</li>
 * </ul>
 * <p>
 * Añade un método toString() que devuelva una descripción básica de la cuenta.
 * <h2>Autor: Pablo Illescas</h2>
 */
public class CuentaBancaria {

	/**
	 * Titular de la cuenta
	 */
	private String titular;

	/**
	 * Saldo de la cuenta
	 */
	private double saldo;

	/**
	 * Genera una cuenta con Titular y saldo pasados
	 * 
	 * @param titular      Titular de la cuenta
	 * @param saldoInicial Saldo de la cuenta
	 */
	public CuentaBancaria(String titular, double saldoInicial) {
		this.titular = titular;
		if (saldoInicial < 0)
			saldoInicial = 0;
		this.saldo = saldoInicial;
	}

	/**
	 * Genera una cuenta con el Titular pasado y saldo 0
	 * 
	 * @param titular Titular de la cuenta
	 */
	public CuentaBancaria(String titular) {
		this.saldo = 0;
		this.titular = titular;
	}

	/**
	 * Devuelve el titular de la cuenta
	 * 
	 * @return Titular de la cuenta
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * Devuelve el saldo de la cuenta
	 * 
	 * @return Efectivo en la cuenta
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Ingresa saldo en la cuenta, solo admite cantidades positivas
	 * 
	 * @param cantidad Cantidad a ingresar
	 */
	public void ingresar(double cantidad) {
		if (cantidad >= 0)
			this.saldo += cantidad;
		else
			System.out.println("Error. Solo se pueden ingresar cantidades positivas");
	}

	/**
	 * Retira efectivo, solo si hay saldo suficiente y la cantidad es positiva.
	 * 
	 * @param cantidad Cantidad a retirar
	 * @return Efectivo retirado
	 */
	public void retirar(double cantidad) {

		if (cantidad < 0)
			System.out.println("Error. Solo se pueden retirar cantidades positivas");
		else {
			if (cantidad <= saldo)
				saldo -= cantidad;
			else
				System.out.println("Error. No hay suficiente efectivo en cuenta");
		}
	}
	
	/**
	 * Descripción básica de la cuenta
	 */
	public String toString() {
		String cadena = "Cuenta de [Titular]: saldo [Saldo] €";
		cadena = cadena.replace("[Titular]", titular);
		cadena = cadena.replace("[Saldo]", Double.toString(saldo));
		return cadena;
	}
}
