import java.util.Scanner;

class RedundancyDetector {

// Apenas procura o caracter igual ao da chave
// array_search - array para procurar o caracter igual
// key - o caracter de referência
// current_index+1 - o indíce apartir de onde se começa à procura (adiciona-se 1 para evitar procurar exatamente onde está a key, ficando num loop infinito)

	private static int findEqualChar(char[] array_search, char key, int current_index){
		int i = current_index + 1;
		while(i <= array_search.length-1){
			System.out.println("Array_search["+i+"] ="+array_search[i]);
			if(array_search[i] == key)
				return i;
			i++;
		}
		return -1;
	}


// Só para fazer resize conforme necessário
// array_resize - array para aumentar de tamanho
// resize_factor - fator de multiplicação para calcular tamanho

	private static char[] resizeArray(char[] array_resize, int resize_factor){
		int resized_length = array_resize.length * resize_factor;
		char[] resizedarray = new char[resized_length];
		for(int i=0; i < array_resize.length; i++ )
			resizedarray[i]=array_resize[i];
		return resizedarray;
	}

// Procura a maior string repetida
// array_search - array para procurar
// higheststring - a string mais longa redundante
// highestcount - o maior número de caracteres da higheststring

	private static String charStreak(char[] array_search, String higheststring, int highestcount){
    //count_from_index - offset para andar com a key no array
    // fecresult - indíce do character igual encontrado
    // ambas são incializadas a 0 para poder correr do início

    int count_from_index=0;
		int fecresult=0;
		int al = array_search.length;


		for(int array_index = 0; array_index < al; array_index+=count_from_index){
      // Necessário igualar o fecresult ao array_index para estarmos sempre a procurar apartir da key
      // Necessário igual o count_from_index a 1 para podermos sempre mudar de key
			fecresult=array_index;
			count_from_index=1;

      // o fecresult apenas é menor que 0 se for -1 ou seja não foi encontrado caracter igual
			while(fecresult < al && fecresult >= 0){
				fecresult = findEqualChar(array_search, array_search[array_index], fecresult);
				if(fecresult != -1){
					System.out.println("Found equal char at "+fecresult+" "+array_search[fecresult]);

          // tempcount - contagem temporária do número da sequência de caracteres iguais
          // offset - para podermos percorrer array tanto na key como no caracter igual encontrado
          // substringchar - para guardar a sequência de caracteres iguais
					int tempcount=1;
					int offset=1;
					char[] substringchar = new char[4];
          //  Como para entrar aqui foi encontrado pelo menos um caracter igual então esse caracter guardasse na primeira posição do vetor substringchar
					substringchar[0] = array_search[fecresult];
          // fecresult+offset - índice para comparar com array_index+offset
					while(fecresult+offset < al && array_index+offset < al && array_search[fecresult+offset]==array_search[array_index+offset]){
            substringchar[offset]=array_search[array_index+offset];
						tempcount++;
						offset++;
            // se o array estiver cheio praticamente
						if(offset == substringchar.length)
							substringchar = resizeArray(substringchar, 2);
					}
          // guarda no count_from_index o valor de tempcount (numero de caracteres seguidos iguais) apenas se este for maior do que o que estava antes, ou seja garante que apenas é guardado o valor máximo de sequência de caracteres
					if(tempcount>count_from_index)
						count_from_index=tempcount;

          // se o tempcount for mais que o highestcount (número de caracteres da string mais longa guardada), substitui a antiga higheststring pela nova higheststring
					if(tempcount > highestcount){
						higheststring = String.valueOf(substringchar);
						highestcount = tempcount;
					}
				}
			}
		}
    // Após percorrer o array todo retorna a higheststring
		return higheststring;
	}

  // Só driver code
	public static void main(String[] args){
		String s="";
		String higheststring="";
		int highestcount = 0;
		System.out.println("Type something");
		Scanner in = new Scanner(System.in);

		s = in.nextLine();
		in.close();
		char[] mainarray = s.toCharArray();

		// Um pequeno debug só para ver se a string foi convertida para char array corretamente
		for (int i=0; i < mainarray.length; i++)
			System.out.println("char at "+i+" is "+mainarray[i]);

		System.out.println("Char array length is "+mainarray.length);
		higheststring = charStreak(mainarray, higheststring, highestcount);
    // Problema a higheststring aqui pode ou não conter caracteres nulos/lixo, como resolver? gostava de saber...
		System.out.println("Longest redundant string: "+higheststring);

	}
}
