public class byLines {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++)// start main loop
        {
            for (int j = 0; j < arr.length; j++)// start nested loop
            {
                arr[i][j] = 1 + arr.length * i + j;
            }
        } // finish main loop


        for (int[] el1 : arr)
        {
            for (int el2 : el1)
            {
                System.out.print(el2 + " ");
            }
        }

        System.out.println();

        //Код для обхода по строкам
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("arr[" + i + "]" + "[" + j + "]: " + arr[i][j] + " ");
            }
        }

        System.out.println();

        //Код для обхода по столбцам
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("arr[" + i + "]" + "[" + j + "]: " + arr[i][j] + " ");
            }
        }
    }
}
