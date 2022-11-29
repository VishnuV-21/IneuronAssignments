package assignment3Strings;

import java.util.Scanner;

public class As3Q2 {
	public static void main(String[] args) {
		// Think Twice with preserving the positions, O/P:kniht eciwt
		Scanner sc = new Scanner(System.in);
		String str;
		String str1 = "";
		String result = "";
		System.out.println("Enter the string:");
		str = sc.nextLine();

		// This loop reversed the string by words
		String arr[] = str.split(" ");
		for (int i = arr.length - 1; i >= 0; i--) {
			str1 = str1 + arr[i] + " ";
		}

		// This loops reverse the string by each letter
		for (int i = str1.trim().length() - 1; i >= 0; i--) {
			if (str1.charAt(i) > 'A' && str1.charAt(i) < 'Z')
				result = result + (char) (str1.trim().charAt(i) + 32);
			else
				result = result + (char) (str1.trim().charAt(i));
		}
		System.out.println("The Estimated output is: \n" + result);

	}

}
