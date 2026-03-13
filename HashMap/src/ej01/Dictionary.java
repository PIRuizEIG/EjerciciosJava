package ej01;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase auxiliar que contiene los usuarios del ejercicio 1
 */
public class Dictionary {
	/**
	 * Diccionario de usuarios para control de acceso
	 */
	Map<String, String> users = new HashMap<>();

	/**
	 * Crear HashMap con la lista de usuarios predeterminada
	 */
	public Dictionary() {
		users.put("Paco", "1234");
		users.put("Susana", "password");
		users.put("David", "contraseña");
		users.put("Lusia", "1234");
	}

	/**
	 * Comprobar si la contraseña del usuario es correcta
	 * 
	 * @param user     Usuario a comprobar
	 * @param password Contraseña con la que comprobar
	 * @return True si la contraseña es la correcta
	 */
	public Boolean checkPassword(String user, String password) {
		// Si el usuario no está en memoria no es correcta la contraseña
		if (!users.containsKey(user))
			return false;
		// True si la contraseña en memoria es igual a la recibida
		return users.get(user).equals(password);
	}
}
