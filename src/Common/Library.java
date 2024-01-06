package Common;

import java.util.Random;
import java.util.Scanner;

public class Library {

    public int getArraySize(String promt) {
        int a;
        Scanner sc = new Scanner(System.in);
            System.out.print(promt + ": ");
            String s = sc.nextLine();
            a = Integer.parseInt(s);
        return a;
    }

    public int[] createArray(int size_Array) {
        int[] array = new int[size_Array];
        Random rd = new Random();
        for (int i = 0; i < size_Array; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    public void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("");
    }

}