class Main {
 public static void main(String[] args) {
  
   // create an array
   int[] age = {12, 4, 5};
  
  // create a 2d array
        int[][] a = {
            {1, -2, 3}, 
            {-4, -5, 6, 9}, 
            {7}, 
        };

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
        // first for...each loop access the individual array
        // inside the 2d array
        for (int[] innerArray: a) {
            // second for...each loop access each element inside the row
            for(int data: innerArray) {
                System.out.println(data);
            }
        }
 }
}
