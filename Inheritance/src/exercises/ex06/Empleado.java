package exercises.ex06;

public class Empleado extends Persona {
	private double salario;

	public Empleado(String nombre, int edad, double salario) {
		super(nombre, edad);
		this.salario = salario;
	}
	// 1. Añade aquí el método imprimir() para Empleado
	// @Override
	// public void imprimir() {
	// ...tu código aquí
	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		super.imprimir();
		System.out.println("Salario: " + salario);
	}
}
