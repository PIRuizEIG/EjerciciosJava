package Ejercicio1;

/**
 * <h1>Ejercicio 1</h1>
 * <p>
 * Implementa la clase Bicicleta, que tiene tres atributos de tipo entero:
 * </p>
 * <ul>
 * <li>velocidadActual</li>
 * <li>platoActual</li>
 * <li>piñonActual</li>
 * </ul>
 * <p>
 * Y cuatro métodos:
 * <p>
 * <ol>
 * <li>acelerar(), dobla la velocidad actual</li>
 * <li>frenar(), reduce a la mitad la velocidad actual</li>
 * <li>cambiarPlato(int plato), ajustar el plato segun parámetro recibido</li>
 * <li>cambiarPiñon (int piñon), ajustar el piñón segun parámetro recibido</li>
 * </ol>
 * <p>
 * La clase debe tener además un constructor que inicialice todos los atributos
 * </p>
 * <p>
 * Crea dos obietos de la clase bicicleta: miBicicleta y tuBicicleta
 * </p>
 * <p>
 * Creamos un array de 5 bicicletas.
 * </p>
 * <p>
 * Para la bicicleta 1: Creamos con estos datos (velocidad 14,plato 2, piñón 5).
 * Le damos acelerar hasta que sea velocidad 28, plato 1, piñón 1.
 * </p>
 * <p>
 * Para la bicicleta 2: Creamos con estos datos (velocidad 10,plato 3, piñón 3).
 * Le damos acelerar hasta que sea velocidad 40, plato 1, piñón 1.
 * </p>
 * <p>
 * Para la bicicleta 3: Creamos con estos datos (velocidad 14,plato 1, piñón 2).
 * Le damos acelerar hasta que sea velocidad 28, plato 2, piñón 1.
 * </p>
 * <p>
 * Para la bicicleta 4: Creamos con estos datos (velocidad 14,plato 2, piñón 4).
 * Le damos acelerar hasta que sea velocidad 28, plato 3, piñón 3.
 * </p>
 * <p>
 * Para la bicicleta 5: Creamos con estos datos (velocidad 14,plato 1, piñón 1).
 * Le damos acelerar hasta que sea velocidad 28, plato 3, piñón 2.
 * </p>
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Bicicleta {
	/**
	 * Cambio de velocidad
	 */
	public static final int CHANGE = 2;

	/**
	 * Velocidad Mínima
	 */
	public static final int MIN = 1;

	/**
	 * Velocidad de la bicicleta
	 */
	private int velocidadActual;

	/**
	 * Nº de plato activo
	 */
	private int platoActual;

	/**
	 * Nº de piñon activo
	 */
	private int piñonActual;

	/**
	 * Crea un objeto tipo bicicleta
	 */
	public Bicicleta() {
		this(0, 1, 1);
	}

	/**
	 * Crea un objeto tipo bicicleta con los atributos enviados
	 * 
	 * @param velocidad Velocidad actual
	 * @param plato     Plato Activo
	 * @param piñon     Piñon Activo
	 */
	public Bicicleta(int velocidad, int plato, int piñon) {
		this.velocidadActual = velocidad;
		this.platoActual = plato;
		this.piñonActual = piñon;
	}

	/**
	 * Duplica la velocidad actual
	 */
	public void acelerar() {
		if (velocidadActual <= 0)
			velocidadActual = MIN;
		else
			velocidadActual *= CHANGE;
	}

	/**
	 * Divide por dos la velocidad actual
	 */
	public void frenar() {
		if (velocidadActual <= MIN)
			velocidadActual = 0;
		else
			velocidadActual /= CHANGE;
	}

	/**
	 * Cambia el plato activo
	 * 
	 * @param plato Nuevo plato
	 */
	public void cambiarPlato(int plato) {
		platoActual = plato;
	}

	/**
	 * Cambia el piñon activo
	 * 
	 * @param piñon Nuevo piñon
	 */
	public void cambiarPiñon(int piñon) {
		piñonActual = piñon;
	}

	/**
	 * Devuelve la velocidad de la bicicleta
	 * 
	 * @return Velocidad actual
	 */
	public int devolverVelocidad() {
		return velocidadActual;
	}

	/**
	 * Devuelve el plato activo
	 * 
	 * @return Plato activo
	 */
	public int devolverPlato() {
		return platoActual;
	}

	/**
	 * Devuelve el piñon activo
	 * 
	 * @return Piñon activo
	 */
	public int devolverPiñon() {
		return piñonActual;
	}

	/**
	 * Mostrar los datos de la bicicleta
	 */
	public void mostrarInfo() {
		System.out.printf("Velocidad: %d Km/h Plato: %d Piñon:%d%n", velocidadActual, platoActual, piñonActual);
	}

	/**
	 * Devuelve un número aleatorio de 0 a 9
	 * 
	 * @return Entero aleatorio
	 */
	public static int rndInt() {
		return (int) (Math.random() * 10);
	}

	public static void pruebaVelocidad(Bicicleta bici) {
		bici.mostrarInfo();
		System.out.println("Acelerar: ");
		for (int i = 0; i < rndInt(); i++) {
			bici.acelerar();
			bici.mostrarInfo();
		}
		System.out.println("Frenar: ");
		for (int i = 0; i < rndInt(); i++) {
			bici.frenar();
			bici.mostrarInfo();
		}
		System.out.println();
	}

	public static void pruebaPP(Bicicleta bici) {
		bici.mostrarInfo();
		System.out.print("Cambiar plato: ");
		bici.cambiarPlato(rndInt());
		bici.mostrarInfo();
		System.out.print("Cambiar piñon: ");
		bici.cambiarPiñon(rndInt());
		bici.mostrarInfo();
		System.out.println();
	}

	/**
	 * Crea dos obietos de la clase bicicleta: miBicicleta y tuBicicleta
	 */
	public static void prueba() {
		var miBicicleta = new Bicicleta((int) (Math.random() * 10), 1, 1);
		var tuBicicleta = new Bicicleta();

		System.out.println("Mi Bicicleta: ");
		pruebaVelocidad(miBicicleta);
		System.out.println("Tu Bicicleta: ");
		pruebaPP(tuBicicleta);
	}

	/**
	 * Configurar bicicleta lo más cerca posible al estado deseado
	 * (La velocidad solo se puede multiplicar y dividir por 2)
	 * 
	 * @param bici      Bici a cambiar
	 * @param velocidad Velocidad objetivo
	 * @param plato     Plato Objetivo
	 * @param piñon     Piñon Objetivo
	 */
	public void configurarBici(int velocidad, int plato, int piñon) {
		System.out.print("Estado inicial: ");
		mostrarInfo();
		System.out.printf("Objetivo: Velocidad: %d Km/h Plato: %d Piñon:%d%n", velocidad, plato, piñon);

		// Ajustar velocidad
		if (devolverVelocidad() < velocidad) {
			System.out.println("Acelerar: ");
			while (devolverVelocidad() < velocidad) {
				acelerar();
				mostrarInfo();
			}
		}		
		else if (devolverVelocidad() > velocidad) {
			System.out.println("Frenar: ");
			while (devolverVelocidad() > velocidad) {
				frenar();
				mostrarInfo();
			}
		}
		
		// Ajustar Plato
		if (devolverPlato() != plato) {
			System.out.print("Cambiar plato: ");
			cambiarPlato(plato);
			mostrarInfo();
		}
		
		// Ajustar piñon
		if (devolverPiñon() != piñon) {
			System.out.print("Cambiar piñon: ");
			cambiarPiñon(piñon);
			mostrarInfo();
		}
		
		System.out.println();
	}

	/**
	 * Creamos un array de 5 bicicletas. Para la bicicleta 1: Creamos con estos
	 * datos (velocidad 14,plato 2, piñón 5). Le damos acelerar hasta que sea
	 * velocidad 28, plato 1, piñón 1.
	 * 
	 * Para la bicicleta 2: Creamos con estos datos (velocidad 10,plato 3, piñón 3).
	 * Le damos acelerar hasta que sea velocidad 40, plato 1, piñón 1.
	 * 
	 * Para la bicicleta 3: Creamos con estos datos (velocidad 14,plato 1, piñón 2).
	 * Le damos acelerar hasta que sea velocidad 28, plato 2, piñón 1.
	 * 
	 * Para la bicicleta 4: Creamos con estos datos (velocidad 14,plato 2, piñón 4).
	 * Le damos acelerar hasta que sea velocidad 28, plato 3, piñón 3.
	 * 
	 * Para la bicicleta 5: Creamos con estos datos (velocidad 14,plato 1, piñón 1).
	 * Le damos acelerar hasta que sea velocidad 28, plato 3, piñón 2.
	 */
	public static void array() {
		Bicicleta bicis[] = {
			new Bicicleta(14, 2, 5),
			new Bicicleta(10, 3, 3),
			new Bicicleta(14, 1, 2),
			new Bicicleta(14, 2, 4),
			new Bicicleta(14, 1, 1)
		};

		System.out.println("Bicicleta 1: ");
		bicis[0].configurarBici(28, 1, 1);

		System.out.println("Bicicleta 2: ");
		bicis[1].configurarBici(40, 1, 1);

		System.out.println("Bicicleta 3: ");
		bicis[2].configurarBici(28, 2, 1);

		System.out.println("Bicicleta 4: ");
		bicis[3].configurarBici(28, 3, 3);

		System.out.println("Bicicleta 5: ");
		bicis[4].configurarBici(28, 3, 2);
	}

	public static void main(String args[]) {
		prueba();
		array();
	}
}
