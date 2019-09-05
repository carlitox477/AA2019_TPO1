package TPO_01;

import static org.junit.jupiter.api.Assertions.*;

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
		// sumas por elemento 1, 2, 4,6, 9, 12, 13, 19, 21
		Ordenamiento.quicksort(desorden);
		assertArrayEquals(creciente, desorden);
	}

	@Test
	public void testBucketsort() {
		int[] desorden = { 399, 4000, 1000, 49, 93, 1099, 101, 33, 9 };
		int[] creciente = { 1000, 101, 4000, 33, 9, 93, 49, 1099, 399 };
		// sumas por elemento 1, 2, 4,6, 9, 12, 13, 19, 21
		Ordenamiento.bucketsort(desorden, 21, 3);
		assertArrayEquals(creciente, desorden);
	}

}
