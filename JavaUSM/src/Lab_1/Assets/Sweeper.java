package Lab_1.Assets;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * De creat clasa “Măturatorul mustecios” cu câteva câmpuri.(Varianta 7)
 * @author Mihail Coslet
 */
//I'm tired

/**
 * Classa Sweeper(Maturator)
 */
public class Sweeper {
    static int totalBroomCount;
    int broomCount;
    int[] broomUsing;
    int sweeperAge;
    float sweeperHeight;
    float sweeperWeight;
    String sweeperName;

    /**
     * Constructor fara parametri
     */
    public Sweeper() {
        broomCount = 0;
        broomUsing = new int[broomCount];
        sweeperAge = 0;
        sweeperHeight = 0f;
        sweeperWeight = 0f;
    }

    /**
     * Constructor cu parametri
     * @param broomCount -> Numarul de maturi
     * @param broomUsing -> Tablou ce reprezinta uzarea fiecarei maturi
     * @param sweeperAge -> Varsta maturatorului
     * @param sweeperHeight -> Inaltimea maturatorului
     * @param sweeperWeight -> Greutatea maturatorului
     * @param sweeperName -> Numele maturatorului
     */
    public Sweeper(int broomCount, int[] broomUsing, int sweeperAge,
                   float sweeperHeight, float sweeperWeight, String sweeperName) {
        if(broomCount > 0) {
            this.broomCount = broomCount;
            this.broomUsing = new int[broomCount];
        }
        else
            {
                this.broomCount = 0;
                this.broomUsing = new int[]{}; // array pustiu
            }
        this.broomUsing = broomUsing;
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
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Dati numarul de maturi: ");
            this.broomCount = scanner.nextInt();
        }
        while (this.broomCount < 0);
        this.broomUsing = new int[broomCount];
        totalBroomCount+=broomCount;
        /**
        * Ciclul do-while nu va permite inregistrarea unui numar mai mic decat 0 si mai mare decat 5
        */
        for (int i = 0; i < broomCount; i++) {
            int temp;
            do {
                System.out.print("Dati numarul de uzare a maturei " + (i+1) + ": ");
                temp = scanner.nextInt();
            }
            while (temp > 5 || temp < 0);
            this.broomUsing[i] = temp;

        }

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
        Random random = new Random();
        this.broomCount = random.nextInt(10);
        totalBroomCount+=broomCount;
        this.broomUsing = new int[broomCount];
        for (int i = 0; i < broomCount; i++) {
            broomUsing[i] = (byte)random.nextInt(6);
        }
        this.sweeperAge = (random.nextInt(60));

        /**
         * random.nextFloat nu are parametrul bound, din aceasta cauza utilizam formula:
         * random.nextFloat * (Max - Min) + Min, pentru a primi o valoare intre Min si Max
         */
        this.sweeperHeight = random.nextFloat()*(180-150)+150;
        this.sweeperWeight = random.nextFloat()*(100-70)+70;

        /**
         * Generarea unui nume random
         * Generarea are loc cu ajutorul selectari unui caracter aleator din candidateChars
         */
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        this.sweeperName = sb.toString();
    }

    /**
     * Getters
     */

    public static int getTotalBroomCount() {
        return totalBroomCount;
    }

    public int getBroomCount() {
        return broomCount;
    }

    public int[] getBroomUsing() {
        return broomUsing;
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
                "broomCount=" + broomCount +
                ", broomUsing=" + Arrays.toString(broomUsing) +
                ", sweeperAge=" + sweeperAge +
                ", sweeperHeight=" + sweeperHeight +
                ", sweeperWeight=" + sweeperWeight +
                ", sweeperName='" + sweeperName + '\'' +
                '}';
    }

    /**
     * Metoda, care reînoieste maturile uzate,
     * adică dacă matura are coeficientul de uzare 5 se “arunca” şi se înlocueşte cu una nouă care are coeficientul de uzare 0
     * @return numarul de maturi reînoiete
     */
    public int updateBroomUsing()
    {
        int count = 0;
        for (int i = 0; i < this.broomCount; i++) {
            if (this.broomUsing[i] == 5)
            {
                this.broomUsing[i] = 0;
                count++;
            }
        }
        return count;
    }

    /**
     * Setters
     */

    public static void setTotalBroomCount(int totalBroomCount) {
        Sweeper.totalBroomCount = totalBroomCount;
    }

    public void setBroomCount(int broomCount) {
        if(broomCount > 0) {
            this.broomCount = broomCount;
            this.broomUsing = new int[broomCount];
        }
        else
        {
            this.broomCount = 0;
            this.broomUsing = new int[]{}; // array pustiu
        }

    }

    public void setBroomUsing(int[] broomUsing) {
        this.broomUsing = broomUsing;
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
     * @param sweeper1 -> primul maturator
     * @param sweeper2 -> al doilea maturator
     */
    static public Sweeper whoIsBetter(Sweeper sweeper1, Sweeper sweeper2)
    {
        int sweeper1Total=0;
        int sweeper2Total=0;
        for (int i = 0; i < sweeper1.broomCount; i++) {
            sweeper1Total+=sweeper1.broomUsing[i];
        }
        for (int i = 0; i < sweeper2.broomCount; i++) {
            sweeper2Total+=sweeper2.broomUsing[i];
        }
        if (sweeper1Total > sweeper2Total)
        {
                return sweeper1;
        }
            return sweeper2;
    }
}

