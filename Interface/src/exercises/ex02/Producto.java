package exercises.ex02;

public class Producto implements Filtrable {
	/** Valor mínimo comprobación por defecto */
	public static final double MIN_VALUE = 5;
	/** Nombre del producto */
	private String nombre;
	/** Precio del producto */
	private double precio;

	/**
	 * Crear producto con nombre y precio concretos
	 * 
	 * @param nombre Nombre del producto
	 * @param precio Precio del producto
	 */
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		if (precio < 0)
			throw new IllegalArgumentException("Precio debe ser positivo.");
		this.precio = precio;
	}

	/** Comprueba si se cumple el críterio por defecto (Precio mayor a 5 €) */
	@Override
	public boolean cumpleCriterio(Object o) {
		//var p = convert(o);
		// O cumple criterio si su precio es mayor al mínimo de la clase
		//return p != null && p.precio > MIN_VALUE;
		if (o instanceof Double minValue) {
			return precio >= minValue;
		}
		
		if (o instanceof String filter) {
			return compruebaCriterio(filter);
		}
		
		if (o instanceof Double[] array) {
			if (array.length != 2) return false;
			if (array[0] <= array[1])	return compruebaCriterio(array[0], array[1]);
			else return compruebaCriterio(array[1], array[0]);
		}
		
		return false;
	}

	/**
	 * Comprueba si el objeto recibido es un producto con la palabra clave
	 * 
	 * @param o       Objeto a comprobar
	 * @param keyword Palabra clave a buscar
	 * @return True si O es un Producto con la palabra clave
	 */
	public boolean cumpleCriterio(Object o, String keyword) {
		var p = convert(o);
		// O cumple criterio si la palabra clave esta contenida en el nombre
		return p != null && p.compruebaCriterio(keyword);
	}

	/**
	 * Comprueba si el objeto recibido es un producto en un rango de precios
	 * concreto
	 * 
	 * @param o   Objeto a comprobar
	 * @param min Precio mínimo
	 * @param max Precio máximo
	 * @return True si O es un Producto con precio en el rango correcto
	 */
	public boolean cumpleCriterio(Object o, double min, double max) {
		var p = convert(o);
		// O cumple criterio si su precio esta en el rango de precios
		return p != null && p.compruebaCriterio(min, max);
	}

	/**
	 * Convertir objeto o a producto si es un producto
	 * 
	 * @param o Objeto original
	 * @return Null si no es producto
	 */
	private Producto convert(Object o) {
		if (o instanceof Producto p)
			return p;
		return null;
	}

	/**
	 * Comprueba si el objeto recibido es un producto con la palabra clave
	 * 
	 * @param keyword Palabra clave a buscar
	 * @return True si O es un Producto con la palabra clave
	 */
	public boolean compruebaCriterio(String keyword) {
		// Si la palabra clave está vacía no se puede cumplir el criterio
		if (keyword == null || keyword.isBlank())
			return false;
		// O cumple criterio si la palabra clave esta contenida en el nombre
		return nombre.toLowerCase().contains(keyword.toLowerCase());
	}

	/**
	 * Comprueba si el objeto recibido es un producto en un rango de precios
	 * concreto
	 * 
	 * @param min Precio mínimo
	 * @param max Precio máximo
	 * @return True si O es un Producto con precio en el rango correcto
	 */
	public boolean compruebaCriterio(double min, double max) {
		// O cumple criterio si su precio esta en el rango de precios
		return precio >= min && precio <= max;
	}

	@Override
	public String toString() {
		return String.format("%s: %.2f €", nombre, precio);
	}
}
