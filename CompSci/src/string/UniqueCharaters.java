package string;

import java.util.Hashtable;

public class UniqueCharaters {

	public static void main(String[] args) {
		
		String word1 = "apple";
		String word2 = "berry";
		String word3 = "tacky";
		
		String results[] = {word1, word2, word3};
		
		for(String word: results)
		{
			System.out.println("For : " + word);
			System.out.println("Contains only unique characters with struct " + (uniqueCharWithStruct(word)));
			System.out.println("Contains only unique characters with struct 2 " + (uniqueCharWithStruct2(word)) + '\n');
		}
		


	}
	
	/**
	 * This function will take in a string and will determine if the string only contains unique characters.
	 * This is will work by creating a boolean array that will work similar to a hash table.
	 * @param word
	 * @return
	 */
	private static final boolean uniqueCharWithStruct(String word)
	{
		//Exit if the string is too long to use an array based hash table.
		if(word.length() > 128)
		{
			return false;
		}
		
		//All the values in the boolean array will default to false.
		boolean check[] = new boolean[128];
		
		//Iterate through all the values in the array
		for(int i = 0; i < word.length(); i++)
		{
			//Create a hash value for storing in the boolean array
			int charValue = word.charAt(i);
			
			//Check to see if the area is empty
			if(check[charValue])
			{
				return false;
			}
			else
			{
				//Assign a value so that when checked again it will return a true value.
				check[charValue] = true;
			}
		}
		
		return true;
		
	}
	
	/**
	 * This function will take in a string and will determine if the string only contains unique characters.
	 * This is will work by creating a Hash Map.
	 * @param word
	 * @return
	 */
	private static final boolean uniqueCharWithStruct2(String word)
	{
		
		//A HashTable to keep the runtime low.
		Hashtable<Character, Boolean> myHT = new Hashtable<Character, Boolean>();
		
		for(int i = 0; i < word.length(); i++ )
		{
			boolean contain = myHT.containsKey(word.charAt(i));
			if(contain)
			{
				
				return false;
			}
			else
			{
				myHT.put(word.charAt(i), true);
			}
		}
		return true;
		
	}

}
