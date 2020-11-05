import java.util.Scanner;
public class byDiagonals
{
	public static void main(String[] args) {
		int n;
		int[][] arr = new int[15][15]; // Create an array[15][15]
		Scanner scan = new Scanner(System.in); //Create an onject of class Scanner
		System.out.println("Enter n:");
		n = scan.nextInt();// variable n store user input, used for size array

		for (int i = 0; i < n; i++)// start main loop
		{
			for (int j = 0; j < n; j++)// start nested loop
			{
				arr[i][j] = 1 + n*i + j;
			} // finish nested loop
		} // finish main loop

		System.out.println("Along the side diagonals:");
		for (int k = 0; k < n; k++) {
			int sum = k;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (i + j == sum)
						System.out.print(" " + arr[i][j]);// display elements above the side and the diagonal itself
		}
		for (int k = 1; k < n; k++) {
			int sum = n - 1 + k;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (i + j == sum)
						System.out.print(" " + arr[i][j]);// display side diagonals
		}

		System.out.println("\nAlong the main diagonals:");
		int i = 0;
		for (int j = n - 1; j >= 0; j--) {
			System.out.print(arr[i][j] + " "); // start at the top-right element
			int k = i;
			int m = j;
			while (arr[k + 1][m + 1] != 0) {
				k++;
				m++;
				System.out.print(arr[k][m] + " ");
			}   // check if an element exists by the digonal and display it, 
			    //if not, go to the next column and so on by columns

		}
		int j = 0;
		for (i = 1; i < n; i++) {
			System.out.print(arr[i][j] + " ");// i starts with 1, j is always 0

			int k = i;
			int m = j;
			while (arr[k + 1][m + 1] != 0) {
				k++;
				m++;
				System.out.print(arr[k][m] + " ");
			}   //check if an element exists by diagonal and display it, 
			    //if not, go to the next line and so on by lines

		}

	}

}
