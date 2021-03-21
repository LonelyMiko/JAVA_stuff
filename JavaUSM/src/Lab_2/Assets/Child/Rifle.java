package Lab_2.Assets.Child;

import Lab_2.Assets.Parent.Weapon;

import java.util.Map;
import java.util.Scanner;

public class Rifle extends Weapon {
    private boolean hasRedDotScope;
    public Rifle() {
        super();
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("Does this Rifle have a scope?");
        System.out.println("TYPE \"YES\" OR \"NO\"");
        choice = scanner.next();
        if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no") )
        {
            System.out.println("You know I hate you, right?");
            this.hasRedDotScope = false;
        }
        if (choice.equalsIgnoreCase("yes"))
        {
            this.hasRedDotScope = true;
            Map<String,Double> statitics = super.getStatistics();
            statitics.put("RANGE",statitics.get("RANGE")+100);
        }
        else
            {
                this.hasRedDotScope = false;
            }
    }

    private void setRedDotScope(boolean hasRedDotScope)
    {
        if (hasRedDotScope)
        {
            this.hasRedDotScope = true;
            Map<String,Double> statitics = super.getStatistics();
            statitics.put("RANGE",statitics.get("RANGE")+100);
        }
        else
        {
            this.hasRedDotScope = false;
        }
    }

    @Override
    public void shoot() {
        System.out.println("(╯°□°)--︻╦╤─ - - -");
    }

    @Override
    public void isAmmoExtended() {
        if (super.getAmmoExtended()) {
            super.setAmmoCapacity((byte) (super.getAmmoCapacity() + 50));
        }
    }
}
