import java.io.*;
import java.util.*;
//import java.math.*;

public class RedundancyDetector {

	/* IDEIA GERAL: Dividir String em substrings incrementalmente mais pequenas, come�ando por dividir ao meio. 
	 * Come�ar por comparar primeiro caracter de cada substring resultante e avan�ar apenas conforme haja um "match" de chars
	 * caso contr�rio compara-se com a pr�xima substring poss�vel e por a� em diante at� todos os chars das subs serem iguais
	 */

//	public static void main(String[] args){

//		Scanner in = new Scanner(System.in);
//		String test = in.nextLine();
//
//
//		char[] s = test.toCharArray();
//
//		//iterateAndCompare(s);
//		System.out.println(seekLRSubstring(test));
//
//		in.close();

	    public static void main(String[] args) throws IOException {

	        File fx = null;
	        InputStream istream = null;
	        fx = new File(args[1]);
	        istream = new FileInputStream(fx);
	     
	        try {
	            
	    Reader reader = new InputStreamReader(istream);
	             int c;
	             while ((c = reader.read()) != -1) {
	                 if (c == ' ') c = '-';                 // just replace spaces with dash
	                 System.out.print ((char) c);
	             }
	        }
	        catch (IOException e) {
	            System.out.println("Oops");
	        }
	        
	    }



	//compara substrings do mesmo tamanho, caracter a caracter, se forem iguais devolve true.
	/*
	 * s = String original convertida em array de chars
	 * base 1 = indice do inicio da 1� substring
	 * base 2 = " da 2�
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




	private static String seekLRSubstring(String s){

		String res = "";
		char[] aux = s.toCharArray();
		//System.out.println("char array: " + String.valueOf(aux));		
		int N = aux.length;

		int subSize = (int)(N/2); //o potencial tamanho m�ximo de uma substring redundante � metade; ex: "baba" -> "ba"
		//			int i = 0;
		//			int j = i + subSize; //subSize = 3

		while(subSize >= 1){

			//System.out.println("i, j = " + i + " " + j);

			int lim1 = N - (2 * subSize);
			int lim2 = N - subSize;
			
//			System.out.println("SubSize "+subSize);
//			System.out.println("lim1 "+lim1);
//			System.out.println("lim2 "+lim2);


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
