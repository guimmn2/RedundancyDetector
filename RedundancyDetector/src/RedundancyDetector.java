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
		
		//iterateAndCompare(s);
		System.out.println(seekLRSubstring(test));

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


//	private static String iterateAndCompare(char[] arr){
//		
//		String res = "";
//		int size = (int)(arr.length/2);
//		int limit = size;
//
//		while(size > 1){
//			for(int i = 0; i != limit; i++){
//				for(int j = i + size; j < arr.length - size; j++){
//					
//					System.out.println("i,j = " + i + " " + j);
////					if(compareSubstrings(arr,i,j,size)) res = foundString(arr,i,size);
//					System.out.println("cheguei aqui!");
//				}
//				limit = i + size - 1;
//			}
//			size --;
//		}
//		return res;
//	}



		private static String seekLRSubstring(String s){
	
			String res = "";
			char[] aux = s.toCharArray();
			//System.out.println("char array: " + String.valueOf(aux));		
			int N = aux.length;
	
			int subSize = (int)(N/2); //o potencial tamanho máximo de uma substring redundante é metade; ex: "baba" -> "ba"
//			int i = 0;
//			int j = i + subSize; //subSize = 3
			
			while(subSize >= 1){
				
				//System.out.println("i, j = " + i + " " + j);
				
				int lim1 = N - (2 * subSize);
				int lim2 = N - subSize;
				
				for(int i = 0; i <= lim1; i++){
					for(int j = i + subSize; j <= lim2; j++){
						//System.out.println("i, j = " + i + " " + j);
						//System.out.println("SIZE IS: " + subSize);
						if(compareSubstrings(aux,i,j,subSize)){ return foundString(aux,i,subSize); }
					}
				}
				subSize--;
			}
			return res;
//			try{
//				while(true){
//					
//					if(compareSubstrings(aux,i,j,subSize)) return foundString(aux,i,subSize);
//					j++;
//				}
//				
//			} catch(Exception e){
//				
//					while(i != N - (2 * subSize)){
//						i++;
//						for(int k = j; k < N - subSize; j++){
//							if(compareSubstrings(aux,i,j,subSize)) return foundString(aux,i,subSize);
//						}
//					}
//					subSize --;
//					i = 0;
//			}
	
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
