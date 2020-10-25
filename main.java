public class main {
    public static void main(String[] args) {
        String str = new String("Java"); // str = Java
        System.out.println(str.concat(" Hot")); //print Java Hot
        System.out.println(str); // str is still = Java

        StringBuilder strbild = new StringBuilder("Java"); //strbild = Java
        System.out.println(strbild.append(" Hot")); //strbild is now = Java Hot
        System.out.println(strbild); //print Java Hot

        strbild.insert(1,"g");
        System.out.println(strbild); // print Jgava Hot

        strbild.deleteCharAt(1);
        System.out.println(strbild); // print Java Hot
    }
}
