package Lab_2;

import Lab_2.Assets.Child.*;
import Lab_2.Assets.Parent.Weapon;

public class Main {
    //I'm tired
    public static void main(String[] args) {
        Weapon[] weapons = new Weapon[5];
        Sword[] swords = new Sword[1];

        weapons[0] = new AK47();
        weapons[1] = new Pistol();
        weapons[2] = new Rifle();
        weapons[3] = new Shotgun();
        weapons[4] = new Sniper();

        swords[0] = new Sword();

        String weaponType = "";
        for (Weapon weapon : weapons)
        {
            if (weapon instanceof AK47)
            {
                weaponType = "AK - 47";
            }
            if (weapon instanceof  Pistol)
            {
                weaponType = "Pistol";
            }
            if (weapon instanceof  Rifle)
            {
                weaponType = "Rifle";
            }
            if (weapon instanceof Shotgun)
            {
                weaponType = "Shotgun";
            }
            if (weapon instanceof Sniper)
            {
                weaponType = "Sniper";
            }

            System.out.println("---------------------------------------" + weaponType + "---------------------------------------");
            weapon.shoot();
            System.out.println();
        }

    }
}
