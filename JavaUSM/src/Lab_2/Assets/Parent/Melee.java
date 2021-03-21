package Lab_2.Assets.Parent;

import Lab_2.Assets.Interface.IMelee;
import Lab_2.Assets.WeaponType;

import java.util.Scanner;


public abstract class Melee implements IMelee {
    private String name;
    private double price;
    private final WeaponType WEAPONTYPE = WeaponType.Melee;
    private double damage;

    public Melee(String name, double price, double damage) {
        this.name = name;
        this.price = price;
        this.damage = damage;
    }
    public Melee()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = scanner.next();

        System.out.print("Price: ");
        this.price = scanner.nextDouble();

        System.out.print("Damage: ");
        this.damage = scanner.nextDouble();
        scanner.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public WeaponType getWEAPONTYPE() {
        return WEAPONTYPE;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Melee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", WEAPONTYPE=" + WEAPONTYPE +
                ", damage=" + damage +
                '}';
    }

    public static Melee whoIsBetter(Melee weapon1, Melee weapon2)
    {
        double weapon1Statistics = weapon1.damage;
        double weapon2Statistics = weapon2.damage;
        if (weapon1Statistics > weapon2Statistics)
        {
            return weapon1;
        }
        return weapon2;
    }
}
