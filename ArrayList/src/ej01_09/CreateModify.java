package ej01_09;

import java.util.ArrayList;
import java.util.List;

public class CreateModify {
	private List<String> languajeList;
	
	/**
	 * Crear una lista y rellenarla
	 */
	public void createList() {
		languajeList = new ArrayList<String>();
		languajeList.add("Java");
		languajeList.add("Python");
		languajeList.add("C++");
		languajeList.add("JavaScript");
	}
	
	/**
	 * Modificar el segundo elemento
	 */
	public void modifyList() {
		languajeList.set(2, "C#");
	}
	
	@Override
	public String toString() {
		// Crear cadena vacía
		var string = "";
		// Añadir a la cadena todos los elementos de la lista
		for (var element : languajeList) {
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
