//Morales Mat�as FAI 108 - Carlos Amarante FAI 1922

package TPO_01;

public class Ordenamiento {

	/**
	 * Metodo de ordenamiento Burbuja.
	 *
	 * Funciona revisando cada elemento de la lista que va a ser ordenada con el
	 * siguiente, intercambiandolos de posicion si estan en el orden equivocado Es
	 * necesario revisar varias veces toda la lista hasta que no se necesiten más
	 * intercambios, lo cual significa que la lista está ordenada.
	 *
	 * Tiempo de ejecucion del algoritmo burbuja:
	 *
	 * Para el mejor caso (un paso) O(n) | Peor caso n(n-1)/2 | Promedio O(n�)
	 *
	 * @param a Pre: array de enteros desordenado. Post: array ordenado
	 */
	public static void burbuja(int[] a) {
		int n = a.length - 1;
		for (int i = 0; i <= n; i++) {

			for (int j = 0; j < n - i; j++) {
				if (SumaDigitos.mayorQue(a[j], a[j + 1])) {
					// if (a[j] > a[j + 1]) {
					permuta(a, j, j + 1);
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
	 * a su izquierda, dependiendo de la implementación deseada. En este momento,
	 * el pivote ocupa exactamente el lugar que le corresponderá en la lista
	 * ordenada. La lista queda separada en dos sublistas, una formada por los
	 * elementos a la izquierda del pivote, y otra por los elementos a su derecha.
	 * Repetir este proceso de forma recursiva para cada sublista mientras éstas
	 * contengan mas de un elemento. Una vez terminado este proceso todos los
	 * elementos estarán ordenados. Como se puede suponer, la eficiencia del
	 * algoritmo depende de la posicion en la que termine el pivote elegido.
	 *
	 * En el mejor caso, el pivote termina en el centro de la lista, dividiendola en
	 * dos sublistas de igual tamaño. En este caso, el orden de complejidad del
	 * algoritmo es O(n * log n). En el peor caso, el pivote termina en un extremo
	 * de la lista. El orden de complejidad del algoritmo es entonces de O(n�). El
	 * peor caso dependerá de la implementacion del algoritmo, aunque habitualmente
	 * ocurre en listas que se encuentran ordenadas, o casi ordenadas. Pero
	 * principalmente depende del pivote, si por ejemplo el algoritmo implementado
	 * toma como pivote siempre el primer elemento del array, y el array que le
	 * pasamos esta ordenado, siempre va a generar a su izquierda un array vacío,
	 * lo que es ineficiente. En el caso promedio, el orden es O(n�log n).
	 *
	 *
	 * @param a Pre: array de enteros desordenado. Post: array ordenado
	 */

	public static void quicksort(int[] arreglo) {
		if (arreglo != null) {
			quicksort(arreglo, 0, arreglo.length - 1);
		}
	}

	public static void quicksort(int[] arreglo, int i, int j) {
		// i posición inicial
		// j posicion final
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
	public static int particion(int[] arreglo, int min, int max) {
		int i, pivote;
		pivote = arreglo[max];
		i = (min - 1); // indice del elemento mas chico

		for (int j = min; j < max; j++) {
			// Si el elemento actual es menor que el pivote
			if (SumaDigitos.mayorQue(pivote, arreglo[j])) {
				// if (arreglo[j] < pivote) {
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
	public static void permuta(int[] a, int i, int j) {
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
	 * entre un n�mero finito de casilleros. Cada casillero s�lo puede contener
	 * los elementos que cumplan unas determinadas condiciones. Las condiciones
	 * deben ser excluyentes entre s�, para evitar que un elemento pueda ser
	 * clasificado en dos casilleros distintos. Despu�s cada uno de esos
	 * casilleros se ordena individualmente con otro algoritmo de ordenaci�n (que
	 * podr�a ser distinto seg�n el casillero), o se aplica recursivamente este
	 * algoritmo para obtener casilleros con menos elementos. Se trata de una
	 * generalizaci�n del algoritmo Pigeonhole sort. Cuando los elementos a
	 * ordenar est�n uniformemente distribuidos la complejidad computacional de
	 * este algoritmo es de O(n).
	 * 
	 * 
	 * @param arreglo
	 * @param n       (colocar la longitud del arreglo)
	 */
	public static void bucketsort(int arreglo[], int valorMax, int cantParticiones) {
		// Crea el bucket vacio
		int longitudRango = valorMax / cantParticiones;
		int[][] bucket = new int[cantParticiones][arreglo.length];
		int[] limitesBuckets = new int[cantParticiones];

		// Pone los elementos del arreglo en diferentes buckets
		for (int i = 0; i < arreglo.length; i++) {
			clasificarNumeros(arreglo[i], bucket, longitudRango, limitesBuckets);
		}

		// ordena los buckets de forma individual
		for (int i = 0; i < bucket.length; i++) {
			quicksort(bucket[i], 0, limitesBuckets[i] - 1);
		}

		// Concatena los buckets en el arreglo inicial
		int pos = 0;
		for (int i = 0; i < bucket.length; i++) {
			int j = 0;
			while (j < limitesBuckets[i]) {
				arreglo[pos] = bucket[i][j];
				pos++;
				j++;
			}
		}
	}

	/**
	 * Añade un elemento en la primer posicion libre del arreglo
	 * 
	 * @param bucket:   bucket donde se va a agregar el elemento
	 * @param elemento: elemento que se va a agregar
	 */
	public static void addToBucket(int[] bucket, int elemento) {
		int i = 0;
		while (i < bucket.length && bucket[i] != 0) {
			i++;
		}
		bucket[i] = elemento;
	}

	/**
	 * Clasifica en que Bucket va a entrar el arreglo
	 * 
	 * @param numero:         elemento a agregar
	 * @param bucket:         arreglo de buckets
	 * @param longRango:      rango de los buckets
	 * @param limitesBuckets: los limites del bucket
	 */
	public static void clasificarNumeros(int numero, int[][] bucket, int longRango, int[] limitesBuckets) {
		int sumaCifras, posBucket;
		sumaCifras = SumaDigitos.sumaCifras(numero);
		if (sumaCifras % longRango != 0 || sumaCifras == 0) {
			posBucket = sumaCifras / longRango;
		} else {
			// si no puede caer fuera del arreglo
			posBucket = sumaCifras / longRango - 1;
		}
		limitesBuckets[posBucket]++;
		addToBucket(bucket[posBucket], numero);
	}
}
