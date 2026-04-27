package Example;

public class Alumno extends Persona {
	private String matricula;

	public Alumno(String nombre, int edad, String matricula) {
		super(nombre, edad);
		this.matricula = matricula;
	}

	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Matrícula: " + matricula);
	}
}
