package ej01_09;

import java.util.Random;

/**
 * Enumerable de palos de baraja española con función de cartas aleatorias
 */
public enum Palos {
	Bastos, Copas, Espadas, Oros;
	
	/**
	 * Número de carta más alto
	 */
	private static final int MAX = 10;
	
	/**
	 * Random para valores aleatorios
	 */
	private static final Random PRNG = new Random();

	/**
	 * @return Palo aleatorio
	 */
    public static Palos rndPalo()  {
    	Palos[] palos = values();
        return palos[PRNG.nextInt(palos.length)];
    }
    
    /**
     * @return Número de carta aleatorio
     */
    public static int rndNum() {
    	return PRNG.nextInt(MAX) + 1;
    }
}
