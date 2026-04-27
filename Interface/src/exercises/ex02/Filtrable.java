package exercises.ex02;

/**
 * <h1>Ejercicio 2: Filtrado Personalizado</h1> Define una interfaz Filtrable
 * con un método `cumpleCriterio(Object o)`. Crea una clase `Producto` con
 * atributos como nombre y precio. Implementa Filtrable en `Producto` para que
 * `cumpleCriterio` pueda filtrar productos, por ejemplo, por un rango de precio
 * o si su nombre contiene una palabra clave.
 * <h2>Autor: Pablo Illescas</h2>
 * 
 */
public interface Filtrable {
	public boolean cumpleCriterio(Object o);
}
