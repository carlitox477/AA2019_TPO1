package TPO_01;

public class Ordenamiento {

	/**
	 * Metodo de ordenamiento Burbuja.
	 *
	 * Funciona revisando cada elemento de la lista que va a ser ordenada con el
	 * siguiente, intercambiandolos de posicion si estan en el orden equivocado Es
	 * necesario revisar varias veces toda la lista hasta que no se necesiten m√°s
	 * intercambios, lo cual significa que la lista est√° ordenada.
	 *
	 * Tiempo de ejecucion del algoritmo burbuja:
	 *
	 * Para el mejor caso (un paso) O(n) | Peor caso n(n-1)/2 | Promedio O(n≤)
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
	 * a su izquierda, dependiendo de la implementaci√≥n deseada. En este momento,
	 * el pivote ocupa exactamente el lugar que le corresponder√° en la lista
	 * ordenada. La lista queda separada en dos sublistas, una formada por los
	 * elementos a la izquierda del pivote, y otra por los elementos a su derecha.
	 * Repetir este proceso de forma recursiva para cada sublista mientras √©stas
	 * contengan mas de un elemento. Una vez terminado este proceso todos los
	 * elementos estar√°n ordenados. Como se puede suponer, la eficiencia del
	 * algoritmo depende de la posicion en la que termine el pivote elegido.
	 *
	 * En el mejor caso, el pivote termina en el centro de la lista, dividiendola en
	 * dos sublistas de igual tama√±o. En este caso, el orden de complejidad del
	 * algoritmo es O(n∑log n). En el peor caso, el pivote termina en un extremo de
	 * la lista. El orden de complejidad del algoritmo es entonces de O(n≤). El peor
	 * caso depender√° de la implementacion del algoritmo, aunque habitualmente
	 * ocurre en listas que se encuentran ordenadas, o casi ordenadas. Pero
	 * principalmente depende del pivote, si por ejemplo el algoritmo implementado
	 * toma como pivote siempre el primer elemento del array, y el array que le
	 * pasamos esta ordenado, siempre va a generar a su izquierda un array vac√≠o,
	 * lo que es ineficiente. En el caso promedio, el orden es O(n∑log n).
	 *
	 *
	 * @param a Pre: array de enteros desordenado. Post: array ordenado
	 */

	public static void quicksort(int[] a, int i, int j) {
		int indice, k;
		indice = particion(a, i, j);
		if (indice >= 0) {
			k = particion(a, i, a[indice]);
			quicksort(a, i, k - 1);
			quicksort(a, k, j);
		}
	}

	private static int particion(int[] a, int iz, int de) {
		int i, pivote;
		permuta(a, (iz + de) / 2, iz);
		// el pivote es el de centro y se cambia con el primero
		pivote = a[iz];
		i = iz;
		for (int s = iz + 1; s <= de; s++)
			if (a[s] <= pivote) {
				i++;
				permuta(a, i, s);
			}
		permuta(a, iz, i);// se restituye el pivote donde debe estar
		return i; // retorna la posicion en que queda el pivote
	}

	private static void permuta(int[] a, int i, int j) {
		int t;
		t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	
	
	/**
	 * Metodo de Ordenamiento Bucket Sort
	 * 
	 * El algoritmo trabaja de la siguiente forma:
	 *  
	 * Es un algoritmo de ordenamiento que distribuye todos los elementos a ordenar entre un n˙mero finito de casilleros.
	 * Cada casillero sÛlo puede contener los elementos que cumplan unas determinadas condiciones. 
	 * Las condiciones deben ser excluyentes entre sÌ, para evitar que un elemento pueda ser clasificado en dos casilleros distintos. 
	 * DespuÈs cada uno de esos casilleros se ordena individualmente con otro algoritmo de ordenaciÛn (que podrÌa ser distinto seg˙n el casillero),
	 * o se aplica recursivamente este algoritmo para obtener casilleros con menos elementos. 
	 * Se trata de una generalizaciÛn del algoritmo Pigeonhole sort. 
	 * Cuando los elementos a ordenar est·n uniformemente distribuidos la complejidad computacional de este algoritmo es de O(n).
	 * 
	 * 
	 * @param elementos
	 * @param n
	 */
	public void bucketsort(int elementos, int n) {
		int[] casilleros = new int[n];

		for (int i = 0; i < casilleros.length; i++) {

		}
		for (int j = 0; j < casilleros.length; j++) {

		}

	}
	
	

}
