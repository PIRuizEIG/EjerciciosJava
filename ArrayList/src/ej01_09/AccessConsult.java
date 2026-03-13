package ej01_09;

import java.util.ArrayList;
import java.util.List;

public class AccessConsult {
	private List<Integer> intList;

	public AccessConsult() {
		intList = new ArrayList<>();
		intList.add(85);
		intList.add(92);
		intList.add(78);
		intList.add(92);
		intList.add(95);
	}

	/**
	 * @param pos Posición a buscar
	 * @return Elemento en la posición si existe
	 */
	public int getPos(int pos) {
		if (pos < intList.size())
			return intList.get(pos);
		else {
			System.err.println("Error, fuera de rango");
			return -1;
		}
	}

	/**
	 * @param element Elemento a buscar
	 * @return True si la lista contiene el elemento
	 */
	public boolean contains(int element) {
		return intList.contains(element);
	}

	/**
	 * @param element Elemento a buscar
	 * @return Primera aparición del elemento
	 */
	public int indexOf(int element) {
		return intList.indexOf(element);
	}

	/**
	 * @param element Elemento a buscar
	 * @return Última aparición del elemento
	 */
	public int lastIndexOf(int element) {
		return intList.lastIndexOf(element);
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
		// Si hay elementos en la lista, cadena mayor a 0, devolver subcadena para no añadir coma final
		if (len > 0) return string.substring(0, len-2);
		// Si no hay nada devolver cadena vacía
		else return string;
	}
}
