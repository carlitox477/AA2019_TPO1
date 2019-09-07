package TPO_01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class OrdenamientoTest {

	@Test
	public void testBurbuja() {
		int[] desorden = { 399, 4000, 1000, 49, 93, 1099, 101, 33, 9 };
		int[] creciente = { 1000, 101, 4000, 33, 9, 93, 49, 1099, 399 };
		// sumas por elemento 1, 2, 4,6, 9, 12, 13, 19, 21
		Ordenamiento.burbuja(desorden);
		assertArrayEquals(creciente, desorden);
	}

	@Test
	public void testQuicksort() {
		int[] desorden = { 399, 4000, 1000, 49, 93, 1099, 101, 33, 9 };
		int[] creciente = { 1000, 101, 4000, 33, 9, 93, 49, 1099, 399 };
		int[] compare = creciente.clone();
		// sumas por elemento 1, 2, 4,6, 9, 12, 13, 19, 21
		Ordenamiento.quicksort(compare);
		assertArrayEquals(creciente, compare);
	}

	@Test
	public void testBucketsort() {
		int[] arreglo = new int[15000];
		try {
			BufferedReader buff = new BufferedReader(new FileReader("src/TPO_01/numeros.txt"));

			for (int i = 0; i < 15000; i++)
				arreglo[i] = Integer.parseInt(buff.readLine());
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int[] desorden = { 399, 4000, 1000, 49, 93, 1099, 101, 33, 9 };
		int[] creciente = { 1000, 101, 4000, 33, 9, 93, 49, 1099, 399 };
		int[] clon = arreglo.clone();
		// sumas por elemento 1, 2, 4,6, 9, 12, 13, 19, 21
		double t1 = System.currentTimeMillis();
		Ordenamiento.bucketsort(arreglo, 9999, 10);
		double t2 = System.currentTimeMillis();

		double t3 = System.currentTimeMillis();
		Ordenamiento.burbuja(clon);
		double t4 = System.currentTimeMillis();

		System.out.println("TIEMPO BUCKET: " + (t2 - t1));
		System.out.println("TIEMPO BUBBLE:" + (t4 - t3));
		System.out.println("Diferencia de tiempo: " + ((t4 - t3) - (t2 - t1)));
		assertArrayEquals(clon, arreglo);
		// assertArrayEquals(arreglo, clon);
	}

}
