package assignment1Loops;
public class As1Q2 {
/*This program we are printing this pattern
1 1 1 1
2 2 2 2
3 3 3 3
4 4 4 4
 */
	public static void main(String[] args) {
		int n=4;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				System.out.print(i+" ");
			}
			System.out.println(" ");
		}
	}
}
