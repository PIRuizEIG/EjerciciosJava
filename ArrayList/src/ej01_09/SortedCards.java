package ej01_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedCards {
	/**
	 * Lista de cartas
	 */
	private List<Carta> cardList;
	
	/**
	 * Tamaño de la lista a generar
	 */
	private static final int SIZE = 10;

	/**
	 * Generar lista de cartas aleatorioas
	 */
	public SortedCards() {
		fillList();
	}

	@Override
	public String toString() {
		// Crear cadena vacía
		var string = "";
		// Añadir a la cadena todos los elementos de la lista
		for (var element : cardList) {
			string += "- " + element + '\n';
		}
		// Devolver cadena
		return string;
	}

	/**
	 * @return Carta aleatoria
	 */
	public static Carta getRandom() {
		return new Carta(Palos.rndPalo(), Palos.rndNum());
	}

	/**
	 * Llenar la lista
	 */
	public void fillList() {
		// Crear lista
		cardList = new ArrayList<>();
		// Mientras la cantidad de cartas sea inferior a SIZE
		while (cardList.size() < SIZE) {
			// Generar carta
		    Carta newCard = getRandom();
		    // Si la nueva carta no está en la lista se añade
		    if (!cardList.contains(newCard)) {
		        cardList.add(newCard);
		    }
		}
	}
	
	/**
	 * Ordenar la lista
	 */
	public void sortList() {
		Collections.sort(cardList);
	}
}
