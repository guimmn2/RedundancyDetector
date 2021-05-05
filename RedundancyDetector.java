import java.util.*;
import java.math.*;

public class RedundancyDetector {
	
	
	//No enunciado diz que o ponto de partida deve ser desenvolver um algoritmo de força bruta que verifica 
	//o comprimento da correspondência (?) em cada par possível de posições iniciais
	//whatever that means...
	
	//se considerarmos qualquer string de tamanho N, o nº de pares possíveis é N*N-1

	
	//vamos exprimentar coisas!
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String str = "";
		
		str = s.nextLine();
		
		char[] char_array = str.toCharArray();
						
		printAllSubstrings(char_array);
//		substringArray(char_array);
		s.close();
	}
	
	//IMPORTANTE : CONSIDERA-SE QUE O COMPRIMENTO MÍNIMO DE UMA SUBSTRING É DE 2
	//ex: abc -> {ab, abc, bc}
	
	//método de força bruta que faz print de todos os possíveis substrings dado um array de caracteres
	public static void printAllSubstrings(char[] string){
		
		int tempCounter = 0;
		
		for(int i = 0; i < string.length; i++){
			for(int j = i + 1; j < string.length; j++){
				for(int k = i; k <= j; k++){
					System.out.print(string[k]);
				}
				System.out.println("");
				tempCounter ++;
			}
		}
		System.out.println(tempCounter);
	}
	
	//precisamos primeiro de saber quais são as substrings que se repetem
	//em segundo lugar, das que se repetem, qual a maior
	
	//uma forma de resolver isto seria ordenar todas as strings por ordem alfabética
	//assim sempre que houvesse pelo menos uma parelha essa string é guardada num array
	
	
	public static String[] substringArray(char[] string){
		
		//sabemos que existem, para um string de length N, N*[(N+1)/2 - 1] substrings de length mínima de 2.
		int N = string.length;
		int len = N*((N+1)/2 - 1);
		char aux;
		
		String[] sub = new String[len];
		
		for(int i = 0; i < string.length; i++){
			for(int j = i + 1; j < string.length; j++){
				for(int k = i; k <= j; k++){
					//System.out.print(string[k]);
					//OBJECTIVO: passar todas as substrings que consegui fazer print com a func anterior
					//para um array de Strings
				}
			}
		}
	}
	
	
	
}
