package Lesson6;

public class Array_with_4and1 {
    public static void main(String[] args) {
        int[] array = {5,2,1,78,0,1,9};

        Array_with_4and1 array_with_1_4 = new Array_with_4and1();
        boolean answer = array_with_1_4.checkFor1and4(array);
        System.out.println(answer);

    }
    public boolean checkFor1and4(int[] array){
        boolean result = false;
        for (int c: array) {
            if(c == 1 || c == 4){
                result = true;
                break;
            }
        }
        return result;
    }
}
