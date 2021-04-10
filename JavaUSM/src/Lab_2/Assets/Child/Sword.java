package Lab_2.Assets.Child;

import Lab_2.Assets.Interface.IMelee;
import Lab_2.Assets.Parent.Melee;

import java.util.Scanner;

public class Sword extends Melee {
    private boolean isExcalibur;

    public Sword(String name, double price, double damage, boolean isExcalibur) {
        super(name, price, damage);
        this.isExcalibur = isExcalibur;
    }

    public Sword() {
        super();
    }

    public boolean isExcalibur() {
        return isExcalibur;
    }

    public void setExcalibur(boolean excalibur) {
        this.isExcalibur = excalibur;
    }

    @Override
    public void throwMelee() {
        if (isExcalibur)
        {
            System.out.println("You just threw your legendary sword");
        }
        else {
            System.out.println("Remember, my son, never throw away your weapon, especially when you have no other");
        }
    }

    @Override
    public void hit() {
        System.out.println("You just hit a man, he's hurt and crying, go apologize");
    }
    public void selectIsExcalibur()
    {
        System.out.println("Does your weapon have an underbarrel?");
        System.out.println("TYPE \"YES\" OR \"NO\"");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no") )
        {
            System.out.println("You know I hate you, right?");
            this.isExcalibur = false;
        }
        if (choice.equalsIgnoreCase("yes"))
        {
            this.isExcalibur = true;
        }
        scanner.close();
    }
}
