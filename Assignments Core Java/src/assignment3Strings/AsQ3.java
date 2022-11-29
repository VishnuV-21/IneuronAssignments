package assignment3Strings;

import java.util.Arrays;
import java.util.Scanner;

public class AsQ3 {

	public static void main(String[] args) {
		/*
		 * To check if the string is an anagram:We should check three things that are: 1
		 * Length should be equal 2 use sort and equals method. thats it
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First word:");
		String str1 = sc.nextLine();
		System.out.println("Enter the Second word:");
		String str2 = sc.nextLine();
		int count = 0;
		char c1[] = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (c1.length == c2.length) {
			if (Arrays.equals(c1, c2))
				System.out.println("The two words are anagram");
			else
				System.out.println("They are not anagram ");
		} else
			System.out.println("They are not anagrams");

	}

}
