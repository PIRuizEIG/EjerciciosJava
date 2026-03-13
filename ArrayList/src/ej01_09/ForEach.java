package ej01_09;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
	private List<String> cityList;

	/**
	 * Crear una lista y rellenarla
	 */
	public void createList() {
		cityList = new ArrayList<String>();
		cityList.add("Madrid");
		cityList.add("Barcelona");
		cityList.add("Valencia");
	}

	public ForEach() {
		createList();
	}

	@Override
	public String toString() {
		// Crear cadena vacía
		var string = "";
		// Añadir a la cadena todos los elementos de la lista
		for (var element : cityList) {
			string += "- " + element + '\n';
		}
		// Devolver cadena
		return string;
	}
}
