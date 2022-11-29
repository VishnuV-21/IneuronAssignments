package assignment3Strings;

import java.util.Scanner;

//import java.util.Scanner;

public class As3Q1 {

	public static void main(String[] args) {
		// Without using the reverse function
		String str;
		String rStr = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string you want to reverse:");
		str = sc.nextLine();
		for (int i = str.length() - 1; i >= 0; i--) {
			rStr = rStr + str.charAt(i);
		}
		System.out.println("The reverse of the given string is:\n" + rStr);

		System.out.println("**********************************************************");
		//With the reverse function
		StringBuilder str1 = new StringBuilder("iNeuron");
		str1.reverse();
		System.out.println("The reverse of the given string is:\n" + str1);

	}

}
