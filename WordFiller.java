package Assign34;

import java.util.*;

public class WordFiller {

	static List<String> wordList;

	public static String getAuthorName()
	{
		return "Gold, Lucas";
	}

	public static String getRyersonID()
	{
		return "500686031";
	}

	public static void processWordList(List<String> words)
	{
		wordList = words;
	}

	public static String fillPattern(String pattern)
	{

		for (int i = 0; i < pattern.length(); i++)
		{
			List<String> tmpList = new ArrayList<String>(wordList); 

			if (i < pattern.length()-4)
			{
				List<Character> tmp = new ArrayList<Character>(); 

				for (int index = 0; index < 5; index++)
				{
					tmp.add(pattern.charAt(i+index));
				}

				for (int n = 0; n < tmp.size(); n++)
				{
					for (int m = 0; m < tmpList.size(); m++)
					{
						if (tmp.get(n) != '*')
						{
							if (tmp.get(n) != tmpList.get(m).charAt(n))
							{
								tmpList.remove(m);
								m--;
							}

						}
						
						else {break;}
					}
					
					if (tmpList.size() != 0 && n == 4)
					{
						String s1 = pattern.substring(0, i);
						String s2 = pattern.substring(i+5, pattern.length());
						pattern = s1+tmpList.get(0)+s2;					
					}
				}
			}
		}
		
		for (int i = 0; i < pattern.length(); i++)
		{
			if (pattern.charAt(i) == '*')
			{
				String s1 = pattern.substring(0, i);
				String s2 = pattern.substring(i+1, pattern.length());
				pattern = s1+"a"+s2;	
			}
		}

		return pattern;
	}

}

