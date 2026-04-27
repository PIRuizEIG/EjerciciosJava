package exercises.ex04;

public class Coche extends Vehiculo {
	
	private final double DISTANCIA = 5;
	
	public void quemarRueda() {
	    System.out.println("El coche quema rueda");
	    recorrerDistancia(0.2);
	}
	
	public void andar() {
	    recorrerDistancia(DISTANCIA);
	    System.out.println("El coche avanza " + DISTANCIA + " km");
	}
}
