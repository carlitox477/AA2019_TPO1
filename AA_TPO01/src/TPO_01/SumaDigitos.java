package TPO_01;

import java.util.Random;

public class SumaDigitos {

	public static int devolverMayor(int num1, int num2) {
		int sal;
		if(mayorQue(num1,num2)) {
			sal=num1;
			}else {
				sal=num2;
				}
		return sal;
		}
	
	public static int devolverMenor(int num1, int num2) {
		int sal;
		if(!mayorQue(num1,num2)) {
			sal=num1;
			}else {
				sal=num2;
				}
		return sal;
		}
	
	public static boolean mayorQue(int num1, int num2) {
		int sum1, sum2;
		boolean esMayor;
		
		esMayor=false;
		sum1=sumaCifras(num1);
		sum2=sumaCifras(num2);
		if(sum1>sum2) {
			esMayor=true;
			}else if (sum1==sum2) {
				if(num1>num2) {
					esMayor=true;
					}
				}
		return esMayor;
		}
	
	public static int sumaCifras(int num) {
		return sumaCifras(num,0);
		}
	
	public static int[] generarNumeroYVerficacion() {
		int[]sal;
		int longitudNumero, num, valorSuma, auxI;
		Random generador;
		
		generador=new Random();
		sal=new int[2];
		longitudNumero=generador.nextInt(5+1);
		num=0;
		valorSuma=0;
		
		for(int i=1;i<longitudNumero;i++) {
			auxI=generador.nextInt(10);
			num=num*10+auxI;
			valorSuma+=auxI;
			}
		sal[0]=num;
		sal[1]=valorSuma;		
		return sal;
		}
	
	private static int sumaCifras(int num, int aux) {
		int resto;
		if(num!=0) {
			resto=num%10;
			aux+=resto;
			aux=sumaCifras(num/10,aux);
			}
		return aux;
		}
	
	public static int[] generarCasoEspecial(){
		//la idea es generar numeros de hasta 4 cifras y luego
		// agregarle un 0. Por ejemplo, si genramos 22, el
		//mayor generado es 220
		int[] mayor_menor=new int[2];
		Random generador;
		
		generador=new Random();
		mayor_menor[1]=generador.nextInt(9998)+1;
		mayor_menor[0]=mayor_menor[0]*10;
		return mayor_menor;
		}
	
	public static int generarNumeroDeSuma(int suma) {
		//este método genera un número tal que la suma
		//de sus cifras sea el especificado;
		int gen=-1;
		if(suma>=0) {
			gen=generarNumeroDeSuma(suma, 0);
			}else if (suma==0) {
				gen=0;
				}
		return gen;
		}
	
	private static int generarNumeroDeSuma(int suma, int num) {
		//este método genera un número tal que la suma
		//de sus cifras sea el especificado;
		int aux;
		
		num*=10;
		if(suma>9) {
			//genero número de 0 a 9
			aux=((int) (Math.random()*10));
			suma-=aux;
			num+=aux;
			num=generarNumeroDeSuma(suma,num);
			}else {
				num+=suma;
				}
		return num;
		}
	
	public static int generarNumeroEntreSuma(int suma1, int suma2) {
		//este método genera un número tal que la suma
		//de sus cifras se encuentra en el rango especificado;
		int auxI, gen;
		gen=-1;
		if (suma1>=0 && suma1<=suma2) {
			auxI=suma1+(int)(Math.random()*(suma2-suma1+1));
			gen=generarNumeroDeSuma(auxI);
			}
		return gen;
		}

}
