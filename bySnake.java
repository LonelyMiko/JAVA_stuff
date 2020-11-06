public class bySnake {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];

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

        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            if (i % 2 == 0)
            {
                for (int j = 0; j < arr.length; j++)
                {
                    System.out.println("arr[" + i + "]" + "[" + j + "]: " + arr[i][j] + " ");
                }
            }
            else
                {
                    for (int j = arr.length - 1; j >= 0; j--) {
                        System.out.println("arr[" + i + "]" + "[" + j + "]: " + arr[i][j] + " ");
                    }
                }
        }
        }
    }
