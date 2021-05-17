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
		
		String[] subStrings = getAllSubstrings(test);
		Arrays.sort(subStrings);
		
		for(int i = 0; i < subStrings.length; i++){
			System.out.println(subStrings[i]);
		}

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

		//if(base2 + size > s.length || base1 + size > s.length) throw new IllegalStateException("Out of bounds!");

		int j = base2;
		int lim = base1 + size - 1;

		for(int i = base1; i <= lim && j < s.length; i++){
			//System.out.println("Comparing: " + s[i] + " with " + s[j] );
			if(s[i] != s[j]) return false;
			j++;
		}
		//System.out.println("TRUE");
		return true;	
	}

	private static String[] getAllSubstrings(String og){
		
		char[] aux = og.toCharArray();
		Queue<Character> q = new LinkedList<Character>();
		Queue<String> qS = new LinkedList<String>();
		
		for(int i = 0; i < aux.length; i++){
			for(int j = i; j < aux.length; j++){
				q.add(aux[j]);
			}
			char[] temp = new char[q.size()];
			for(int k = 0; k < temp.length; k++){
				temp[k] = q.remove();
			}
			String tempRes = String.valueOf(temp);
			qS.add(tempRes);
		}
		String[] res = new String[qS.size()]; //deve haver uma forma de calcular isto tudo sem ser necessário queues
		for(int i = 0; i < res.length; i++){
			res[i] = qS.remove();
		}
		
		return res;
	}

}
