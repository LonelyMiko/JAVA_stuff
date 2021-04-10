package Lab_4;


import Lab_4.assets.Sweeper;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Sweeper> sweepers = new ArrayList<>();
        Sweeper bestSweeper;

        for (int i = 0; i < 2; i+=2) {
            sweepers.add(new Sweeper());
            sweepers.get(i).setFromKeyBoard();

            sweepers.add(new Sweeper());
            sweepers.get(i+1).setRandom();
        }

        bestSweeper = sweepers.get(0);
        sweepers.forEach(sweeper -> Sweeper.updateBroom(sweeper.getBrooms()));

        for (Sweeper sweeper : sweepers)
        {
            bestSweeper = Sweeper.whoIsBetter(sweeper,bestSweeper);
        }

        Sweeper.printToFile(sweepers);
        System.out.println("Cel mai bun maturator: " + bestSweeper.toString());
    }
}
