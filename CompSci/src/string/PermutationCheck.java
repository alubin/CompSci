package string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Check wheter the two words are permutations of each.
 * For the permutation I am using the criteria of whether they are the same size and matching characters.
 * @author AL
 *
 */
public class PermutationCheck {

	public static void main(String[] args) {
		String word1 = "race";
		String word2 = "care";
		
		Scanner inputWord1 = new Scanner(System.in);
		Scanner inputWord2 = new Scanner(System.in);
		System.out.println("Please Enter Word 1 : ");
		word1 = inputWord1.next();
		System.out.println("Please Enter Word 2 : ");
		word2 = inputWord2.next();
		
		System.out.println("Are " + word1 + " and " + word2 +" permutations of each other? Answer : " + permCheck(word1, word2));

	}

	/**
	 * This function will return whether the two words are equal and size and characters to each other.
	 * Normally, I would like to use a boolean variable to return rather then just call return, however for the sake of 
	 * preventing the useless fill of the array, if the words don't match I am just returning from with the function.
	 * @param word1
	 * @param word2
	 * @return
	 */
	private  static final boolean permCheck(String word1, String word2)
	{
		ArrayList<Character> charList = new ArrayList<Character>();
		//If the words are different sizes, they can't be permutations of each other.
		if(word1.length() != word2.length())
		{
			return false;
		}
		//Fill the array list with the characters from one word.
		for(int i = 0; i < word1.length(); i++)
		{
			charList.add(word1.charAt(i));
		}

		//Check to see if all any character is not on the list.
		for(int i = 0; i < word2.length(); i++)
		{
			//A character could not be found, hence they aren't permutations of each other.
			if(!charList.contains(word2.charAt(i)))
			{
				return false;
			}
		}

		return true;
	}

}
