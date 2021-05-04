import java.util.Scanner;

class RedundancyDetector {

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

	private static char[] resizeArray(char[] array_resize, int resize_factor){
		int resized_length = array_resize.length * resize_factor;
		char[] resizedarray = new char[resized_length];
		for(int i=0; i < array_resize.length; i++ )
			resizedarray[i]=array_resize[i];
		return resizedarray;
	}

	private static String charStreak(char[] array_search, String higheststring, int highestcount){
		int count_from_index=0;
		int fecresult=0;
		int al = array_search.length;
		for(int array_index = 0; array_index < al; array_index+=count_from_index){
			fecresult=array_index;
			count_from_index=1;
			while(fecresult < al && fecresult >= 0){
				fecresult = findEqualChar(array_search, array_search[array_index], fecresult);
				if(fecresult != -1){
					System.out.println("Found equal char at "+fecresult+" "+array_search[fecresult]);
					int tempcount=1;
					int offset=1;
					char[] substringchar = new char[4];
					substringchar[0] = array_search[fecresult];
					while(fecresult+offset < al && array_index+offset < fecresult && array_index+offset < al && array_search[fecresult+offset]==array_search[array_index+offset]){
						substringchar[offset]=array_search[array_index+offset];
						tempcount++;
						offset++;
						if(offset == substringchar.length)
							substringchar = resizeArray(substringchar, 2);
					}
					if(tempcount>count_from_index)
						count_from_index=tempcount;
					if(tempcount > highestcount){
						higheststring = String.valueOf(substringchar);
						highestcount = tempcount;
					}
				}
			}
		}
		return higheststring;
	}


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
		higheststring = higheststring.replaceAll("\\s","");
		System.out.println("Longest redundant string: "+higheststring);

	}
}
