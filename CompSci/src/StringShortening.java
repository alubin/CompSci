
public class StringShortening {

	public static void main(String[] args) {
		
		char[] test = "Mr%20John%20Smith".toCharArray();
		
		shorten(test);
		System.out.println(test);

	}
	
	private static void shorten(char[] str)
	{
		int start = 0, end = 0;
		for(int i =0; i < str.length; i++)
		{
			char currChar = str[i];
			if(currChar == '%')
			{
				start = i;
				
				for(int j = i; j < str.length; j++)
				{
					if(str[j] == '%')
					{
						end = j;
						str[start] = ' ';
						str[end] = ' ';
						break;
					}
				}
			}
		}
	}

}
