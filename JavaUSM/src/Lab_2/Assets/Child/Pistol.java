package Lab_2.Assets.Child;

import Lab_2.Assets.Parent.Weapon;
import Lab_2.Assets.WeaponType;

import java.util.Map;
import java.util.Scanner;

public class Pistol extends Weapon {
    private boolean hasSuppressor;

    public Pistol() {
        super();
        selectSuppressor();
    }

    public Pistol(String name, WeaponType weaponType, String bulletType, double price,
                  byte ammoCapacity, boolean isAmmoExtended, Map<String, Double> statistics, boolean hasSuppressor) {
        super(name, weaponType, bulletType, price, ammoCapacity, isAmmoExtended, statistics);
        this.hasSuppressor = hasSuppressor;
    }

    public boolean isHasSuppressor() {
        return hasSuppressor;
    }

    public void setHasSuppressor(boolean hasSuppressor) {
        this.hasSuppressor = hasSuppressor;
    }


    @Override
    public void shoot() {
        if (hasSuppressor) {
            System.out.println("/̵͇̿̿/'̿̿ ̿̿ ̿̿");
        }
        else
            {
                System.out.println("┌( ͡° ͜ʖ ͡°)=ε/̵͇̿̿/’̿’̿ ̿");
            }
    }

    @Override
    public void isAmmoExtended() {
        if (super.getAmmoExtended()) {
            super.setAmmoCapacity((byte) (super.getAmmoCapacity() + 5));
        }
    }
    public void selectSuppressor()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Does this gun have an suppressor?");
        System.out.println("TYPE \"YES\" OR \"NO\"");
        String choice = scanner.next();
        if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no") )
        {
            System.out.println("You know I hate you, right?");
            this.hasSuppressor = false;
        }
        if (choice.equalsIgnoreCase("yes"))
        {
            this.hasSuppressor = true;
        }
        scanner.close();
    }
}
