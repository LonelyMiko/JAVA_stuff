package Lab_3;

import Lab_3.exception.SweeperException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
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
                   float sweeperHeight, float sweeperWeight, String sweeperName) throws SweeperException {
        if(broomCount > 0) {
            this.broomCount = broomCount;
            this.broomUsing = new int[broomCount];
            this.broomUsing = broomUsing;
        }
        else
            {
                this.broomUsing = null;
                throw new SweeperException("Broom Count invalid");
            }


        if (sweeperAge < 18 || sweeperAge > 50) {
            throw new SweeperException("AGE ERROR");
        }
        else {
            this.sweeperAge = sweeperAge;
        }
        if (sweeperHeight < 100 || sweeperHeight > 200) {
            this.sweeperHeight = sweeperHeight;
        }
        if (sweeperWeight < 70 || sweeperWeight > 150) {
            this.sweeperWeight = sweeperWeight;
        }
        if (sweeperName.matches("^$"))
        {
            throw new SweeperException("Invalid Name");
        }
        else {
            this.sweeperName = sweeperName;
        }
    }


    /**
     * Metoda care completeaza toate campurile obiectului cu valori citite de la tastatura.
     **/
    public void setFromKeyBoard()
    {
        Scanner scanner = new Scanner(System.in);

        boolean flag;
        do {
            try {
                flag = false;
                System.out.print("Dati numarul de maturi: ");
                this.broomCount = scanner.nextInt();

                if (this.broomCount < 0)
                {
                    this.broomUsing = new int[]{};
                    throw new SweeperException("BROOM COUNT ERROR");
                }

                System.out.print("Dati varsta maturatorului: ");
                this.sweeperAge = scanner.nextInt();

                if (this.sweeperAge < 18 || this.sweeperAge > 50) {
                    throw new SweeperException("AGE ERROR");
                }

                System.out.print("Dati inatimea maturatorului: ");
                this.sweeperHeight = scanner.nextFloat();

                if (this.sweeperHeight < 100 || this.sweeperHeight > 200)
                {
                    throw new SweeperException("HEIGHT ERROR");
                }

                System.out.print("Dati greutatea maturatorului: ");
                this.sweeperWeight = scanner.nextFloat();

                if (this.sweeperWeight < 70 || this.sweeperWeight > 150)
                {
                    throw new SweeperException("WEIGHT ERROR");
                }

                System.out.print("Dati numele maturatorului: ");
                this.sweeperName = scanner.next();

                if (this.sweeperName.isBlank()) {
                    throw new SweeperException("Name ERROR");
                }

            }catch (SweeperException exception)
            {
                flag = true;
                System.out.println(exception.getMessage());
            }catch (InputMismatchException exception)
            {
                flag = true;
                scanner.nextLine();
            }
        }
        while (flag);
        this.broomUsing = new int[broomCount];
        totalBroomCount+=broomCount;
        /*
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

        /*
         * random.nextFloat nu are parametrul bound, din aceasta cauza utilizam formula:
         * random.nextFloat * (Max - Min) + Min, pentru a primi o valoare intre Min si Max
         */
        this.sweeperHeight = random.nextFloat()*(180-150)+150;
        this.sweeperWeight = random.nextFloat()*(100-70)+70;

        /*
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
        try {
            if (totalBroomCount > 0) {
                Sweeper.totalBroomCount = totalBroomCount;
            }
            else
                {
                    throw new SweeperException("Total Broom Count ERROR");
                }
        } catch (SweeperException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void setBroomCount(int broomCount) {
        try {
            if (broomCount > 0) {
                this.broomCount = broomCount;
                this.broomUsing = new int[broomCount];
            } else {
                throw new SweeperException("Invalid Broom Count");
            }
        } catch (SweeperException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void setBroomUsing(int[] broomUsing) {
        this.broomUsing = broomUsing;
    }
    //Try
    public void setSweeperAge(int sweeperAge) {
        try {
            if (sweeperAge < 18 || sweeperAge > 50)
            {
                this.sweeperAge = sweeperAge;
            }
            else
                {
                    throw new SweeperException("Sweeper Age Error");
                }
        } catch (SweeperException exception) {
            System.out.println(exception.getMessage());
        }
    }
//Try in Try
    public void setSweeperHeight(float sweeperHeight) {
        try {
            try {
                if (sweeperHeight < 70 || sweeperHeight > 150)
                {
                    throw new SweeperException("Height Error");
                }
                else
                    {
                        this.sweeperHeight = sweeperHeight;
                    }
            } catch (SweeperException exception) {
                System.out.println(exception.getMessage());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void setSweeperWeight(float sweeperWeight) {
        try {
            if (sweeperWeight< 70 || sweeperWeight > 150)
            {
                throw new SweeperException("Weight Error");
            }
        } catch (SweeperException exception) {
            System.out.println(exception.getMessage());
        }
        this.sweeperWeight = sweeperWeight;
    }

    public void setSweeperName(String sweeperName) {
        try {
        if (sweeperName.isBlank()) {
            throw new SweeperException("ERROR NAME");
        }
            } catch (SweeperException exception) {
            System.out.println(exception.getMessage());
            }
        }

    /**
     * Metoda statică, care compară doi măturători
     * după hărnicie, după numarul de mature uzate (suma coificienţilor de uzare)
     * @param sweeper1 -> primul maturator
     * @param sweeper2 -> al doilea maturator
     */
    public static Sweeper whoIsBetter(Sweeper sweeper1, Sweeper sweeper2)
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

    public static void printToFile(Sweeper[] sweepers)
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
}

