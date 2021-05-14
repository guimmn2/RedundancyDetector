import java.util.*;
import java.math.*;

public class RedundancyDetector {
	
	/* IDEIA GERAL: Dividir String em substrings incrementalmente mais pequenas, começando por dividir ao meio. 
	 * Começar por comparar primeiro caracter de cada substring resultante e avançar apenas conforme haja um "match" de chars
	 * caso contrário compara-se com a próxima substring possível e por aí em diante até todos os chars das subs serem iguais
	 */
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String test = in.nextLine();
		
		char[] s = test.toCharArray();
	
//		System.out.println(compareSubstrings(s,0,2,2));
		
		System.out.println(LRSubstring(test));
		
		
		in.close();
		
		
	}
	
	
	//compara substrings do mesmo tamanho, caracter a caracter, se forem iguais devolve true.
	/*
	 * s = String original convertida em array de chars
	 * base 1 = indice do inicio da 1ª substring
	 * base 2 = " da 2ª
	 * size = tamanho das substrings
	 */
	private static boolean compareSubstrings(char[] s, int base1, int base2, int size){
				
		if(base2 + size > s.length || base1 + size > s.length) throw new IllegalStateException("Out of bounds!");
		
		for(int i = base1; i <= size; i++){
			System.out.println(s[i] + "" + s[i+size]);
			if(s[i] != s[i+size]) return false;
		}
		return true;	
	}
	
	
	private static String LRSubstring(String s){
		return seekLRSubstring(s,0,(int)(s.length()/2));
	}
	
	private static String seekLRSubstring(String s, int base1, int size){
		
		char[] aux = s.toCharArray();
		int N = aux.length;
		
		int subSize = size; //o potencial tamanho máximo de uma substring redundante é metade; ex: "baba" -> "ba"
		int i = base1;
		int j = i + subSize; //subSize = 3
		
		
		
		try {
			while(true){
			if (compareSubstrings(aux,i,j,subSize)) return foundString(aux,i,subSize);
			else j++;
			}
		} catch(Exception IllegalStateException) {
			System.out.println("APANHEI A EXCEPÇÃO: " + "VALOR DO J: " + j);
			if(i != N - (2 * subSize)) { i++; /*System.out.println(i + " " + (N - (2 * subSize) - 1));*/ return seekLRSubstring(s,i,subSize); }
			else { subSize --; return seekLRSubstring(s,i,subSize); }
		}
		
	}
	
	
	private static String foundString(char[] s,int base, int size){
		
		char[] aux = new char[size];
		
		for(int i = base; i <= size; i++){
			aux[i] = s[i];
		}
		
		String res = String.valueOf(aux);
		return res;
	}
	
}
