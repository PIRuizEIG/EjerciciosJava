package exercises.ex01;

import java.time.LocalDate;

public class TareaSimple implements Ejecutable {

	/** Muestra cuando se ha ejecutado el programa */
	@Override
	public void ejecutar() {
		System.out.printf("Aplicacion ejecutada el día %s.%n", LocalDate.now());
	}
}
