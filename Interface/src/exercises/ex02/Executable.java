package exercises.ex02;

import java.util.List;

public class Executable {

	public static void main(String[] args) {
		// 1. Creamos algunos productos
        Producto p1 = new Producto("Laptop Gaming", 1200.50);
        Producto p2 = new Producto("Ratón Óptico", 4.99); // Menor que tu MIN_VALUE (5)
        Producto p3 = new Producto("Teclado Mecánico", 45.00);

        // --- PRUEBA 1: Uso como Interfaz (Polimorfismo) ---
        System.out.println("--- Prueba Interfaz (Filtro > 5.0) ---");
        Filtrable filtro = p1; // Referencia de interfaz
        
        System.out.println("¿Laptop > 5?: " + filtro.cumpleCriterio(p1)); // true
        System.out.println("¿Ratón > 5?: " + filtro.cumpleCriterio(p2));  // false
        
        // --- PRUEBA 2: Uso como Clase (Sobrecargas) ---
        System.out.println("--- Prueba Clase (Sobrecargas) ---");
        
        // Filtro por palabra clave
        boolean tienePalabra = p1.cumpleCriterio(p1, "laptop");
        System.out.println("¿'Laptop Gaming' contiene 'laptop'?: " + tienePalabra);
        
        // Filtro por rango
        boolean enRango = p1.cumpleCriterio(p3, 10.0, 50.0);
        System.out.println("¿Teclado (45.0) está entre 10 y 50?: " + enRango);

        // --- PRUEBA 3: Casos Límite (Null y tipos incorrectos) ---
        System.out.println("--- Prueba de Seguridad ---");
        System.out.println("¿Objeto null?: " + p1.cumpleCriterio(null));
        System.out.println("¿String en vez de Producto?: " + p1.cumpleCriterio("Soy un String"));
        
        // --- PRUEBA 4: Colecciones ---
        System.out.println("--- Filtrado de Lista ---");
        List<Producto> catalogo = List.of(p1, p2, p3);
        String busqueda = "Mecánico";
        
        for (Producto prod : catalogo) {
            if (p1.cumpleCriterio(prod, busqueda)) {
                System.out.println("Encontrado: " + prod);
            }
        }
	}

}
