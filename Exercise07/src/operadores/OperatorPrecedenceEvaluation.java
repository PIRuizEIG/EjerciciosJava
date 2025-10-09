package operadores;
/* Evalúa la expresión 10 - 2 * 3 + 4 > 12 && 6 / 2 < 4 || !(7 % 2 == 1) 
 * y muestra el resultado booleano. 
 * Incluye explicación paso a paso en comentarios del orden en que se 
 * evalúan los operadores y resultados parciales.
 * Autor: Pablo Illescas
 */
public class OperatorPrecedenceEvaluation {
	public static void main(String[] args) {
		boolean value;
		value = 10 - 2 * 3 + 4 > 12 && 6 / 2 < 4 || !(7 % 2 == 1);
		/* Primero se realizan los calculos entre parentesis, dentro tiene prioridad
		 * modulo 7 % 2, que da 1, 1 == 1 es true que con el prefijo se vuelve falso. 
		 * 10 - 2 * 3 + 4 > 12 && 6 / 2 < 4 || false
		 * Sin parentesis se sigue con multiplicaciones y divisiones
		 * 10 - 6 + 4 > 12 && 3 < 4 || false
		 * Seguimos con sumas y restas
		 * 8 > 12 && 3 < 4 || false
		 * Hacemos las operaciones lógicas
		 * false && true || false
		 * false || false
		 * Resultado false
		 */
		System.out.printf("Resultado final: %b%n", value);
	}
}
