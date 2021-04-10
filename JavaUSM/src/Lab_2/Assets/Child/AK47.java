package Lab_2.Assets.Child;


import Lab_2.Assets.Parent.Weapon;
import Lab_2.Assets.WeaponType;

import java.util.Map;
import java.util.Scanner;

public class AK47 extends Weapon {
    static Scanner scanner = new Scanner(System.in);;
    private boolean hasUnderbarrel;
    private int underbarrelAmmoCapacity;

    @Override
    public void shoot() {
        System.out.println("Tra - tra - tra");
    }

    @Override
    public void isAmmoExtended() {
        if (super.getAmmoExtended())
        {
            super.setAmmoCapacity((byte) (super.getAmmoCapacity() + 15));
        }
    }

    public AK47(String name, WeaponType weaponType, String bulletType, double price,
                byte ammoCapacity, boolean isAmmoExtended, Map<String, Double> statistics, boolean hasUnderbarrel) {
        super(name, weaponType, bulletType, price, ammoCapacity, isAmmoExtended, statistics);
        this.hasUnderbarrel = hasUnderbarrel;
        isAmmoExtended();
        setUnderbarrelAmmoCapacity();
    }

    public AK47() {
        super();
        isAmmoExtended();
        selectUnderbarrelAmmoCapacity();

    }

    public void setUnderbarrelAmmoCapacity() {
        if (this.hasUnderbarrel)
        {
            this.underbarrelAmmoCapacity = 5;
        }
        else
            {
                this.underbarrelAmmoCapacity = 0;
            }
    }
    public void selectUnderbarrelAmmoCapacity()
    {
        String choice;
        System.out.println("Does this gun have an underbarrel");
        System.out.println("TYPE \"YES\" OR \"NO\"");
        choice = scanner.next();

        if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no") )
        {
            System.out.println("You know I hate you, right?");
            this.hasUnderbarrel = false;
            this.underbarrelAmmoCapacity = 0;
        }

        if (choice.equalsIgnoreCase("yes"))
        {
            this.hasUnderbarrel = true;
            this.underbarrelAmmoCapacity = 5;
        }
        else
            {
                this.hasUnderbarrel = false;
                this.underbarrelAmmoCapacity = 0;
            }
    }
}
