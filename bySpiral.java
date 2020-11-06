public class bySpiral {
        public static void main (String[]args){

            // create n-by-n array of integers 1 through n
            int[][] arr = new int[4][4];
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr.length; j++)
                    arr[i][j] = 1 + arr.length * i + j;

            for (int i = 0; i < arr.length; i++)// start main loop
            {
                for (int j = 0; j < arr.length; j++)// start nested loop
                {
                    arr[i][j] = 1 + arr.length*i + j;
                } // finish nested loop
            } // finish main loop

            for (int[] el1 : arr)
            {
                for (int el2 : el1)
                {
                    System.out.print(el2 + " ");
                }
            }

            System.out.println();

            // spiral
            for (int i = arr.length - 1, j = 0; i > 0; i--, j++) {
                for (int k = j; k < i; k++)
                    System.out.print(arr[j][k] + " ");
                for (int k = j; k < i; k++)
                    System.out.print(arr[k][i] + " ");
                for (int k = i; k > j; k--)
                    System.out.print(arr[i][k] + " ");
                for (int k = i; k > j; k--)
                    System.out.print(arr[k][j] + " ");
            }

            // special case for middle element if n is odd
            if (arr.length % 2 != 0)
                System.out.print(arr[(arr.length - 1) / 2][(arr.length - 1) / 2] + " ");
        }

    }
