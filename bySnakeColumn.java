public class bySnakeColumn {
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

        System.out.println();

        for (int j = 0; j < arr.length; j++)
        {
            if (j % 2 == 0)
            {
                for (int i = (arr.length -1); i >= 0; i--)
                {
                    System.out.println("arr[" + i + "]" + "[" + j + "]: " + arr[i][j] + " ");
                }
            }
            else
                {
                    for (int i = 0; i < arr.length; i++)
                    {
                        System.out.println("arr[" + i + "]" + "[" + j + "]: " + arr[i][j] + " ");
                    }
                }
        }
    }
}
