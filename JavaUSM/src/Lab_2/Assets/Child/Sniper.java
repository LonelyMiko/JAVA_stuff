package Lab_2.Assets.Child;

import Lab_2.Assets.Parent.Weapon;

import java.util.Map;
import java.util.Scanner;

public class Sniper extends Weapon {
    static Scanner scanner = new Scanner(System.in);

    public boolean isHasLongRangeScope() {
        return hasLongRangeScope;
    }

    private boolean hasLongRangeScope;
    public Sniper() {
        super();
        System.out.println("Does your weapon have an long range scope");
        System.out.println("TYPE \"YES\" OR \"NO\"");
        String choice = scanner.next();
        if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no") )
        {
            System.out.println("You know I hate you, right?");
            this.hasLongRangeScope = false;
        }
        if (choice.equalsIgnoreCase("yes"))
        {
            this.hasLongRangeScope = true;
            Map<String,Double> statistics = super.getStatistics();
            statistics.put("RANGE",statistics.get("RANGE")+150);
        }
    }

    @Override
    public void shoot() {
        System.out.println("(　-_･) ︻デ═一 ▸");
    }

    @Override
    public void isAmmoExtended() {
        if (super.getAmmoExtended())
        {
            super.setAmmoCapacity((byte) (super.getAmmoCapacity() + 5));
        }
    }
}
