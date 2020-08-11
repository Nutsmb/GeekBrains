package Lesson6;

import java.util.ArrayList;

public class Arrays_with_4 {
    public static void main(String[] args) {
        //int[] numbers = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        //int[] numbers = {2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int[] numbers = {3, 4, 1, 5, 9, 4, 4, 7, 8, 6};


        Arrays_with_4 arrays_with_4 = new Arrays_with_4();
        int[] arrList = arrays_with_4.getAfterLast4(numbers);

        for (int cell : arrList) {
            System.out.print(cell + " ");
        }
    }

    public int[] getAfterLast4(int[] array){
        ArrayList<Integer> arr = new ArrayList();
        for (int i = array.length - 1; i >= 0 && array[i] != 4; i--) {
            arr.add(array[i]);
        }
        if(arr.size() == array.length){
            throw new RuntimeException("Exception: в исходном массиве нет 4!");
        }

        int[] array1 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array1[i] = arr.get(arr.size() - (1+i));
        }

        return array1;
    }
}
