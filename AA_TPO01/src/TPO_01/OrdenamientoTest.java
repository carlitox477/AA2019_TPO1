package TPO_01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrdenamientoTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testQuicksort() {
		int[] desorden = {9,6,4,7,3,5,1,8,2};
		int[] creciente = {1,2,3,4,5,6,7,8,9};
		Ordenamiento.quicksort(desorden, 0,8);
		assertArrayEquals(creciente, desorden);

	}
	
}
