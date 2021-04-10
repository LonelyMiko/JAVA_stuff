package Lab_5.assets;

import java.util.Random;

/**
 * This class creates a matrix filled with random values and reads the negative values for each column
 */
public class MyThread implements Runnable{
    private final int threadId;
    static private final Random random = new Random();
    static private final int row = random.nextInt(10)+1;
    static private final int column = row;
    static private final long[][] matrix = new long[row][column];

static
{
    initMatrix();
}

    /**
     * Constructor that assigns a value to <code>this.threadId</code>
     * @param threadId value to be assigned
     * @throws RuntimeException if <code>threadId</code> is less than 0 or more than matrix length
     */
    public MyThread(int threadId) {
        if (threadId >= 0 && threadId < row) {
            this.threadId = threadId;
        }
        else
            {
                throw new RuntimeException("Invalid id");
            }
    }

    /**
     * This method fills the matrix with random numbers
     */
    private static void initMatrix()
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //This code generates positive and negative numbers
                matrix[i][j] = random.nextInt(65536)-32768;
            }
        }
    }

    /**
     * This method reads the number of negative values in the column
     * @return number of negative values in the column
     */
    private synchronized int countNegativeNumber()
    {
        int count = 0;
        for (int i = 0; i < row; i++) {
            if (matrix[i][threadId] < 0)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * This method print matrix
     */
    public static void printMatrix()
    {
        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int j = 0; j < column; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
        }
    }


    /**
     * This method calls when a new thread is created
     */
    @Override
    public void run() {
        System.out.println("Sunt " + countNegativeNumber() + " numere negative in coloana " + threadId);
    }

    public static int getRow() {
        return row;
    }
}
