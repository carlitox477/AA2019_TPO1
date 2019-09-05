package TPO_01;

public class Ordenamiento {

	/**
	 * Metodo de ordenamiento Burbuja.
	 *
	 * Funciona revisando cada elemento de la lista que va a ser ordenada con el
	 * siguiente, intercambiandolos de posicion si estan en el orden equivocado Es
	 * necesario revisar varias veces toda la lista hasta que no se necesiten mÃ¡s
	 * intercambios, lo cual significa que la lista estÃ¡ ordenada.
	 *
	 * Tiempo de ejecucion del algoritmo burbuja:
	 *
	 * Para el mejor caso (un paso) O(n) | Peor caso n(n-1)/2 | Promedio O(n²)
	 *
	 * @param a Pre: array de enteros desordenado. Post: array ordenado
	 */
	public static void burbuja(int[] a) {
		int aux;
		int n = a.length - 1;
		for (int i = 0; i <= n; i++) {

			for (int j = 0; j < n - i; j++) {

				if (a[j] > a[j + 1]) {
					aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
			}
		}
	}

	/**
	 * Metodo de ordenamiento quicksort.
	 *
	 * El algoritmo trabaja de la siguiente forma:
	 *
	 * Elegir un elemento del arreglo de elementos a ordenar, al que llamaremos
	 * pivote. Resituar los demas elementos de la lista a cada lado del pivote, de
	 * manera que a un lado queden todos los menores que el, y al otro los mayores.
	 * Los elementos iguales al pivote pueden ser colocados tanto a su derecha como
	 * a su izquierda, dependiendo de la implementaciÃ³n deseada. En este momento,
	 * el pivote ocupa exactamente el lugar que le corresponderÃ¡ en la lista
	 * ordenada. La lista queda separada en dos sublistas, una formada por los
	 * elementos a la izquierda del pivote, y otra por los elementos a su derecha.
	 * Repetir este proceso de forma recursiva para cada sublista mientras Ã©stas
	 * contengan mas de un elemento. Una vez terminado este proceso todos los
	 * elementos estarÃ¡n ordenados. Como se puede suponer, la eficiencia del
	 * algoritmo depende de la posicion en la que termine el pivote elegido.
	 *
	 * En el mejor caso, el pivote termina en el centro de la lista, dividiendola en
	 * dos sublistas de igual tamaÃ±o. En este caso, el orden de complejidad del
	 * algoritmo es O(n·log n). En el peor caso, el pivote termina en un extremo de
	 * la lista. El orden de complejidad del algoritmo es entonces de O(n²). El peor
	 * caso dependerÃ¡ de la implementacion del algoritmo, aunque habitualmente
	 * ocurre en listas que se encuentran ordenadas, o casi ordenadas. Pero
	 * principalmente depende del pivote, si por ejemplo el algoritmo implementado
	 * toma como pivote siempre el primer elemento del array, y el array que le
	 * pasamos esta ordenado, siempre va a generar a su izquierda un array vacÃ­o,
	 * lo que es ineficiente. En el caso promedio, el orden es O(n·log n).
	 *
	 *
	 * @param a Pre: array de enteros desordenado. Post: array ordenado
	 */

	public static void quicksort(int[] arreglo, int i, int j) {
		int indiceP;
		if (i < j) {
			indiceP = particion(arreglo, i, j);
			quicksort(arreglo, i, indiceP - 1);
			quicksort(arreglo, indiceP + 1, j);
		}
	}

	/**
	 * Esta funcion toma el ultimo elemento como pivote, coloca al pivote en su
	 * posicion correcta en un arreglo ordenado, y coloca todos los menores (menores
	 * que el pivote) a la izquierda del pivote y a la derecha los mayores que el
	 * pivote
	 * 
	 * @param arreglo
	 * @param min
	 * @param max
	 * @return
	 */
	private static int particion(int[] arreglo, int min, int max) {
		int i, pivote;
		pivote = arreglo[max];
		i = (min - 1); // indice del elemento mas chico

		for (int j = min; j < max; j++) {

			// Si el elemento actual es menor que el pivote
			if (arreglo[j] < pivote) {
				i++;

				// intercambia arreglo[i] y arreglo [j]
				permuta(arreglo, i, j);
			}
		}
		permuta(arreglo, i + 1, max);
		return i + 1;
	}

	/**
	 * Algoritmo de intercambio de elementos en un arreglo (de enteros)
	 * 
	 * @param a --> arreglo
	 * @param i --> elemento 1
	 * @param j --> elemento 2
	 */
	private static void permuta(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * Metodo de Ordenamiento Bucket Sort
	 * 
	 * El algoritmo trabaja de la siguiente forma:
	 * 
	 * Es un algoritmo de ordenamiento que distribuye todos los elementos a ordenar
	 * entre un número finito de casilleros. Cada casillero sólo puede contener los
	 * elementos que cumplan unas determinadas condiciones. Las condiciones deben
	 * ser excluyentes entre sí, para evitar que un elemento pueda ser clasificado
	 * en dos casilleros distintos. Después cada uno de esos casilleros se ordena
	 * individualmente con otro algoritmo de ordenación (que podría ser distinto
	 * según el casillero), o se aplica recursivamente este algoritmo para obtener
	 * casilleros con menos elementos. Se trata de una generalización del algoritmo
	 * Pigeonhole sort. Cuando los elementos a ordenar están uniformemente
	 * distribuidos la complejidad computacional de este algoritmo es de O(n).
	 * 
	 * 
	 * @param arreglo
	 * @param n (colocar la longitud del arreglo)
	 */
	public void bucketsort(int arreglo[], int n) {

		// Crea el bucket vacio
		int[] bucket = new int[n];

		// Pone los elementos del arreglo en diferentes buckets
		for (int i = 0; i < bucket.length; i++) {
			int bi = n*arreglo[i];
			
		}
		
		
		//ordena los buckets de forma individual
		
		for (int j = 0; j < bucket.length; j++) {

		}
		
		//Concatena los buckets en el arreglo inicial
		
		int indice= 0;
		for (int k = 0; k < bucket.length; k++) {
			
		}
		

	}

}
