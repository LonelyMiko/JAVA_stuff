class Main {
 public static void main(String[] args) {
  
   // create an array
   int[] age = {12, 4, 5};

   // loop through the array
   // using for loop
   System.out.println("Accessing Elements of Array:");
   for(int i = 0; i < age.length; i++) {
     System.out.println("Element " + i +": " + age[i]);
   }
   
   // loop through the array
   // using for each
    for(int a : age) {
     System.out.println("Element: " + a);
   }
 }
}