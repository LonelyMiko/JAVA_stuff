package Lab_4.assets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
 * De creat clasa “Măturatorul mustecios” cu câteva câmpuri.(Varianta 7)
 * @author Mihail Coslet
 */
//I'm tired

/**
 * Classa Sweeper(Maturator)
 */
public class Sweeper {
    static int totalBroomCount;
    ArrayList<Broom> brooms = new ArrayList<>();
    int sweeperAge;
    float sweeperHeight;
    float sweeperWeight;
    String sweeperName;
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor fara parametri
     */
    public Sweeper() {
        sweeperAge = 0;
        sweeperHeight = 0f;
        sweeperWeight = 0f;
    }

    /**
     * Constructor cu parametri
     * @param broomCount -> Numarul de maturi
     * @param sweeperAge -> Varsta maturatorului
     * @param sweeperHeight -> Inaltimea maturatorului
     * @param sweeperWeight -> Greutatea maturatorului
     * @param sweeperName -> Numele maturatorului
     */
    public Sweeper(int broomCount, int sweeperAge,
                   float sweeperHeight, float sweeperWeight, String sweeperName) {
        if(broomCount > 0) {
            for (int i = 0; i < broomCount; i++) {
                brooms.add(new Broom());
            }
        }
        this.sweeperAge = sweeperAge;
        this.sweeperHeight = sweeperHeight;
        this.sweeperWeight = sweeperWeight;
        this.sweeperName = sweeperName;
    }


    /**
     * Metoda care completeaza toate campurile obiectului cu valori citite de la tastatura.
     **/
    public void setFromKeyBoard()
    {
        int broomCount;
        do {
            System.out.print("Dati numarul de maturi: ");
            broomCount = scanner.nextInt();
        }
        while (broomCount < 0);

        for (int i = 0; i < broomCount; i++) {
            brooms.add(new Broom());
        }

        totalBroomCount+=broomCount;

        System.out.print("Dati varsta maturatorului: ");
        this.sweeperAge = scanner.nextInt();

        System.out.print("Dati inatimea maturatorului: ");
        this.sweeperHeight = scanner.nextFloat();

        System.out.print("Dati greutatea maturatorului: ");
        this.sweeperWeight = scanner.nextFloat();

        System.out.print("Dati numele maturatorului: ");
        this.sweeperName = scanner.next();
    }

    /**
     * Metoda care completeaza toate campurile obiectului cu valori aleatoare.
     **/
    public void setRandom()
    {
        int broomCount;
        Random random = new Random();
        broomCount = random.nextInt(10);
        totalBroomCount+=broomCount;
        for (int i = 0; i < broomCount; i++) {
            int broomUsing = random.nextInt(5);
            String color = randomString(random.nextInt(10));
            String material = randomString(random.nextInt(10));
            brooms.add(new Broom(broomUsing,color,material));
        }
        this.sweeperAge = (random.nextInt(60));

        /*
         * random.nextFloat nu are parametrul bound, din aceasta cauza utilizam formula:
         * random.nextFloat * (Max - Min) + Min, pentru a primi o valoare intre Min si Max
         */
        this.sweeperHeight = random.nextFloat()*(180-150)+150;
        this.sweeperWeight = random.nextFloat()*(100-70)+70;

        this.sweeperName = randomString(random.nextInt(7));
    }

    /**
     * Functia ce creaza un sir aleator
     * @param length  lungimea sirului
     * @return sirul aleator
     */
    private String randomString(int length)
    {
        Random random = new Random();
        /*
         * Generarea unui nume random
         * Generarea are loc cu ajutorul selectari unui caracter aleator din candidateChars
         */
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }

    /**
     * Functia care salveaza datele in fisier
     * @param sweepers lista maturatorilor
     */
    public static void printToFile(ArrayList<Sweeper> sweepers)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Sweepers.out"));
            for (Sweeper sweeper : sweepers) {
                writer.write(sweeper.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Functia ce reseteaza utilizarea unei maturi
     * @param brooms lista maturilor
     */
    public static void updateBroom(ArrayList<Broom> brooms)
    {
        brooms.forEach(s-> {
            if (s.getBroomUsing() >= 5) {
                s.setBroomUsing(0);
            }
        });
    }

    /**
     * Getters
     */

    public static int getTotalBroomCount() {
        return totalBroomCount;
    }

    public int getBroomCount() {
        return brooms.size();
    }

    public ArrayList<Broom> getBrooms() {
        return brooms;
    }

    public int getSweeperAge() {
        return sweeperAge;
    }

    public float getSweeperHeight() {
        return sweeperHeight;
    }

    public float getSweeperWeight() {
        return sweeperWeight;
    }

    public String getSweeperName() {
        return sweeperName;
    }


    /**
     * Metoda pentru a afişa la ecran toată informaţia despre măturător, adică toate câmpurile din această clasă.
     * @return informaţia despre măturător
     */
    @Override
    public String toString() {
        return "Sweeper{" +
                "broomCount=" + brooms.size() +
                ", broomUsing=" + brooms +
                ", sweeperAge=" + sweeperAge +
                ", sweeperHeight=" + sweeperHeight +
                ", sweeperWeight=" + sweeperWeight +
                ", sweeperName='" + sweeperName + '\'' +
                '}';
    }


    /**
     * Setters
     */

    public static void setTotalBroomCount(int totalBroomCount) {
        Sweeper.totalBroomCount = totalBroomCount;
    }


    public void setBrooms(ArrayList<Broom> brooms) {
        this.brooms = brooms;
    }

    public void setSweeperAge(int sweeperAge) {
        this.sweeperAge = sweeperAge;
    }

    public void setSweeperHeight(float sweeperHeight) {
        this.sweeperHeight = sweeperHeight;
    }

    public void setSweeperWeight(float sweeperWeight) {
        this.sweeperWeight = sweeperWeight;
    }

    public void setSweeperName(String sweeperName) {
        this.sweeperName = sweeperName;
    }

    /**
     * Metoda statică, care compară doi măturători
     * după hărnicie, după numarul de mature uzate (suma coificienţilor de uzare)
     * @param sweeper1 primul maturator
     * @param sweeper2  al doilea maturator
     * @return maturatorul cel mai eficient
     */
    static public Sweeper whoIsBetter(Sweeper sweeper1, Sweeper sweeper2)
    {
        int sweeper1Total=0;
        int sweeper2Total=0;
        for (int i = 0; i < sweeper1.brooms.size(); i++) {
            sweeper1Total+=sweeper1.brooms.get(i).getBroomUsing();
        }
        for (int i = 0; i < sweeper2.brooms.size(); i++) {
            sweeper2Total+=sweeper2.brooms.get(i).getBroomUsing();
        }
        if (sweeper1Total > sweeper2Total)
        {
                return sweeper1;
        }
            return sweeper2;
    }
}

