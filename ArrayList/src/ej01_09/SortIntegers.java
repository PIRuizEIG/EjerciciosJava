package ej01_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIntegers {
	private List<Integer> intList;

	public SortIntegers() {
		intList = new ArrayList<>();
	}

	@Override
	public String toString() {
		// Crear cadena vacía
		var string = "";
		// Añadir a la cadena todos los elementos de la lista
		for (var element : intList) {
			string += element + ", ";
		}
		// Obtener longitud de la cadena final
		var len = string.length();
		// Si hay elementos en la lista, cadena mayor a 0, devolver subcadena para no
		// añadir coma final
		if (len > 0)
			return string.substring(0, len - 2);
		// Si no hay nada devolver cadena vacía
		else
			return string;
	}

	/**
	 * Añadir número a la lista
	 * 
	 * @param newValue Nuevo valor
	 */
	public void add(int newValue) {
		intList.add(newValue);
	}
	
	/**
	 * Ordenar lista
	 */
	public void sort() {
		Collections.sort(intList);
	}
}
