package exercises.ex01;

/** Crea un objeto tipo TareaSimple y otro ProcesadorDeDatos y los ejecuta */
public class Executable {

	public static void main(String[] args) {
		Ejecutable simple = new TareaSimple();
		Ejecutable process = new ProcesadorDeDatos();
		simple.ejecutar();
		process.ejecutar();
	}

}
