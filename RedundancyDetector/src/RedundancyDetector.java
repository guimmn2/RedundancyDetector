import java.util.*;
import java.math.*;

public class RedundancyDetector {
	
	/* IDEIA GERAL: Dividir String em substrings incrementalmente mais pequena, enquanto não se encontra a
	 * maior string redundante possível.
	 * 
	 * I - Dividir String em substrings e guardá-las numa estrutura (talvez uma queue, ou um binary heap???)
	 * Ia - Opcionalmente guardar apenas as que se repetem ???
	 * IIa - Opcionalmente ordenar se custo de operação valer a pena, para ser mais fácil procurar e comparar substrings
	 * IIb - Comparar substrings até encontrar um match.
	 * III - Devolver substring (atenção: verificar caso em que há mais de uma string redundante com o mesmo tamanho)
	 */
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		//pede a String
		String test = in.nextLine();
		int factor = in.nextInt();
		
		//System.out.println(read(test,0,3));
		
		Queue<String> q = divideInto(factor,test);
		System.out.println(q.toString());
		
//		System.out.println(read(test,4,3));
		
		in.close();
		
		
	}
	
	//função de teste para obter um "feel" da computação envolvida para dividir a string em todas as substrings
	private static Queue<String> divideInto(int factor, String s){
		
		char[] aux = s.toCharArray();
		int subStrSize = (int)(aux.length / factor);
		System.out.println(subStrSize);
		
		Queue<String> q = new LinkedList<String>();
		
		for(int i = 0; i <= aux.length; i+= subStrSize){ 
			System.out.println("iterator is: " + i);
			String temp = read(s,i,subStrSize);
			System.out.println("adding to queue: " + temp);
			q.add(temp);
		}
		return q;
		
	}
	
	
	
	
	//devolve uma substr começada em base com tamanho offset.
	private static String read(String s, int base, int offset){
		
		char[] arr = s.toCharArray();
		String res = "";
		Queue<Character> q = new LinkedList<Character>();
		
		if(offset < 0) throw new IllegalStateException("offset tem que ser positivo!");
		else if(base > arr.length - 1) throw new IllegalStateException("base fora do array!");
		
		else if(base + offset > arr.length)
		{
			//n consegui fazer isto recursivo pq n percebo recursão...
			//ideia: read(s,base,arr.length -1) (=) lê da base até ao fim
//			System.out.println("ESTAMOS NAQUELE ELSE IF QUE LÊ ATÉ AO FIM!");
			for(int i = base; i < arr.length; i++){
				System.out.println(arr[i]);
				q.add(arr[i]);
				
			}
			
			char[] aux = new char[q.size()];
			for(int i = 0; i < aux.length; i++){
				aux[i] = q.remove();
			}
			
			res = String.valueOf(aux);
			
		}
		
		
		else {
			
//			System.out.println("AGORA ESTAMOS NO ELSE QUE N TEM IF!");
		
		for(int i = base; i < base + offset; i++){
			//System.out.println("adding: " + arr[i]);
			q.add(arr[i]);
		}
		
//		res = q.toString();
//		System.out.println(res);
		
		char[] aux = new char[q.size()];
		//System.out.println("queue size @read() is: " + q.size());
		int i = 0;
		
		while(q.iterator().hasNext()){
			aux[i] = q.remove();
			/*System.out.println(aux[i]);*/ i++;
		}
		
		res = String.valueOf(aux);
		
		}
		return res;
	}
	
	
	

	
	
	
	

	
	
	
}
