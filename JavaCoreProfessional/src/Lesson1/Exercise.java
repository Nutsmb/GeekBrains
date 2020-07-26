package Lesson1;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise <T extends Object> {

    public static void main(String[] args) {
        ArrayList str = new ArrayList<String>();
        String[] mass  = new String[5];
        //Integer[] mass  = new Integer[5];
        //Double[] mass  = new Double[5];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = "el" + i;
            //mass[i] = i;
            //mass[i] = (double)i;
        }

        Elements obj = new Elements(mass);
        obj.printArr();
        obj.swaping(2,3);
        obj.printArr();

        Collections.addAll(str, mass); //преобразуем массив в ArrayList
    }
}

class Elements<T extends Object> {
    private T[] arr;

    public Elements(T[] _arr) {
        this.arr = _arr;
    }

    public void swaping(int first, int second) {
        T tmp;
        tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    public void printArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
