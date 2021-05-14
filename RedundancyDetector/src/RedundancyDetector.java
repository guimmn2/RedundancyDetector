import java.util.*;
//import java.math.*;

public class RedundancyDetector {

	/* IDEIA GERAL: Dividir String em substrings incrementalmente mais pequenas, começando por dividir ao meio. 
	 * Começar por comparar primeiro caracter de cada substring resultante e avançar apenas conforme haja um "match" de chars
	 * caso contrário compara-se com a próxima substring possível e por aí em diante até todos os chars das subs serem iguais
	 */

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		String test = in.nextLine();
		

		char[] s = test.toCharArray();
//		System.out.println(String.valueOf(s));


		//System.out.println(compareSubstrings(s,0,2,2));

		System.out.println(LRSubstring(test));
		//System.out.println(seekLRSubstring(test,0,2));


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

		int j = base2;
		
		for(int i = base1; i <= size && j < s.length; i++){
			System.out.println("Comparing: " + s[i] + " with " + s[j] );
			if(s[i] != s[j]) return false;
			j++;
		}
		System.out.println("TRUE");
		return true;	
	}


	private static String LRSubstring(String s){
		//System.out.println()
		return seekLRSubstring(s,0,(int)(s.length()/2));
	}

	private static String seekLRSubstring(String s, int base1, int size){

		char[] aux = s.toCharArray();
		//System.out.println("char array: " + String.valueOf(aux));		
		int N = aux.length;

		int subSize = size; //o potencial tamanho máximo de uma substring redundante é metade; ex: "baba" -> "ba"
		int i = base1;
		int j = i + subSize; //subSize = 3

		System.out.println("RECURSIVIDADE --> i: " + i + " j: " + j + " subSize: " + subSize);

		try {
			while(true){
				if (compareSubstrings(aux,i,j,subSize)){ System.out.println("CALLED FOUNDSTRING, args: " + String.valueOf(aux) + " " + i + " " + subSize); return foundString(aux,i,subSize);}
				else j++; System.out.println("j: " + j);
			}
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("APANHEI A EXCEPÇÃO");
			if(i != N - (2 * subSize)) { i++;  return seekLRSubstring(s,i,subSize);/*System.out.println("index do i: " + i + " " + "indice máximo do i: " + (N - (2 * subSize) - 1))*/ }
			else { subSize --; i = 0; return seekLRSubstring(s,i,subSize); }
		}

	}


	private static String foundString(char[] s,int base, int size){

//		Queue<Character> aux = new LinkedList<Character>();
//		
//		for(int i = base; i < size; i++){
//			System.out.println("Adding: " + s[i]);
//			aux.add(s[i]);
//			}
//		
//		String res = aux.toString();
//		System.out.println(res);
//		
//		return res;
		
		char[] aux = new char[size];
		int j = 0;
		
		for(int i = base; i < size; i++){
			System.out.println("Printing in aux: " + s[i]);
			aux[j] = s[i];
			System.out.println("Saved char: " + aux[j]);
			j++;
		}
		
		String res = String.valueOf(aux);
		System.out.println(res);
		return res;

	}

}
