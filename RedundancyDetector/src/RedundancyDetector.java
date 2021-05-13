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
	
		System.out.println(compareSubstrings(s,1,3,2));
		
		
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
			System.out.println(s[i] + " " + s[i+size]);
			if(s[i] != s[i+size]) return false;
		}
		return true;	
	}
	
}
