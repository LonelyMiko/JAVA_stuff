package Lab_4.assets;


import java.util.Scanner;

public class Broom {
    Scanner scanner = new Scanner(System.in);
    private int broomUsing;
    private String color;
    private String material;

    /**
     * Constructor implicit
     */
    public Broom() {
        System.out.print("Dati numarul de uzare a maturei: ");
        this.broomUsing = scanner.nextInt();
        this.broomUsing = Math.min(this.broomUsing,5);
        System.out.print("Dati culoarea maturi: ");
        this.color = scanner.next();
        System.out.print("Dati materialul maturii: ");
        this.material = scanner.next();
    }

    /**
     * Consturctor cu parametri
     * @param broomUsing indica utilizarea unei maturi
     * @param color culoarea maturii
     * @param material materialul maturii
     */
    public Broom(int broomUsing, String color, String material) {
        this.broomUsing = Math.min(broomUsing, 5);
        this.color = color;
        this.material = material;
    }

    /**
     * Getters and Setters
     */
    public int getBroomUsing() {
        return broomUsing;
    }

    public void setBroomUsing(int broomUsing) {
        this.broomUsing = broomUsing;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Broom{" +
                "broomUsing=" + broomUsing +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

}
