package exercises.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ProcesadorDeDatos implements Ejecutable {
	/** Lista de enteros */
	ArrayList<Integer> list = new ArrayList<>();

	/** Crear un objeto con una lista de 10 enteros aleatorios */
	public ProcesadorDeDatos() {
		var rnd = new Random();
		for (int i = 0; i < 10; i++)
			list.add(rnd.nextInt());
	}

	/** Mostrar lista de enteros */
	private static void printList(ArrayList<Integer> list) {
		for (var n : list)
			System.out.print(n + " ");
		System.out.println();
	}

	/**
	 * Muestra el contenido de la lista desordenada, la ordena y la muestra tras
	 * ordenar
	 */
	@Override
	public void ejecutar() {
		printList(list);
		Collections.sort(list);
		printList(list);
	}
}
