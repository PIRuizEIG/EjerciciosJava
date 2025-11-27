package ejercicio34;

import java.util.Scanner;

public class ChangeNumbers {

	// Atributos
	private int numero[] = new int [30];
	

	// Método que carga el array con valores aleatorios
	
	public void cargarArray() {
		for (int i = 0; i < numero.length; i++) {
			numero[i] = (int) (Math.random() * 21);
		}
	}
	
	
	//Método para mostrar los números aleatorios
	
	public void mostrarNumeros() {
		for (int i = 0; i < numero.length; i++) {
			System.out.print(numero[i] + " ");
		}
		System.out.println();
	}
	
	
	//Método para sustituir, recorrer el array y cambiar el número y lo muestra.
	
	public void sustituirYMostrar() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Introduce el número que quieres reemplazar: ");
		int numeroASustituir = keyboard.nextInt();
		System.out.print("Introduce el nuevo número por el que será reemplazado el anterior: ");
		int nuevoNumero = keyboard.nextInt();
		for (int i = 0; i < numero.length; i++) {
			if (numeroASustituir == numero[i]) {
				numero[i] = nuevoNumero;
				System.out.print("\"" + numero[i] + "\" ");
			}
			else {
				System.out.print(numero[i] + " ");
			}
		}
		
	}


	public static void main(String[] args) {
		
		ChangeNumbers numeros = new ChangeNumbers();
		numeros.cargarArray();
		numeros.mostrarNumeros();
		numeros.sustituirYMostrar();
		

	}

}