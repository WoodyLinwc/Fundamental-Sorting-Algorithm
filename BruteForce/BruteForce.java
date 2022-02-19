/*
    Author: Woody Lin 林万程
    The github page: https://github.com/WoodyLinwc/BruteForceSearchAlgorithm
    Feel free to reach out to me for any advice and concern regarding this file.
    Gmail: wancheng.lin1@gmail.com
 */
import java.util.Arrays;
import java.lang.Math;

public class BruteForce{
    public static int size = 50; // the size of the array

    public static void main(String[] args) {
        // sorted array using brute force search algorithm
        int[] exampleArray = new int[size];
        for (int i = 0; i < size; i++) {
            exampleArray[i] = i;
        }
        // shuffle the example array
        BruteForce.shuffle(exampleArray);
        Boolean runTime = true;

        printDashLine();
        System.out.printf("the randomized array = %s\n", Arrays.toString(exampleArray));
        // calculate the runtime of the algorithm
        while(runTime){
            printOutBlank();
            long startTime = System.nanoTime();
            BruteForce.bubbleSort(exampleArray);
            long endTime = System.nanoTime();
            System.out.printf("sorted array using bubble sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (endTime - startTime) + "ns");
            runTime = false;
        }

        runTime = true;
        while(runTime){
            printOutBlank();
            long startTime = System.nanoTime();
            BruteForce.optimizedBubbleSort(exampleArray);
            long endTime = System.nanoTime();
            System.out.printf("sorted array using optimized bubble sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (endTime - startTime) + "ns");
            runTime = false;
        }


        printDashLine();
    }

    // Bubble Sort
    public static void bubbleSort(int array[]) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j+1]){
                    swap(array, j, j+1);
                    // int temp = array[j];
                    // array[j] = array[j+1];
                    // array[j+1] = temp;
                }
            }
        }
    }

    // Optimized Bubble Sort
    public static void optimizedBubbleSort(int array[]) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j+1]){
                    swap(array, j, j+1);
                    swapped = true;
                }
            }
            // if the array is already sorted, meaning no iteration is required, then exit the algorithm
            if(!swapped){ // swapped == false
                break;
            }
        }
    }

    

    // function overload, not yet
    public static void swap(int[] array, int from, int to){
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public static void shuffle(int [] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int index = (int) (Math.random() * array.length);
            swap(array, i, index);
        }
    }

    public static void printOutBlank() {
        System.out.println("");
    }

    public static void printDashLine() {
        for (int i = 0; i < 60; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}