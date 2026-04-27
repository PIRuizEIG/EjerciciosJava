package exercises.ex09;

import exercises.ex08.Terminal;

/**
 * <h1>Ejercicio 9</h1> Implementa la clase Movil como subclase de Terminal (la
 * clase del ejercicio anterior que ya no hace falta modificar).<br>
 * Cada móvil lleva asociada una tarifa que puede ser “rata”, “mono” o
 * “bisonte”. El coste por minuto es de 6, 12 y 30 céntimos respectivamente. Se
 * tarifican los segundos exactos. Obviamente, cuando un móvil llama a otro, se
 * le cobra al que llama, no al que recibe la llamada. A continuación se
 * proporciona el contenido del main y el resultado que debe aparecer por
 * pantalla. Para que el total tarificado aparezca con dos decimales, puedes
 * utilizar DecimalFormat.
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Movil extends Terminal {

	/** Coste por minuto de la tarifa rata */
	public static double RAT_TARIFF = 0.06;
	/** Coste por minuto de la tarifa mono */
	public static double MONKEY_TARIFF = 0.12;
	/** Coste por minuto de la tarifa bisonte */
	public static double BISON_TARIFF = 0.30;

	/** Coste por minuto */
	private double tariff = 0;
	/** Tarificado */
	private double billed;

	/** Generar móvil con 0s usados en una tarifa concreta */
	public Movil(String number, String tariff) {
		super(number);
		billed = 0;
		switch (tariff.toLowerCase()) {
		case "rata" -> this.tariff = RAT_TARIFF;
		case "mono" -> this.tariff = MONKEY_TARIFF;
		case "bisonte" -> this.tariff = BISON_TARIFF;
		}
	}

	/** Calcular factura */
	public double calcBill() {
		return ((double) billed / 60) * tariff;
	}

	@Override
	public void llama(Terminal terminal, int amount) {
		super.llama(terminal, amount);
		this.billed += amount;
	}

	/**
	 * Cadena de móvil con formato Nº "Número" - "Tiempo"s de conversación -
	 * tarificados "total" euros
	 */
	@Override
	public String toString() {
		return super.toString() + String.format(" - tarificados %.2f euros", calcBill());
	}
}
