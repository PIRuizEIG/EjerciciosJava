package ManagerDataUser;
import java.util.Scanner;

/* Cree un programa que:
 * 1. Lea con Scanner: o Nombre completo (línea completa) o Edad (int) o
 *     Estatura en metros (float) o Peso en kg (float)
 * 2. Calcule el Índice de Masa Corporal (IMC) = peso / (estatura^2)
 * 3. Indique el rango: Bajo peso, Peso normal, Sobrepeso u Obesidad según el IMC
 * 4. Calcule año aproximado de nacimiento (año actual = 2025)
 * 5. Muestre todos los datos y resultados formateados usando System.out.print
 * Autor: Pablo Illescas
 */

public class CalculationIMC {
	public static void main(String[] args) {
		// Iniciar Scanner
		Scanner sc = new Scanner(System.in);
		
		// Intrducir datos Nombre, Edad, Estatura y Peso
		System.out.println("Introduzca su nombre completo");
		String nombre = sc.nextLine();
		System.out.println("Introduzca su edad");
		int edad = sc.nextInt();
		System.out.println("Introduzca su Altura en metros");
		float altura = sc.nextFloat();
		System.out.println("Introduzca su Peso en kilogramos");
		float peso = sc.nextFloat();
		
		// Calcular IMC = peso / (estatura ^2)
		float imc = peso / (altura + altura);
		
		// Indicar Bajo peso, Peso normal, Sobrepeso u Obesidad según el IMC
		// 18.5 25 30
		String rango;
		if (imc < 18.5)
		{
			rango = "Bajo peso";
		}
		else if (imc < 25)
		{
			rango = "Peso normal";
		}
		else if (imc < 30)
		{
			rango = "Sobrepeso";
		}
		else
		{
			rango = "Obesidad";
		}
		
		// Calcule año aproximado de nacimiento (año actual = 2025)
		int ano = 2025 - edad;
		
		// Muestre todos los datos y resultados formateados usando System.out.printf
		System.out.printf("Nombre: %s Edad: %d Altura: %.3f m Peso: %.3f Kg Rango de peso: %s Año de nacimiento: %d",
				nombre, edad, altura, peso, rango, ano);
		
		// Cerrar Scanner
		sc.close();
	}
}
