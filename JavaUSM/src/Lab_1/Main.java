package Lab_1;

import Lab_1.Assets.Sweeper;

public class Main {
    public static void main(String[] args) {
        Sweeper[] sweepers = new Sweeper[4];
        for (int i = 0; i < sweepers.length; i++) {
            sweepers[i] = new Sweeper();
            if (i % 2 == 0)
            {
                sweepers[i].setRandom();
            }
            else
                {
                    sweepers[i].setFromKeyBoard();
                }
        }

        for (Sweeper sweeper : sweepers)
        {
            System.out.println("--------------------------------------------------------------------");
            System.out.println(sweeper.toString());
            System.out.println("--------------------------------------------------------------------");
        }

        Sweeper best = sweepers[0];
        for (int i = 1; i < sweepers.length;++i)
        {
            best = Sweeper.whoIsBetter(best,sweepers[i]);
        }
        System.out.println("Cel mai bun maturator este: ");
        System.out.println(best.toString());
    }

}
