package exercises.ex05;

public class Pizza {
	private static int totalPedidas = 0;
	private static int totalServidas = 0;
	private Size tamano;
	private Type tipo;
	private State estado;

	public Pizza(Type tipo, Size tamano) {
		this.tipo = tipo;
		this.tamano = tamano;
		this.estado = State.pedida;
		totalPedidas++;
	}

	public Pizza(String type, String size) {
		if (type.equalsIgnoreCase(Type.FUNGHI.toString()))
			this.tipo = Type.FUNGHI;
		else if (type.equalsIgnoreCase(Type.CUATRO_QUESOS.toString()))
			this.tipo = Type.CUATRO_QUESOS;
		else
			this.tipo = Type.MARGARITA;
		if (size.equalsIgnoreCase(Size.familiar.toString()))
			this.tamano = Size.familiar;
		else
			this.tamano = Size.mediana;
		this.estado = State.pedida;
		totalPedidas++;
	}

	public void sirve() {
		if (estado == State.servida) {
			System.err.println("Esa pizza ya se ha servido.");
			return;
		}
		this.estado = State.servida;
		totalServidas++;
	}

	/**
	 * @return Pizzas totales Pedidas
	 */
	public static int getTotalPedidas() {
		return totalPedidas;
	}

	/**
	 * @return Pizzas totales Servidas
	 */
	public static int getTotalServidas() {
		return totalServidas;
	}

	@Override
	public String toString() {
		return String.format("pizza %s %s, %s", tipo.toString(), tamano.toString(), estado.toString());
	}
}
