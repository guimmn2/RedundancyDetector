import java.util.*;
import java.math.*;

public class RedundancyDetector {
	
	//IDEIA: Dividir string em strings incrementalmente mais pequenas dependendo da condição se são encontradas substrings
	//redundantes ou não. Ex: string "banana"
							//"ban" ; "ana" (key = "ban"; key != "ana" => divide)
							//"ba" ; "na" ; "na" =>
							// => (key = "ba"; key != "na"1; key != "na"2 => key = "na"1; key = "na"2 => devolve na)
	
	
	
	//implementar uma stack de strings para serem guardadas dinâmicamente sem ter que reccorer a resizes de arrays
	
	private Node first = null;
	int size; //nr de componentes
	
	private class Node{
		
		Node next;
		String item;
		
	}
	
	private void push(String item){
		Node oldfirst = first;
		first = new Node();
		first.next = oldfirst;
		first.item = item;
		size ++;
	}
	
	private String pop(){
		String item = first.item;
		first = first.next;
		size --;
		return item;
	}
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String given = in.nextLine();
		char[] test = given.toCharArray();
		
		System.out.println(test);
		System.out.println(read(test,0,0));
		
		String[] arr = divideIntoSubstrings(given);
		
		
		
		
		in.close();
		
		
	}
	
	private static String[] divideIntoSubstrings(String a){
		
		char[] aux = a.toCharArray();
		
		int factor = 2;
		int limit = (int)((aux.length / factor) - 1);
		RedundancyDetector s = new RedundancyDetector(); //inicializa a stack
		
		while(factor-- > 0){
			for(int i = 0; i < aux.length; i += factor){
				String temp = read(aux,i,limit).toString();
				System.out.println(temp);
				s.push(temp);
				 
				
			}
			
		}
		String[] subStr = new String[s.size];
		for(int i = 0; i < s.size; i++){
			subStr[i] = s.pop();
		}
		
		return subStr;
		
		
	}
	
	private static char[] read(char[] arr, int base, int limit){
		
		//lê da base até ao indice limite, inclusive
		
//		if(base + limit > arr.length -1) throw new IllegalStateException("Out of bounds");
//		if(base < 0 || limit < 0) throw new IllegalArgumentException("indices < 0 !");
		
		char[] read = new char[limit - base + 1];
		
		for(int i = 0; i < read.length; i++){
			read[i] = arr[base+i];
		}
		
		return read;
		
	}
	
	
	

	
	
	
	

	
	
	
}
