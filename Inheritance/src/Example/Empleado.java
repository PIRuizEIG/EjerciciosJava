package Example;

public class Empleado extends Persona {
	@SuppressWarnings("unused")
	private double salario;

	public Empleado(String nombre, int edad, double salario) {
		super(nombre, edad);
		this.salario = salario;
	}
}
