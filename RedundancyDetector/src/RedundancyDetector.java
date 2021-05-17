import java.io.*;
import java.util.*;
//import java.math.*;

public class RedundancyDetector {

	/* IDEIA GERAL: Dividir String em substrings incrementalmente mais pequenas, começando por dividir ao meio.
	 * Começar por comparar primeiro caracter de cada substring resultante e avançar apenas conforme haja um "match" de chars
	 * caso contrário compara-se com a próxima substring possível e por aí em diante até todos os chars das subs serem iguais
	 */
	public static void main(String[] args) throws IOException {

		File fx = null;
		InputStream istream = null;
		fx = new File(args[0]);
		istream = new FileInputStream(fx);
		Queue<Character> q = new LinkedList<Character>();
		try {

			Reader reader = new InputStreamReader(istream);
			int c;

			while ((c = reader.read()) != -1) {
				if (c == ' ')
					c = '-';                 // just replace spaces with dash
				q.add((char) c);
			}
		}
		catch (IOException e) {
			System.out.println("Oops");
		}
		char[] aux = new char[q.size()];
		int i = 0;
		while(q.iterator().hasNext()){
			aux[i]=q.remove();
			i++;
		}
		String res = String.valueOf(aux);
		//System.out.println(String.valueOf(aux));
		res=seekLRSubstring(res);
		System.out.println("Size of redundant string: " +res.length());
		System.out.println("Longest redundant string: " +res);
	}


	private static String seekLRSubstring(String s){

		String res = "";
		char[] aux = s.toCharArray();
		int N = aux.length;

		int subSize = (int)(N/2); //o potencial tamanho máximo de uma substring redundante é metade; ex: "baba" -> "ba"

		while(subSize >= 1){

			int lim1 = N - (2 * subSize);
			int lim2 = N - subSize;

			for(int i = 0; i <= lim1; i++){
				int k = lim2;
				for(int j = i + subSize; j <= lim2/2+1; j++){
					//System.out.println("i: "+i+"| j: "+j+"| k: "+k);
					if(compareSubstrings(aux,i,j,subSize) || compareSubstrings(aux,i,k,subSize)){
						return foundString(aux,i,subSize);
					}
					k--;
				}
			}
			subSize--;
		}
		System.out.println("No string found!");
		return res;

	}

	//compara substrings do mesmo tamanho, caracter a caracter, se forem iguais devolve true.
	/*
	 * s = String original convertida em array de chars
	 * base 1 = indice do inicio da 1ª substring
	 * base 2 = " da 2ª
	 * size = tamanho das substrings
	 */
	private static boolean compareSubstrings(char[] s, int base1, int base2, int size){

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


	//função que devolve string dado um array de chars, uma base e um tamanho
	//parte do indice base e lê size caracteres, inclusive a base
	private static String foundString(char[] s,int base, int size){

		//System.out.println("ENTREI NO FOUNDSTRING!");
		//System.out.println(String.valueOf(s) + " " + base + " " + size);
		char[] aux = new char[size];
		int j = 0;
		int lim = base + size - 1;

		for(int i = base; i <= lim; i++){
			//System.out.println("Printing in aux: " + s[i]);
			aux[j] = s[i];
			//System.out.println("Saved char: " + aux[j]);
			j++;
		}

		String res = String.valueOf(aux);
		//System.out.println(res);
		return res;

	}

}
