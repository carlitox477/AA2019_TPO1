package TPO_01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class SumaDigitosTest {
	
	@Test
	public void testSumaCifras() {
		
		int suma,esperado;
		esperado=7;
		suma=SumaDigitos.sumaCifras(25);
		assertEquals(esperado, suma);
		}
	
	@Test
	public void testMayorQue() {
		int num1, num2;
		boolean esperado, actual;
		
		esperado=true;
		num1=59;
		num2=101;
		
		actual=SumaDigitos.mayorQue(num1, num2);
		assertEquals(esperado,actual);
		}
	
	@Test
	public void testArregloSumaCifras() {
		int[][] numeros_esperados, numeros_calculados;
		numeros_esperados=generarArregloTest();
		numeros_calculados=new int[numeros_esperados.length][numeros_esperados[0].length];
		for(int i=0; i<numeros_calculados.length;i++) {
			numeros_calculados[i][0]=numeros_esperados[i][0];
			numeros_calculados[i][1]=SumaDigitos.sumaCifras(numeros_calculados[i][0]);
			//assertEquals(numeros_esperados[i][0],numeros_calculados[i][0]);
			}
		assertArrayEquals(numeros_esperados,numeros_calculados);
		}
	
	@Test
	public void testMayorQueEspecialArreglo() {
		int[][] mayores_menoresE, mayores_menoresC;
		
		mayores_menoresE=generarComparacionesEspeciales();
		mayores_menoresC=new int[mayores_menoresE.length][mayores_menoresE[0].length];
		
		for(int i=0; i<mayores_menoresC.length;i++) {
		
			mayores_menoresC[i][0]=SumaDigitos.devolverMayor(mayores_menoresE[i][0],mayores_menoresE[i][1]);
			mayores_menoresC[i][1]=SumaDigitos.devolverMenor(mayores_menoresE[i][0],mayores_menoresE[i][1]);
			//assertEquals(numeros_esperados[i][0],numeros_calculados[i][0]);
			}
		assertArrayEquals(mayores_menoresE,mayores_menoresE);
		}
	
	private int[][] generarArregloTest() {
		int cantidadNumeros;
		int[][] numeros_sumas;
		int[]auxIA;
		
		cantidadNumeros=100;
		
		numeros_sumas=new int[cantidadNumeros][2];
		for (int i=0;i<cantidadNumeros;i++) {
			auxIA=SumaDigitos.generarNumeroYVerficacion();
			numeros_sumas[i][0]=auxIA[0];
			numeros_sumas[i][1]=auxIA[1];
			}
		return numeros_sumas;
		}
	
	private int[][] generarComparacionesEspeciales() {
		//los casos especiales seran cuando de dos cifras sea igual
		//en dicho caso, el número más grande será el más grande
		//en casos comunes. Es decir 12 es mayor 3, 18 es mayor a 9
		int cantidadNumeros;
		int[][] mayores_menores;
		int[]auxIA;
		
		cantidadNumeros=100;
		
		mayores_menores=new int[cantidadNumeros][2];
		for (int i=0;i<cantidadNumeros;i++) {
			auxIA=SumaDigitos.generarCasoEspecial();
			mayores_menores[i][0]=auxIA[0];
			mayores_menores[i][1]=auxIA[1];
			
			}
		return mayores_menores;
		}
	
	private int[] generarArregloDeLargo(int largo) {
		Random generador;
		int[] arreglo=new int[largo];
		generador=new Random();
		for (int i=0;i<arreglo.length;i++) {
			arreglo[i]=generador.nextInt(100000);
			}
		return arreglo;
		}

}
