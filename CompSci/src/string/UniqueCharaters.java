package string;

import java.util.Hashtable;

public class UniqueCharaters {

	public static void main(String[] args) {
		
		String word1 = "apple";
		String word2 = "berry";
		String word3 = "tacky";
		String word4 = "active";
		
		String results[] = {word1, word2, word3, word4};
		
		for(String word: results)
		{
			System.out.println("For : " + word);
			System.out.println("Contains only unique characters with struct " + (uniqueCharWithStruct(word)));
			System.out.println("Contains only unique characters with struct 2 " + (uniqueCharWithStruct2(word)) + '\n');
			System.out.println("Contains only unique characters with binary man " + (uniqueBin(word)) + '\n');
		}
		


	}
	/**
	 * This function was taken from the Career cup book. 
	 * @param word
	 * @return
	 */
	private static final boolean uniqueBin(String word)
	{
		//TODO:Study and fully understand this function.
		//Checking against the value in the ASCII Table.
		if(word.length() > 128)
		{
			return false;
		}
		int checker = 0;
		//Need to iterate trough every character in the string.
		for(int i = 0; i < word.length(); i++)
		{
			//create a lookup value
			int hashValue = word.charAt(i) - 'a';
			//will check there is any value at that location. 
			//The & operation will return false if the "|" operation hasn't put a value that will properly cause the "&" case to trigger.
			if((checker & (1 << hashValue)) > 0)
			{
				//A value was found so, it must have been used before.
				return false;
			}
			//Puts a value into that location if none was found.
			checker = checker | (1 << hashValue);
			System.out.println("Checker = " + checker);
			
		}
		return true;
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
