package Lab_2.Assets.Interface;

public interface IWeapon {
    default void reload()
    {
        System.out.println("I'm reloading, cover me!");
    }
    void shoot();
}
