package Lab_2.Assets.Parent;

import Lab_2.Assets.Interface.IWeapon;
import Lab_2.Assets.WeaponType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Weapon implements IWeapon {
    Scanner scanner;

    private String name;
    private String bulletType;
    private WeaponType weaponType;
    private double price;
    private byte ammoCapacity;
    private boolean isAmmoExtended;

    private Map<String,Double> statistics = new HashMap<>();

    public Weapon(String name, WeaponType weaponType, String bulletType,
                  double price, byte ammoCapacity, boolean isAmmoExtended, Map<String, Double> statistics) {
        this.name = name;
        this.weaponType = weaponType;
        this.bulletType = bulletType;
        this.price = price;
        this.ammoCapacity = ammoCapacity;
        this.isAmmoExtended = isAmmoExtended;
        this.statistics = statistics;
    }

    public Weapon() {
        scanner = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = scanner.next();
        selectWeaponType();
        System.out.print("Bullet Type: ");
        this.bulletType = scanner.next();
        System.out.print("Price: ");
        this.price = scanner.nextDouble();
        System.out.print("Ammo Capacity: ");
        this.ammoCapacity = scanner.nextByte();
        selectIsAmmoExtended();
        selectStatistics();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public String getBulletType() {
        return bulletType;
    }

    public void setBulletType(String bulletType) {
        this.bulletType = bulletType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte getAmmoCapacity() {
        return ammoCapacity;
    }

    public void setAmmoCapacity(byte ammoCapacity) {
        this.ammoCapacity = ammoCapacity;
    }

    public void setAmmoExtended(boolean ammoExtended) {
        isAmmoExtended = ammoExtended;
    }

    public boolean getAmmoExtended()
    {
        return this.isAmmoExtended;
    }

    public Map<String, Double> getStatistics() {
        return statistics;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", weaponType=" + weaponType +
                ", bulletType='" + bulletType + '\'' +
                ", price=" + price +
                ", ammoCapacity=" + ammoCapacity +
                ", isAmmoExtended=" + isAmmoExtended +
                ", statistics=" + statistics +
                '}';
    }

    public void setStatistics(Map<String, Double> statistics) {
        this.statistics = statistics;
    }

    public abstract void isAmmoExtended();


    public static Weapon whoIsBetter(Weapon weapon1,Weapon weapon2)
    {
        double weapon1Statistics = weapon1.statistics.values().stream().reduce(0.0,Double::sum);
        double weapon2Statistics = weapon2.statistics.values().stream().reduce(0.0,Double::sum);
        if (weapon1Statistics > weapon2Statistics)
        {
            return weapon1;
        }
        return weapon2;
    }
    public void selectWeaponType()
    {
        System.out.println("Select Weapon Type:");
        System.out.println("1. Shotguns");
        System.out.println("2. Sniper");
        System.out.println("3. Pistols");
        System.out.println("4. Assault");
        System.out.println("5. MachineGuns");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> this.weaponType = WeaponType.Shotguns;
            case 2 -> this.weaponType = WeaponType.Sniper;
            case 3 -> this.weaponType = WeaponType.Pistols;
            case 4 -> this.weaponType = WeaponType.Assault;
            case 5 -> this.weaponType = WeaponType.MachineGuns;
            default -> {
                System.out.println("Oh, look who can't choose the type of weapon with his fat fingers, so I'll have to choose for you");
                this.weaponType = WeaponType.WEAPON;
            }
        }
    }

    public void selectIsAmmoExtended()
    {
        String choice;
        System.out.println("Does this gun have an enlarged magazine?");
        System.out.println("TYPE \"YES\" OR \"NO\"");
        choice = scanner.next();
        if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no") )
        {
            System.out.println("You know I hate you, right?");
            this.isAmmoExtended = false;
        }
        if (choice.equalsIgnoreCase("yes"))
        {
            this.isAmmoExtended = true;
        }
    }
    public void selectStatistics()
    {
        scanner = new Scanner(System.in);
        System.out.println("DAMAGE: ");
        statistics.put("DAMAGE",scanner.nextDouble());

        System.out.println("FIRE RATE: ");
        statistics.put("FIRE RATE",scanner.nextDouble());

        System.out.println("ACCURACY: ");
        statistics.put("ACCURACY",scanner.nextDouble());

        System.out.println("RANGE: ");
        statistics.put("RANGE",scanner.nextDouble());

        System.out.println("CLIP SIZE: ");
        statistics.put("CLIP SIZE",scanner.nextDouble());

    }
}
