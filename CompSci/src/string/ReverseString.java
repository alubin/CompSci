/**
 * This class will reverse null terminated strings.
 */
package string;

/**
 * @author AL
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String word = "tree";
		char wordArray[] = {'f','r','e','e','\0'};
		System.out.println("The reverse of " + word + " is " + reverse(word));
		System.out.println("The reverse of " + new String(wordArray) + " is " + reverse(wordArray));

	}
	
	/**
	 *  This function will return the reversed from of a null terminated character array.
	 * @param word
	 * @return
	 */
	private static final String reverse(char[] word)
	{
		char[] reverse = new char[word.length];
		
		//Since we are reversing the array, we can easily do that by filling a struct with the array in reverse order.
		for(int i = 0; i < word.length; i++ )
		{
			//Store the values in reverse order
			reverse[i] = word[(word.length - 1) - i]; 
		}
		
		//Convert the array to a string
		return new String(reverse);
	}
	
	/**
	 * 
	 * This is an overloaded function to handle the case the user actually enters a string that is null terminated.
	 * @param word
	 * @return
	 */
	private static final String reverse(String word)
	{
		return reverse(word.toCharArray());
	}

}
