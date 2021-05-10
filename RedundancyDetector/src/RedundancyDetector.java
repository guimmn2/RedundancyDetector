import java.util.*;
import java.math.*;

public class RedundancyDetector {
	
	//IDEIA: Dividir string em strings incrementalmente mais pequenas dependendo da condição se são encontradas substrings
	//redundantes ou não. Ex: string "banana"
							//"ban" ; "ana" (key = "ban"; key != "ana" => divide)
							//"ba" ; "na" ; "na" =>
							// => (key = "ba"; key != "na"1; key != "na"2 => key = "na"1; key = "na"2 => devolve na)
	
	
	
	

	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String given = in.nextLine();
		char[] test = given.toCharArray();
		
		System.out.println(test);
		System.out.println(read(test,0,2));
		
		String[] arr = divideIntoSubstrings(given);
		
		
		
		
		in.close();
		
		
	}
	
	private static String[] divideIntoSubstrings(String a){
		
		char[] aux = a.toCharArray();
		
		int factor = 2; //começa por dividir array em 2
		int limit = (int)((aux.length / factor) - 1);
		
		
	}
	
	private static char[] read(char[] arr, int base, int limit){
		
		//lê da base até ao indice limite, inclusive
		
		if(base + limit > arr.length - 1) throw new IllegalStateException("extensão demasiado longa, fora do array!");
		
		if(limit < base) throw new IllegalStateException("limit tem de ser maior que a base!");
		
		if(base == limit){
			char[] one = {arr[base]};
			return one;
		}
		
		Queue<Character> s = new LinkedList<Character>();
		for(int i = base; i <= limit; i++){
			s.add(arr[i]);
		}
		
		char[] read = new char[s.size()];
		for(int i = 0; i < read.length; i++){
			read[i] = s.remove();
		}
		
		return read;
		
	}
	
	
	

	
	
	
	

	
	
	
}
