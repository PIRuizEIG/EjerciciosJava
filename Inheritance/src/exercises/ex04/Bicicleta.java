package exercises.ex04;

public class Bicicleta extends Vehiculo {
	
	private static final int MAX_MARCHA = 6;
	
	private final double DISTANCIA = 2;

	private int marcha;

	public Bicicleta() {
		super();
		marcha = 0;
	}

	/**
	 * @return the marcha
	 */
	public int getMarcha() {
		return marcha;
	}

	public void aumentarMarcha() {
		if (marcha < MAX_MARCHA)
			marcha++;
	}

	public void reducirMarcha() {
		if (marcha > 0)
			marcha--;
	}
	
	public void hacerCaballito() {
	    System.out.println("La bicicleta hace un caballito");
	    recorrerDistancia(0.1);
	}
	
	public void andar() {
	    double distancia = DISTANCIA + marcha * 0.5;
	    recorrerDistancia(distancia);
	    System.out.println("La bicicleta avanza " + distancia + " km");
	}
}
