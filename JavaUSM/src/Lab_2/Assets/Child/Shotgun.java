package Lab_2.Assets.Child;

import Lab_2.Assets.Parent.Weapon;

public class Shotgun extends Weapon {
    public Shotgun() {
        super();
    }

    @Override
    public void shoot() {
        System.out.println("︻┳═一");
    }

    @Override
    public void isAmmoExtended() {
        if (super.getAmmoExtended())
        {
            super.setAmmoCapacity((byte) (super.getAmmoCapacity() + 2));
        }
    }


}
