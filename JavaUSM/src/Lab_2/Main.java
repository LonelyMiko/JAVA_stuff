package Lab_2;

import Lab_2.Assets.Child.AK47;
import Lab_2.Assets.Child.Pistol;
import Lab_2.Assets.Parent.Weapon;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------- AK-47 --------------------------------");
        AK47 ak47 = new AK47();
        System.out.println(ak47.toString());

        System.out.println("-------------------------------- Pistol --------------------------------");
        Pistol pistol = new Pistol();
        System.out.println(pistol.toString());

    }
}
