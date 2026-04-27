package exercises.ex01;

/**
 * Dada la clase base Vehiculo, crea una nueva clase Motocicleta que herede de
 * Vehiculo. Asegúrate de:<br>
 * 1. Definir un atributo específico para Motocicleta, como cilindrada (en
 * cc).<br>
 * 2. Implementar el constructor de Motocicleta que reciba la marca y la
 * cilindrada, utilizando super() para inicializar la parte Vehiculo.
 */
public class Motocicleta extends Vehiculo {
	/** Cilindrada en CC **/
	private int cilindrada;

	public Motocicleta(String marca, int cilindrada) {
		super(marca);
		this.cilindrada = cilindrada;
		System.out.println("Cilindrada Motocicleta: " + cilindrada);
	}

	@Override
	public void mostrarDetalles() {
		super.mostrarDetalles();
		System.out.println("Cilindrada (CC): " + cilindrada);
	}

}
