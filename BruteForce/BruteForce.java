/*
    Author: Woody Lin 林万程
    The github page: https://github.com/WoodyLinwc/Fundamental-Sorting-Algorithm
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
import java.util.Random;

public class BruteForce{

    static int arraySize; // the size of the array

    public static void main(String[] args) {
        boolean runTime = true;
        boolean validInput = false;
        // create a TreeMap object to store the runtimes with distinct integers
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
        // create a TreeMap object to store the runtimes with duplicate integers
        TreeMap<Integer, String> tm2 = new TreeMap<Integer, String>();

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

        // generate random integer between 0 to 20
        int[] randomArray = new int[arraySize];
        Random randomInt = new Random(); 
        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = randomInt.nextInt(20);
        }

        // shuffle the example array
        BruteForce.shuffle(exampleArray);

        printDashLine();
        System.out.printf("the randomized array with distinct integer = %s\n", Arrays.toString(exampleArray));
        printOutBlank();
        System.out.printf("the randomized array with duplicate integers = %s\n", Arrays.toString(randomArray));

        // calculate the runtime of algorithms with distinct integers
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
            BruteForce.selectionSort(exampleArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Selection Sort");
            System.out.printf("sorted array using selection sort = %s\n", Arrays.toString(exampleArray));
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

        if(runTime){
            printOutBlank();
            BruteForce.shuffle(exampleArray);
            long startTime = System.nanoTime();
            BruteForce.mergeSort(exampleArray, 0, arraySize - 1);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Merge Sort");
            System.out.printf("sorted array using merge sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (elapsedTime) + "ns");
        }

        if(runTime){
            printOutBlank();
            BruteForce.shuffle(exampleArray);
            long startTime = System.nanoTime();
            BruteForce.quickSort(exampleArray, 0, arraySize - 1);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Quick Sort");
            System.out.printf("sorted array using quick sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (elapsedTime) + "ns");
        }

        if(runTime){
            printOutBlank();
            BruteForce.shuffle(exampleArray);
            long startTime = System.nanoTime();
            BruteForce.countingSort(exampleArray, arraySize);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm.put(elapsedTime, "Counting Sort");
            System.out.printf("sorted array using counting sort = %s\n", Arrays.toString(exampleArray));
            System.out.println("the algorithm runtime is "+ (elapsedTime) + "ns");
        }

        // calculate the runtime of algorithms with duplicate integers
        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.bubbleSort(randomArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Bubble Sort");
        }
        
        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.optimizedBubbleSort(randomArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Optimized Bubble Sort");
        }

        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.insertionSort(randomArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Insertion Sort");
        }

        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.heapSort(randomArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Heap Sort");
        }

        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.selectionSort(randomArray);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Selection Sort");
        }
        
        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.shellSort(randomArray, arraySize);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Shell Sort");
        }
        
        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.mergeSort(randomArray, 0, arraySize - 1);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Merge Sort");
        }
        
        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.quickSort(randomArray, 0, arraySize - 1);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Quick Sort");
        }

        if(runTime){
            BruteForce.shuffle(randomArray);
            long startTime = System.nanoTime();
            BruteForce.countingSort(randomArray, arraySize);
            long endTime = System.nanoTime();
            int elapsedTime = (int)(endTime - startTime);
            tm2.put(elapsedTime, "Counting Sort");
        }

        printOutBlank();
        // arrange the algorithm runtime from most efficient to least efficient
        @SuppressWarnings("rawtypes")
        Set set = tm.entrySet();
        @SuppressWarnings("rawtypes")
        Iterator i = set.iterator();

        System.out.println("the algorithm runtime in ascending order with " + arraySize + " distinct integers:");
        while(i.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getValue() + " < ");
        }

        printOutBlank();
        printOutBlank();
        // arrange the algorithm runtime from most efficient to least efficient (duplicate integers)
        @SuppressWarnings("rawtypes")
        Set set2 = tm2.entrySet();
        @SuppressWarnings("rawtypes")
        Iterator i2 = set2.iterator();

        System.out.println("the algorithm runtime in ascending order with " + arraySize + " duplicate integers:");
        while(i2.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry me2 = (Map.Entry)i2.next();
            System.out.print(me2.getValue() + " < ");
        } 
        printOutBlank();
        printDashLine();
    }

    /*
    -------------------------------------------------
    Code Implementation of Various Sorting Algorithms
    -------------------------------------------------
    */

    // Bubble Sort, Reference: https://www.programiz.com/dsa/bubble-sort
    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                    // int temp = array[j];
                    // array[j] = array[j+1];
                    // array[j+1] = temp;
                }
            }
        }
    }

    // Optimized Bubble Sort, Reference: https://www.programiz.com/dsa/bubble-sort
    public static void optimizedBubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // if the array is already sorted, meaning no iteration is required, 
            // then exit the algorithm
            if(!swapped){ // swapped == false
                break;
            }
        }
    }

    // Insertion Sort, Reference: https://www.geeksforgeeks.org/insertion-sort/
    public static void insertionSort(int[] array) {
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

    // Selection Sort, Reference: https://www.programiz.com/dsa/selection-sort
    public static void selectionSort(int[] array) {

        for (int step = 0; step < arraySize - 1; step++) {
          int min_idx = step;
    
          for (int i = step + 1; i < arraySize; i++) {
    
            // to sort in descending order, change > to < in this line.
            // select the minimum element in each loop.
            if (array[i] < array[min_idx]) {
              min_idx = i;
            }
          }
    
        // put min at the correct position, 
        // swap function is not working here
        // swap(array, array[step], array[min_idx]);
        int temp = array[step];
        array[step] = array[min_idx];
        array[min_idx] = temp;
        }
    }

    // Shell Sort, Reference: https://www.programiz.com/dsa/shell-sort
    public static void shellSort(int[] array, int size) {
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

    // Heap sort, Reference: https://www.geeksforgeeks.org/heap-sort/
    public static void heapSort(int[] array) {
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
    public static void heapify(int[] array, int heapSize, int root) {
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

    // Merge Sort, Reference: https://www.programiz.com/dsa/merge-sort
    public static void mergeSort(int[] array, int l, int r){
        if (l < r) {
            // Find the middle point
            int mid = (l + r) / 2;
  
            // Sort first and second halves
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, r);
  
            // Merge the sorted halves
            merge(array, l, mid, r);
        }
    }
    public static void merge(int[] array, int l, int mid, int r) {
        // find sizes of two sub-arrays to be merged
        int n1 = mid - l + 1;
        int n2 = r - mid;
  
        // create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        // copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];
  
        /* Merge the temp arrays */
  
        // initial indexes of first and second sub-arrays
        int i = 0, j = 0;
  
        // initial index of merged sub-array array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
  
        // copy remaining elements of L[] if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
  
        // copy remaining elements of R[] if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort, Reference: https://www.geeksforgeeks.org/quick-sort/
    public static void quickSort(int[] array, int low, int high) {
        if (low < high){
            // pi is partitioning index, array[p] is now at right place
            int pi = partition(array, low, high);
 
            // Separately sort elements before partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        // index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);
 
        for(int j = low; j <= high - 1; j++) {
         
            // if current element is smaller than the pivot
            if (array[j] < pivot) {
             
            // increment index of smaller element
            i++;
            swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    // Counting Sort, Reference: https://www.programiz.com/dsa/counting-sort
    public static void countingSort(int[] array, int size) {
        int[] output = new int[size + 1];
    
        // find the largest element of the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
          if (array[i] > max)
            max = array[i];
        }
        int[] count = new int[max + 1];
    
        // initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
          count[i] = 0;
        }
    
        // store the count of each element
        for (int i = 0; i < size; i++) {
          count[array[i]]++;
        }
    
        // store the cumulative count of each array
        for (int i = 1; i <= max; i++) {
          count[i] += count[i - 1];
        }
    
        // find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
          output[count[array[i]] - 1] = array[i];
          count[array[i]]--;
        }
    
        // copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
          array[i] = output[i];
        }
    }
    
    /*
    -------------------------------------------------
    Code Implementation of Helper function in the File
    -------------------------------------------------
    */

    // function overload, not yet
    public static void swap(int[] array, int from, int to){
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public static void shuffle(int[] array) {
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