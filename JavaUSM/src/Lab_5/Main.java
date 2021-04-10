package Lab_5;

import Lab_5.assets.MyThread;

/*
Se dă matrice de tip long. De divizat matricea pe coloane, fiecare coloană fiind atribuită unui fir de execuție separat.
Fiecare fir trebuie să găsească numărul de elemente negative în coloana prelucrată. În main de afișat produsul rezultatelor
firelor. De utilizat interfața Runnable.
*/

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < MyThread.getRow(); i++) {
            new MyThread(i).run();
        }
        MyThread.printMatrix();
    }
}
