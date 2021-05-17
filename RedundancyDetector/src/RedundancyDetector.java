import java.util.*;
//import java.math.*;

public class RedundancyDetector {

	/* IDEIA GERAL: Dividir String em sufixos incrementalmente mais pequenas, começando por dividir ao meio.
	 * Começar por comparar primeiro caracter de cada substring resultante e avançar apenas conforme haja um "match" de chars
	 * caso contrário compara-se com a próxima substring possível e por aí em diante até todos os chars das subs serem iguais
	 */

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		String test = in.nextLine();


		char[] s = test.toCharArray();

		String[] sufixos = getAllSuffixes(test);
		Arrays.sort(sufixos);

		for(int i = 0; i < sufixos.length; i++){
			System.out.println(sufixos[i]);
		}

		int size = 0;
		String res = "";
		System.out.println(res.length());


		for(int i = 0; i < sufixos.length; i++){
			for(int j = i+1; j < sufixos.length; j++){
				System.out.println("comparing " + sufixos[i] + " with " + sufixos[j]);
				if(findMatch(sufixos[i], sufixos[j]) == true && sufixos[i].length() > size){
					res = sufixos[i];
					System.out.println("saved: " + res);
					size = sufixos[i].length();
				}
			}
		}


		System.out.println("res = " + res);

		in.close();


	}


	private static boolean findMatch(String key, String cmp){

		char[] auxKey = key.toCharArray();
		char[] auxCmp = cmp.toCharArray();

		boolean exists = true;

		for(int i = 0; i < auxKey.length; i++){
			System.out.println(auxKey[i]);
			if(auxKey[i] != auxCmp[i]) {
				exists = false;
				break;
			}
		}
		return exists;
	}

	private static String[] getAllSuffixes(String og){

		char[] aux = og.toCharArray();
		String[] sufixos = new String[aux.length];

		for(int i = 0; i < aux.length; i++){
			char[] aux2 = new char[aux.length-i];
			for(int j = i; j < aux.length; j++){
				aux2[j-i] = aux[j];
			}
			sufixos[i]= String.valueOf(aux2);
		}
		return sufixos;
	}
}
