package string;

/** 
 * This program will replace all spaces with the value "%20"
 * In this problem you must consider the cost of moving the words to add the %20.
 * It is assumed that there is enough space at the end to move all the words over.
 * It is required that I do the change in place.
 * @author AL
 *
 */
public class StringManipulation {

	public static void main(String[] args) {
		
		char[] test = "Mr John Smith    ".toCharArray();
		
		manipulate(test);
		System.out.println(test);

	}
	
	/**
	 * This method will take the spaces in a string in replace the spaces with the '%20'
	 * For this method I thought of using a helper method like an array list, however part of the requirement is that 
	 * this be done in place. So I will be manipulating the character array directly. 
	 * @param str
	 */
	private static void manipulate(char[] str)
	{
		//Since the empty spaces is at the end of the string, I will be starting from the end moving the words, to make room for the 
		//replacement.
		int start = str.length - 1;
		int runner = start - 1;
		while(runner >= 0)
		{
			if(str[runner] == ' ')
			{
				//Decrement runner if space is empty
				runner--;
			}
			else
			{
				//if it not empty swap with the empty spaces
				char temp = str[runner];
				str[runner] = str[start];
				str[start] = temp;
				runner--;
				start--;
			}

		}
	}
	
	private static final void fillWSymbol(char[] str, int runner)
	{
		String symbol = "%20";
		for(int i =0; i < symbol.length(); i++)
		{
			str[runner] = symbol.charAt(i);
			runner++;
		}
	}

}
