package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] array){
        for(int i = 0; i<array.length; i++)
            for(int j = 1; j<array.length - i; j++)
                if(array[j]<array[j-1])
                    swapArrayVals(array, j);
    }
    private static void swapArrayVals(int[] array, int j){
        int temp = array[j]; 
        array[j] = array[j-1];
        array[j-1] = temp;
    }
    public static void main(String[] names){
        int [] numbers = {};
         BubbleSort.sort(numbers);
         System.out.println(Arrays.toString(numbers));
    }
}