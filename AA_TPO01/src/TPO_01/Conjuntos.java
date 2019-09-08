package TPO_01;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Conjuntos {
	// clase para crear conjuntos de prueba
	static final String NOMBRE_ARCHIVO_PROMEDIO = "src/TPO_01/arreglosCasoPromedio.dat";

	public static void main(String[] args) {
		ArrayList<int[][]> casosPromedios;
		ArrayList<int[]> casosPeores, casosMejores;
		int valorLimite, cantCasosPrueba, limiteCantEleXPrueba, cantParticionesBS;
		valorLimite = 9999;
		cantCasosPrueba = 5; // cuestiones estadísticas
		limiteCantEleXPrueba = 1000; // evaluaremos hasta arreglos de longitud 10.000

		// genero casos de prueba para casos promedio
		casosPromedios = crearCasosRandomBucketQuickSort(limiteCantEleXPrueba, valorLimite + 1, cantCasosPrueba);

		try {

			BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_PROMEDIO));

			for (int[][] arreglo : casosPromedios) {

				for (int i = 0; i < arreglo.length; i++) {

					for (int j = 0; j < arreglo[i].length; j++) {
						System.out.print(" " + arreglo[i][j]);
						buff.write(arreglo[i][j] + "\n ");
					}
					//buff.write("\n");
				}
			}
			buff.close();
		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
		} catch (IOException ex) {
			System.err.println("Error leyendo o escribiendo en algun archivo.");
		}
	}
	
	
	public static void leerArchivo() {
		
	}
	
	
	

	public static ArrayList<int[][]> crearCasosRandomBucketQuickSort(int longTope, int valorLimite, int casosPorLong) {
		// crea casoPorLong de prueba de longitud 0 a longtope
		// Estos casos luego se guardaran en un archivo
		// y serviran para el calculo empirico de los
		// tiempos de ejecución de bucket promedio
		int[][] aux;
		ArrayList<int[][]> sal = new ArrayList<int[][]>();
		for (int i = 1; i <= longTope; i++) {
			// hago arreglos de 1 elemento a longTope elementos
			aux = new int[casosPorLong][i];
			for (int j = 0; j < casosPorLong; j++) {
				// creo arreglos para pruebas de longitud i
				aux[j] = crearCasoRandomBucketQuickSort(i, valorLimite);

			}
			sal.add(aux);
		}

		return sal;
	}

	public static int[] crearCasoRandomBucketQuickSort(int cantElementos, int limite) {
		// crea casod de prueba de longitud 0 a longtope
		// Estos casos luego se guardaran en un archivo
		// y serviran para el calculo empirico de los
		// tiempos de ejecución de bucket
		int[] sal = new int[cantElementos];
		for (int i = 0; i < cantElementos; i++) {
			sal[i] = (int) (Math.random() * limite);
		}
		return sal;
	}

	public static int[][] crearPeoresCasoBucketQuickSort(int longTope, int cantPart) {
		ArrayList<int[]> buckets, peoresCasos;
		int tamBM, repXEle, auxI;
		int[] aux, bucketMayor;

		peoresCasos = new ArrayList<int[]>();
		buckets = crearBuckets(longTope, cantPart);
		bucketMayor = buckets.get(buckets.size());
		tamBM = bucketMayor.length;

		for (int i = 1; i <= longTope; i++) {
			aux = new int[i];
			repXEle = i / tamBM + 1;
			for (int j = 0; j < i; j++) {
				auxI = j / repXEle;
				aux[i - j] = bucketMayor[tamBM - auxI];
			}
			peoresCasos.add(aux);
		}

		return null;
	}

	public static int[][] crearMejoresCasoBucketQuickSort(int longTope, int cantPart) {
		ArrayList<int[]> buckets, sal;
		int[] arrAux;
		int[][] longBuckets;
		int j, aux;

		sal = new ArrayList<int[]>();
		buckets = crearBuckets(longTope, cantPart);
		longBuckets = new int[buckets.size()][2];

		for (int k = 0; k < longBuckets.length; k++) {
			longBuckets[k][0] = buckets.get(k + 1).length;
		}

		for (int i = 1; i <= longTope; i++) {
			for (int k = 0; k < longBuckets.length; k++) {
				longBuckets[k][1] = 0; // sera el último elemento seleccionado de la particion
			}
			arrAux = new int[i];
			j = 0;
			while (j < i) {
				// me determina de que partición voy a obtener
				// un elemento
				aux = j % cantPart;

				// selecciono el elemento del arreglo
				arrAux[j] = 1;

				j++;
			}
			sal.add(arrAux);
		}
		return null;
	}

	public static int calcularTiempoQuickSort() {

		return 0;
	}

	public static int calcularTiempoQuickSortTeorico() {
		// limitados por cuestiones propias
		return 0;
	}

	public static int calcularTiempoBucketQuickSort() {
		return 0;
	}

	public static int calcularTiempoBucketSortQuickTeorico() {
		// limitados por cuestiones propias
		return 0;
	}

	private static ArrayList<int[]> crearBuckets(int longTope, int cantPart) {
		int[] arr;
		arr = generarArregloHastaOrdenado(longTope);
		return obtenerBuckets(arr, longTope, cantPart);
	}

	private static ArrayList<int[]> obtenerBuckets(int[] arreglo, int valorMax, int cantParticiones) {
		ArrayList<int[]> sal = new ArrayList<int[]>();

		// Crea el bucket vacio
		int[] aux;
		int longitudRango = valorMax / cantParticiones; // 1 op + 1 asi
		int[][] bucket = new int[cantParticiones][arreglo.length]; // 1 acc + 1 creac
		int[] limitesBuckets = new int[cantParticiones]; // 1 creacion
		// Pone los elementos del arreglo en diferentes buckets
		for (int i = 0; i < arreglo.length; i++) {
			Ordenamiento.clasificarNumeros(arreglo[i], bucket, longitudRango, limitesBuckets);
		}

		// ordena los buckets de forma individual
		for (int i = 0; i < bucket.length; i++) {
			Ordenamiento.quicksort(bucket[i], 0, limitesBuckets[i] - 1);
		}

		// generamos los bucket y los guardamos para
		// su salida
		for (int i = 0; i < bucket.length; i++) {
			aux = new int[limitesBuckets[i]];
			for (int j = 0; j < aux.length; j++) {
				aux[j] = bucket[i][j];
			}
			sal.add(aux);
		}

		return sal;
	}

	private static int[] generarArregloHastaOrdenado(int limite) {
		int[] arr = new int[limite];
		for (int i = 0; i < limite; i++) {
			arr[i] = i;
		}
		Ordenamiento.burbuja(arr);
		return arr;
	}

}
