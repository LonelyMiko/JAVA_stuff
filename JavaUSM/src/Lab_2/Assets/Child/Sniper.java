package Lab_2.Assets.Child;

import Lab_2.Assets.Parent.Weapon;

public class Sniper extends Weapon {
    private boolean hasLongRangeScope;
    public Sniper() {
        super();
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
