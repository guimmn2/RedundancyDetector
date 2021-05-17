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
		
		String[] subStrings = getAllSuffixes(test);
		Arrays.sort(subStrings);
		
		for(int i = 0; i < subStrings.length; i++){
			System.out.println(subStrings[i]);
		}
		
		int size = 0;
		String res = "";
		System.out.println(res.length());
		

		for(int i = 0; i < subStrings.length; i++){
			for(int j = i+1; j < subStrings.length; j++){
				System.out.println("comparing " + subStrings[i] + " with " + subStrings[j]);
				if(findMatch(subStrings[i], subStrings[j]) == true && subStrings[i].length() > size){
					res = subStrings[i];
					System.out.println("saved: " + res);
					size = subStrings[i].length();
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
			//System.out.println(auxKey[i]);
			if(auxKey[i] != auxCmp[i]) {
				exists = false;
				break;
			}
		}
		return exists;
	}


	private static String[] getAllSuffixes(String og){
		
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
