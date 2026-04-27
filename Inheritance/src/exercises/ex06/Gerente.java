package exercises.ex06;

public class Gerente extends Empleado {
	
	private String departamento;

	public Gerente(String nombre, int edad, double salario, String departamento) {
		super(nombre, edad, salario);
		this.departamento = departamento;
	}
	// 2. Define el atributo 'departamento'
	// 3. Implementa el constructor para Gerente
	// 4. Sobrescribe el método imprimir() para Gerente
	// ... tu código aquí ...
	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		super.imprimir();
		System.out.println("Departamento: " + departamento);
	}
}