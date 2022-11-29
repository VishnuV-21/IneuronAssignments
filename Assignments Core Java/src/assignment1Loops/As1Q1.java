package assignment1Loops;

public class As1Q1 {

	public static void main(String[] args) {
		int n=7;
		//This is a program giving the output as Ineuron in stars.
		
		for(int i=0;i<n;i++) {    
			
			//This is I
			for(int j=0;j<n;j++) {
				if(i==0 || i==n-1 || j==(n-1)/2) 
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			
			//This is N
			System.out.print("  ");
			for(int j=0;j<n;j++) {
				if(j==0 || j==n-1 || i==j) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				} 
			}
			
			//This is U
			System.out.print("  ");
			for(int j=0;j<n;j++) {
				if(j==0&&i!=n-1 || j==n-1&&i!=n-1 || i==n-1&&j!=0&&j!=n-1) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				} 
			}
			
			//This is R
			System.out.print("  ");
			for(int j=0;j<n;j++) {
				if(j==0 || i==0 || j==n-1&&i<=(n-1)/2 || i==j&&i>=(n-1)/2 || i==(n-1)/2&&j>=(n-1)/2) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				} 
			}
			
			//This is 0
			System.out.print("  ");
			for(int j=0;j<n;j++) {
				if(i==0 || i==n-1 || j==0 || j==(n-1)) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				} 
			}
			
			//This is N
			System.out.print("  ");
			for(int j=0;j<n;j++) {
				if(j==0 || j==n-1 || i==j) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				} 
			}
			System.out.println(" ");
		}
	}
}
