package Lab_3;


import Lab_3.exception.SweeperException;

public class Main {
    static public void main(String[] args)
    {
        Sweeper[] sweepers = new Sweeper[2];
        Sweeper bestSweeper = null;
        for (int i = 0; i < sweepers.length-1; i+=2)
        {
            sweepers[i] = new Sweeper();
            sweepers[i+1] = new Sweeper();

            sweepers[i].setFromKeyBoard();
            System.out.println("-------------------------------------------------------------------");
            sweepers[i+1].setRandom();

            SweeperException.validateData(sweepers[i]);
            SweeperException.validateData(sweepers[i+1]);
        }
            Sweeper.printToFile(sweepers);

        for (int i = 0; i < sweepers.length-1; i++) {
            bestSweeper = Sweeper.whoIsBetter(sweepers[i],sweepers[i+1]);
        }
        System.out.println("Best Sweeper: ");
        System.out.println(bestSweeper.toString());

    }
}

