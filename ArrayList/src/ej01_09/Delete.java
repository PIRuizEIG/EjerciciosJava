package ej01_09;

import java.util.ArrayList;
import java.util.List;

public class Delete {

	private List<String> cityList;

	/**
	 * Crear una lista y rellenarla
	 */
	public void createList() {
		cityList = new ArrayList<String>();
		cityList.add("Madrid");
		cityList.add("Barcelona");
		cityList.add("Valencia");
		cityList.add("Sevilla");
		cityList.add("Bilbao");
	}

	public Delete() {
		createList();
	}

	@Override
	public String toString() {
		// Crear cadena vacía
		var string = "";
		// Añadir a la cadena todos los elementos de la lista
		for (var element : cityList) {
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
	 * Eliminar elemento en la posicion
	 * 
	 * @param pos Posición a eliminar
	 */
	public void remove(int pos) {
		// Si el elemento no está en la lista salir
		if (pos >= cityList.size()) {
			System.err.println("Error, el elemento no existe.");
			return;
		}
		// Eliminar elemento
		cityList.remove(pos);
	}

	/**
	 * Eliminar elemento por valor
	 * 
	 * @param element Elemento a eliminar
	 */
	public void remove(String element) {
		// Si el elemento está en la lista eliminarlo
		if (cityList.contains(element))
			cityList.remove(element);
		// Si no existe avisar
		else
			System.err.println("Error, el elemento no existe.");
	}
}
