package Example;

public class Executable {

	public static void main(String[] args) {
		var persona = new Persona("Paco", 18);
		var alumno = new Alumno("Pedro", 14, "Mat01");
		var empleado = new Empleado("Jaime", 22, 512);
		persona.imprimir();
		alumno.imprimir();
		empleado.imprimir();
	}

}
