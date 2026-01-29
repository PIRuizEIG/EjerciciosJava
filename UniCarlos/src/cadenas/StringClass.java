package cadenas;

/**
 * <h1>1. Contar vocales en una frase</h1>
 * <p>
 * Pide por teclado una frase y muestra:
 * <ul>
 * <li>La longitud de la frase.</li>
 * <li>Cuántas vocales (a, e, i, o, u) contiene, sin distinguir mayúsculas y
 * minúsculas.</li>
 * </ul>
 * <p>
 * Pistas técnicas:
 * <ul>
 * <li>Usa length() para saber cuántos caracteres tiene la cadena.</li>
 * <li>Recorre la cadena con un for usando charAt(i) para obtener cada carácter.
 * </li>
 * </ul>
 * Convierte la frase a minúsculas con toLowerCase() para simplificar la
 * comparación. *
 * <h1>2. Comprobar si dos palabras son iguales (ignorando mayúsculas)</h1>
 * <p>
 * Pide dos palabras y muestra un mensaje indicando si son iguales sin tener en
 * cuenta mayúsculas/minúsculas.
 * <p>
 * Pistas técnicas:
 * <ul>
 * <li>Usa equals() para comparar de forma sensible a mayúsculas.</li>
 * <li>Para ignorar mayúsculas, puedes:</li>
 * <li>Convertir ambas palabras a minúsculas con toLowerCase() y luego usar
 * equals(), o</li>
 * <li>Convertir ambas a mayúsculas con toUpperCase() y luego usar equals().
 * </li>
 * </ul>
 * <h1>3. Buscar una subcadena dentro de una frase</h1>
 * <p>
 * Pide por teclado:
 * <ul>
 * <li>Una frase completa.</li>
 * <li>Una palabra a buscar dentro de esa frase.</li>
 * </ul>
 * <p>
 * Muestra:
 * <ul>
 * <li>La posición donde aparece por primera vez esa palabra (o un mensaje si no
 * aparece).</li>
 * <li>Un mensaje adicional si la palabra aparece más de una vez.</li>
 * </ul>
 * <p>
 * Pistas técnicas:
 * <ul>
 * <li>Usa indexOf(subcadena) para localizar la primera aparición (devuelve -1
 * si no se encuentra).</li>
 * <li>Usa la sobrecarga indexOf(subcadena, desdeIndice) para buscar a partir de
 * una posición y detectar más apariciones.</li>
 * </ul>
 * <h1>4. Extraer nombre y dominio de un correo</h1>
 * <p>
 * Pide una dirección de correo sencilla, por ejemplo: usuario@dominio.com
 * <p>
 * Muestra por pantalla:
 * <ul>
 * <li>El nombre de usuario (lo que hay antes de @).</li>
 * <li>El dominio (lo que hay después de @).</li>
 * </ul>
 * <p>
 * Pistas técnicas: Localiza la posición de @ con indexOf("@").
 * <ul>
 * <li>Usa substring(0, posicionArroba) para el usuario..</li>
 * <li>Usa substring(posicionArroba + 1) para el dominio.</li>
 * </ul>
 * <h1>5. Normalizar y formatear un nombre completo</h1>
 * <p>
 * Pide por teclado un nombre y dos apellidos con espacios "raros", por ejemplo:
 * " juAn péRez gÓmez ".
 * <p>
 * El programa debe:
 * <ul>
 * <li>Eliminar espacios al principio y al final con trim().</li>
 * <li>Convertir todo a minúsculas con toLowerCase().</li>
 * <li>Extraer nombre y apellidos usando substring() y indexOf(" ") (buscando
 * los espacios intermedios).</li>
 * <li>Reconstruir una cadena en formato: "PÉREZ GÓMEZ, JUAN" usando
 * toUpperCase() sobre los apellidos y concat o + para unir las partes.</li>
 * </ul>
 * <h1>6. Validar y limpiar un código postal</h1>
 * <p>
 * Pide por teclado un código postal que puede tener espacios y letras en
 * mayúsculas o minúsculas, por ejemplo: " 28001 " o " cp-28001 ".
 * <p>
 * El programa debe:
 * <ul>
 * <li>Eliminar espacios al principio y al final con trim().</li>
 * <li>Verificar si contiene el prefijo "cp-" o "CP-" usando indexOf() o
 * comparando con substring().</li>
 * <li>Si tiene el prefijo, extraerlo usando substring() para quedarse solo con
 * los números.</li>
 * <li>Convertir el resultado final a mayúsculas con toUpperCase(). Mostrar el
 * código postal limpio y validado.</li>
 * </ul>
 * <p>
 * Pistas técnicas:
 * <ul>
 * <li>Usa trim() primero para eliminar espacios.</li>
 * <li>Usa toLowerCase() para facilitar la búsqueda del prefijo "cp-".</li>
 * <li>Usa indexOf("cp-") para verificar si existe el prefijo (devuelve 0 si
 * está al inicio).</li>
 * <li>Usa substring() para extraer la parte numérica después del prefijo.</li>
 * <li>Usa toUpperCase() al final si quieres el resultado en mayúsculas.</li>
 * </ul>
 * 
 * <h1>6. Número palabras y sustitución</h1> Diseña un programa en Java que lea
 * una frase por teclado y cuente el número de palabras que contiene
 * (considerando que las palabras están separadas por uno o más espacios).
 * Muestra el resultado y la frase con todas las 'a' reemplazadas por 'e'. Por
 * ejemplo, para "Hola mundo Java", debe contar 3 palabras y mostrar `"Hole
 * mundo Jeve".
 * <h1>7. Frase Inversa</h1> Diseña un programa en Java que, dada una frase
 * introducida por teclado, construya y muestre otra cadena que contenga las
 * palabras de la frase original en orden inverso, manteniendo las letras de
 * cada palabra en su orden correcto. Por ejemplo, para la entrada "Siempre se
 * puede aprender Java", la salida deberá ser `"Java aprender puede se Siempre".
 * <h1>8. Fecha descompuesta</h1> Diseña un programa en Java que lea una cadena
 * por teclado representando una fecha en formato "dd/mm/yyyy" (ej.
 * "15/01/2026") y la descomponga en tres partes: día, mes y año. Muestra cada
 * parte por separado y verifica si el día es mayor que 15 (sin usar split ni
 * regex).
 * <h1>9. Convierte alturas y pesos</h1> Diseña un programa en Java que lea por
 * teclado una cadena con medidas en formato "altura:1.75 peso:70.5" (valores
 * reales separados por ":" y " "), extraiga las subcadenas numéricas
 * manualmente (sin split/regex), conviértalas a double con
 * Double.parseDouble(), calcule el IMC (peso/altura²), clasifícalo según rangos
 * (bajo: <18.5, normal:18.5-24.9, sobrepeso:25-29.9, obeso:≥30) y muestre el
 * resultado con mensaje descriptivo. Maneja errores de formato con try-catch
 * tras la conversión como se muestra en el ejemplo del parseDouble()
 * <h2>Autor: Pablo Illecas</h2>
 */
public class StringClass {
	/**
	 * Contar vocales en una frase
	 * 
	 * @param string Frase a analizar
	 */
	public static void ShowVowels(String string) {
		var len = string.length();
		int vowels = 0;
		for (int i = 0; i < len; i++) {
			if (string.toLowerCase().charAt(i) == 'a' || string.toLowerCase().charAt(i) == 'e'
					|| string.toLowerCase().charAt(i) == 'i' || string.toLowerCase().charAt(i) == 'o'
					|| string.toLowerCase().charAt(i) == 'u')
				vowels++;
		}
		System.out.printf("La cadena %s de longitud %d tiene %d vocales%n", string, len, vowels);
	}

	/**
	 * Comparar frases
	 * 
	 * @param s1 Frase 1
	 * @param s2 Frase 2
	 * @return True si son iguales
	 */
	public static boolean compareStrings(String s1, String s2) {
		return s1.trim().toLowerCase().equals(s2.trim().toLowerCase());
	}

	/**
	 * Buscar palabra en una frase
	 * 
	 * @param string Frase donde buscar
	 * @param word   Palabra a buscar
	 */
	public static void searchSubstring(String string, String word) {
		var index = string.toLowerCase().indexOf(word.toLowerCase());
		if (index < 0)
			System.out.printf("La palabra %s no aparece en la frase %s%n", word, string);
		else {
			System.out.printf("La palabra %s aparece en la posición %d", word, index);
			int amount = 0;
			while (index >= 0) {
				index += word.length();
				index = string.toLowerCase().indexOf(word.toLowerCase(), index);
				amount++;
			}
			System.out.printf(" y aparece %d veces.%n", amount);
		}
	}

	/**
	 * Buscar el usuario y el dominio en una dirección de email
	 * 
	 * @param mail Cadena con el email
	 */
	public static void showUserDom(String mail) {
		var index = mail.indexOf('@');
		if (index < 0) {
			System.out.println("No es una dirección válida");
			return;
		}
		var usr = mail.substring(0, index);
		var dom = mail.substring(index + 1);
		System.out.printf("Usuario: %s Dominio: %s%n", usr, dom);
	}

	/**
	 * Normaliza y formatea un nombre
	 * 
	 * @param name Nombre a formatear
	 */
	public static void normalize(String name) {
		name = name.trim().toLowerCase();
		var index = name.indexOf(' ');
		if (index < 0) {
			System.out.println("No es un nombre completo");
			return;
		}
		var firstName = name.substring(0, index++);
		name = name.substring(index);
		index = name.indexOf(' ');
		if (index < 0) {
			System.out.println("Solo contiene un apellido:");
			System.out.printf("%s, %s%n", name.toUpperCase(), firstName.toUpperCase());
			return;
		}
		var lastName = name.substring(0, index++);
		name = name.substring(index);
		System.out.printf("%s %s, %s%n", lastName.toUpperCase(), name.toUpperCase(), firstName.toUpperCase());
	}

	/**
	 * Limpiar Código postal
	 * 
	 * @param code cp a limpiar
	 */
	public static void cleanPostalCode(String code) {
		code = code.toLowerCase().trim();
		var index = code.indexOf("cp-");
		if (index >= 0)
			code = code.substring(index + 3);
		System.out.println(code);
	}

	/**
	 * Reemplazar caracter
	 * 
	 * @param s    Frase
	 * @param oldC Caracter a reemplazar
	 * @param newC Nuevo caracter
	 * @return
	 */
	public static String replace(String s, char oldC, char newC) {
		String returnString = new String();

		for (int i = 0; i < s.length(); i++) {
			var c = s.charAt(i);
			if (c == oldC)
				returnString.concat(Character.toString(newC));
			else
				returnString.concat(Character.toString(c));
		}

		return returnString;
	}

	/**
	 * Reemplazar caracter
	 * 
	 * @param s    Frase
	 * @param oldC Caracter a reemplazar
	 * @param newC Nuevo caracter
	 * @return
	 */
	public static String replaceChar(String s, char oldC, char newC) {
		return s.replace(Character.toLowerCase(oldC), Character.toLowerCase(newC)).replace(Character.toUpperCase(oldC),
				Character.toUpperCase(newC));
	}

	/**
	 * Reordena las palabras de un String
	 * 
	 * @param s Cadena original
	 * @return Cadena Invertida
	 */
	public static String reverseString(String s) {
		var stringArray = s.split(" ");
		String returnString = new String();
		for (var i = stringArray.length - 1; i >= 0; i--) {
			returnString = returnString.concat(stringArray[i]).concat(" ");
		}
		return returnString;
	}

	/**
	 * Reordena las palabras de un String
	 * 
	 * @param s Cadena original
	 * @return Cadena Invertida
	 */
	public static String reverseNoSplit(String s) {
		// Buscamos el último espacio
		var index = s.lastIndexOf(' ');

		// Si no hay espacio o está en el primer valor devolvemos la frase original
		if (index <= 0)
			return s;

		// La primera palabra es la que aparece tras el último espacio
		String returnString = s.substring(index + 1);

		// Mientras el indice sea mayor a 0
		while (index > 0) {
			// Guardamos la posición del espacio anterior
			var oldIndex = index;
			// Buscamos el siguente espacio a partir del espacio anterior
			index = s.lastIndexOf(' ', oldIndex - 1);
			// Si no es la última palabra la siguiente palabra está localizada entre el
			// espacio anterior y el actual
			if (index > 0)
				returnString = returnString.concat(s.substring(index, oldIndex));
			// Si es la última palabra añadimos todo el contenido desde el princio hasta el
			// primer espacio
			else
				returnString = returnString.concat(" ").concat(s.substring(0, oldIndex));
		}

		return returnString;
	}

	/**
	 * Descomponer fecha
	 * 
	 * @param s Fecha original
	 * @return Fecha en nuevo formato
	 */
	public static String date(String s) {
		// Primer separador
		var dIndex = s.indexOf('/');

		if (dIndex <= 0)
			return "Formato Incorrecto, se espera dd/mm/yyyy";

		// Intentamos obtener el día
		int day;

		try {
			day = Integer.parseInt(s.substring(0, dIndex));
		} catch (NumberFormatException e) {
			/* Código a ejecutar si no se puede convertir */
			return "Formato Incorrecto, se espera dd/mm/yyyy";
		}

		if (day > 31 || day <= 0)
			return "Formato Incorrecto, se espera dd/mm/yyyy";

		// Segundo separador
		var mIndex = s.indexOf('/', ++dIndex);

		// Intentamos obtener el mes
		int month;

		if (mIndex <= 0)
			return "Formato Incorrecto, se espera dd/mm/yyyy";

		try {
			month = Integer.parseInt(s.substring(dIndex, mIndex));
		} catch (NumberFormatException e) {
			/* Código a ejecutar si no se puede convertir */
			return "Formato Incorrecto, se espera dd/mm/yyyy";
		}

		if (month > 12 || month <= 0)
			return "Formato Incorrecto, se espera dd/mm/yyyy";

		// Intentamos obtener el año
		int year;

		try {
			year = Integer.parseInt(s.substring(++mIndex));
		} catch (NumberFormatException e) {
			/* Código a ejecutar si no se puede convertir */
			return "Formato Incorrecto, se espera dd/mm/yyyy";
		}

		// Comprobamos si el día es superior a 15 y devolvemos fecha en nuevo formato

		if (day > 15)
			return String.format("Segunda Mitad del mes. Día: %d Mes: %d Año:%d%n", day, month, year);

		else
			return String.format("Primera Mitad del mes. Día: %d Mes: %d Año:%d%n", day, month, year);
	}

	/**
	 * Calcular IMC
	 * 
	 * @param s Altura y peso
	 * @return Resultado
	 */
	public static String imc(String s) {

		// Obtener altura

		var index1 = s.indexOf(':');
		var index2 = s.indexOf(' ');

		if (index1 <= 0 || index2 <= 0)
			return "Formato Incorrecto, se espera altura:X.XX peso:XX.XX";

		double height;

		try {
			height = Double.parseDouble(s.substring(++index1, index2));
		} catch (NumberFormatException e) {
			/* Código a ejecutar si no se puede convertir */
			return "Formato Incorrecto, se espera altura:X.XX peso:XX.XX";
		}

		// Obtener peso

		index1 = s.indexOf(':', index1);

		if (index1 <= 0)
			return "Formato Incorrecto, se espera altura:X.XX peso:XX.XX";

		double weight;

		try {
			weight = Double.parseDouble(s.substring(++index1));
		} catch (NumberFormatException e) {
			/* Código a ejecutar si no se puede convertir */
			return "Formato Incorrecto, se espera altura:X.XX peso:XX.XX";
		}

		var imc = weight / Math.pow(height, 2);

		double low = 18.5;
		double avg = 25;
		double over = 30;

		String desc;

		if (imc < low)
			desc = "Bajo";
		else if (imc < avg)
			desc = "Normal";
		else if (imc < over)
			desc = "Sobrepeso";
		else
			desc = "Obeso";

		return String.format("Altura: %.2f Peso: %.2f IMC: %.2f %s %n", height, weight, imc, desc);
	}
}
