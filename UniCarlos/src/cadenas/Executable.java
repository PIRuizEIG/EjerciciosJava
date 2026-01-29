package cadenas;

import java.util.Scanner;

public class Executable {
	public static void main(String args[]) {

		@SuppressWarnings("resource")
		var sc = new Scanner(System.in);
		/*System.out.print("Introducir una cadena de texto: ");
		var string = sc.nextLine();
		StringClass.ShowVowels(string);*/
		/*System.out.print("Introducir la primera cadena a comparar: ");
		var string1 = sc.nextLine();
		System.out.print("Introducir la segunda cadena a comparar: ");
		var string2 = sc.nextLine();
		if (StringClass.compareStrings(string1, string2)) {
			System.out.println("Las cadenas son iguales");
		} else {
			System.out.println("Las cadenas son diferentes");
		}*/
		/*System.out.print("Introduzca palabra a buscar: ");
		var word = sc.nextLine();
		System.out.print("Introduzca la frase donde buscar: ");
		var sentence = sc.nextLine();
		StringClass.searchSubstring(sentence, word);*/
		/*System.out.print("Introduzca dirección de correo: ");
		var mail = sc.nextLine();
		StringClass.showUserDom(mail);*/
		/*System.out.print("Introduzca un nombre: ");
		var name = sc.nextLine();*/
		/*StringClass.normalize(name);
		System.out.print("Introduzca un Código Postal: ");
		var cp = sc.nextLine();
		StringClass.cleanPostalCode(cp);*/
		/*System.out.print("Introduzca frase original: ");
		System.out.println(StringClass.replaceChar(sc.nextLine(), 'a', 'e'));*/
		/*System.out.print("Introduzca frase original: ");
		System.out.println(StringClass.reverseNoSplit(sc.nextLine()));*/
		/*System.out.print("Introduzca fecha en formato dd/mm/yyyy: ");
		System.out.println(StringClass.date(sc.nextLine()));*/
		System.out.print("Introduzca altura y peso con formato altura:X.XX peso:XX.XX: ");
		System.out.println(StringClass.imc(sc.nextLine()));
	}
}
