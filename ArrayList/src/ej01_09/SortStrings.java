package ej01_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortStrings {
	private List<String> stringList;

	public SortStrings() {
		stringList = new ArrayList<>();
	}

	@Override
	public String toString() {
		// Crear cadena vacía
		var string = "\"";
		// Añadir a la cadena todos los elementos de la lista
		for (var element : stringList) {
			string += element + ", ";
		}
		// Obtener longitud de la cadena final
		var len = string.length();
		// Si hay elementos en la lista, cadena mayor a 0, devolver subcadena para no
		// añadir coma final
		if (len > 0)
			return (string.substring(0, len - 2) + "\"");
		// Si no hay nada devolver cadena vacía
		else
			return string  + "\"";
	}
	
	/**
	 * Añadir cadenas a la lista
	 * 
	 * @param newString Nuevo valor
	 */
	public void add(String newString) {
		stringList.add(newString);
	}
	
	/**
	 * Ordenar lista
	 */
	public void sort() {
		Collections.sort(stringList);
	}
}
