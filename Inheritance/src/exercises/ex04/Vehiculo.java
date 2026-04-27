package exercises.ex04;

/**
 * <h1>Ejercicio 4
 * <h1>Crea la clase Vehiculo, así como las clases Bicicleta y Coche como
 * subclases de la primera. Para la clase Vehiculo, crea los atributos de clase
 * vehiculosCreados y kilometrosTotales, así como el atributo de instancia
 * kilometrosRecorridos.
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Vehiculo {
	private static int vehiculosCreados = 0;
	private static double kilometrosTotales = 0;
	private double kilometrosRecorridos;
	
	public Vehiculo() {
		vehiculosCreados++;
		kilometrosRecorridos = 0;
	}
	
	public void recorrerDistancia(double distancia) {
		kilometrosRecorridos += distancia;
		kilometrosTotales += distancia;
	}

	/**
	 * @return vehiculosCreados
	 */
	public static int getVehiculosCreados() {
		return vehiculosCreados;
	}

	/**
	 * @return kilometrosTotales
	 */
	public static double getKilometrosTotales() {
		return kilometrosTotales;
	}

	/**
	 * @return kilometrosRecorridos
	 */
	public double getKilometrosRecorridos() {
		return kilometrosRecorridos;
	}
}
