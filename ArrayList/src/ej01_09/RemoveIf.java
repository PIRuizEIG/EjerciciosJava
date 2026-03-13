package ej01_09;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {
	private List<Double> doubleList;

	/**
	 * Crear una lista y rellenarla
	 */
	public void createList() {
		doubleList = new ArrayList<>();
		doubleList.add(10.5);
		doubleList.add(22.3);
		doubleList.add(5.0);
		doubleList.add(30.1);
		doubleList.add(15.8);
		doubleList.add(5.0);
	}

	public RemoveIf() {
		createList();
	}

	@Override
	public String toString() {
		// Crear cadena vacía
		var string = "";
		// Añadir a la cadena todos los elementos de la lista
		for (var element : doubleList) {
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
	 * Elimina todos los números menores al pasado
	 * 
	 * @param min Valor límite
	 */
	public void removeIf(double min) {
		doubleList.removeIf(number -> number <= min);
	}
}
