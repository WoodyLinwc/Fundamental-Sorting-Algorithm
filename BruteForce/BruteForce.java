/*
    Author: Woody Lin 林万程
    The github page: https://github.com/WoodyLinwc/Brute-Force-Sorting-Algorithm
    Feel free to reach out to me for any advice and concern regarding this file.
    Gmail: wancheng.lin1@gmail.com
 */
import java.lang.Math;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class BruteForce{

    public static int arraySize; // the size of the array

    public static void main(String[] args) {
        boolean runTime = true;
        boolean validInput = false;
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

        // check if user has entered a valid input
        Scanner scan = new Scanner(System.in);

        do {
            try {
                System.out.print("Please specify the size of the array: ");
                arraySize = scan.nextInt();
                validInput = true;
            } catch (Exception e) {
                printOutBlank();
                System.out.println("Input must be an integer...Please try again.");
                scan.reset();
                scan.next();
            }
        } while(validInput == false); 
        scan.close();


        // sorted array using brute force search algorithm
        int[] exampleArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            exampleArray[i] = i;
        }
        // shuffle the example array
        BruteForce.shuffle(exampleArray);

        printDashLine();
        System.out.printf("the randomized array = %s\n", Arrays.toString(exampleArray));
        // calculate the runtime of algorithms
        if(runTime){
            printOutBlank();
            long startTime = System.nanoTime();
            BruteForce.bubbleSort(exampleArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Bubble Sort");
            System.out.printf("sorted array using bubble sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (elapsedTime) + "ns");
        }

        if(runTime){
            printOutBlank();
            BruteForce.shuffle(exampleArray);
            long startTime = System.nanoTime();
            BruteForce.optimizedBubbleSort(exampleArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Optimized Bubble Sort");
            System.out.printf("sorted array using optimized bubble sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (elapsedTime) + "ns");
        }

        if(runTime){
            printOutBlank();
            BruteForce.shuffle(exampleArray);
            long startTime = System.nanoTime();
            BruteForce.heapSort(exampleArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Heap Sort");
            System.out.printf("sorted array using heap sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (elapsedTime) + "ns");
        }

        if(runTime){
            printOutBlank();
            BruteForce.shuffle(exampleArray);
            long startTime = System.nanoTime();
            BruteForce.insertionSort(exampleArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Insertion Sort");
            System.out.printf("sorted array using insertion sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (elapsedTime) + "ns");
        }

        if(runTime){
            printOutBlank();
            BruteForce.shuffle(exampleArray);
            long startTime = System.nanoTime();
            BruteForce.shellSort(exampleArray, arraySize);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Shell Sort");
            System.out.printf("sorted array using shell sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (elapsedTime) + "ns");
        }

        printOutBlank();
        // arrange the algorithm runtime from most efficient to least efficient
        @SuppressWarnings("rawtypes")
        Set set = tm.entrySet();
        @SuppressWarnings("rawtypes")
        Iterator i = set.iterator();

        System.out.println("the algorithm runtime in ascending order:");
        while(i.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getValue() + " < ");
          }        
        printOutBlank();
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

    // Heap sort
    public static void heapSort(int array[]) {
        // the array length is the same as the global variable "arraySize"
        for (int i = arraySize / 2 - 1; i >= 0; i--) {
            heapify(array, arraySize, i);
        }

        for (int i = arraySize - 1; i > 0; i--) {
            // move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }
    public static void heapify(int array[], int heapSize, int root) {
        int largest = root; // initialize the largest as root
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // if left child is larger than root
        if (left < heapSize && array[left] > array[largest])
            largest = left;
 
        // if right child is larger than largest so far
        if (right < heapSize && array[right] > array[largest])
            largest = right;
 
        // if largest is not root
        if (largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;
 
            // recursively heapify the affected sub-tree
            heapify(array, heapSize, largest);
        }
    }

    // Insertion Sort
    public static void insertionSort(int array[]) {
        // the array length is the same as the global variable "arraySize"
        for (int i = 0; i < arraySize; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Shell Sort
    public static void shellSort(int array[], int size) {
        // int size is the array size
        // start with a big interval, then reduce the interval
        for (int interval = size / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < size; i += 1) {
                int temp = array[i];
                int j;
                
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    array[j] = array[j - interval];
                }
                array[j] = temp;
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
            int index = (int) (Math.random() * n);
            swap(array, i, index);
        }
    }

    public static void printOutBlank() {
        System.out.println();
    }

    public static void printDashLine() {
        for (int i = 0; i < 60; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}