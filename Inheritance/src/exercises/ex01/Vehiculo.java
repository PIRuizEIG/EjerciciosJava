package exercises.ex01;

public class Vehiculo {

	protected String marca;

	public Vehiculo(String marca) {
		this.marca = marca;
		System.out.println("Constructor Vehiculo: " + marca);
	}

	public void mostrarDetalles() {
		System.out.println("Marca: " + marca);
	}

}
