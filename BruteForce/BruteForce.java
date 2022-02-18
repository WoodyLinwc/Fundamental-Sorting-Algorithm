import java.util.Arrays;

public class BruteForce{

    public static void main(String[] args) {
        // sorted array using brute force search algorithm
        int[] exampleArray = {5,4,3,2,1,7,9,10};
        Boolean runTime = true;

        printOutBlank();
        // calculate the runtime of the algorithm
        while(runTime){
            long startTime=System.nanoTime();
            BruteForce.bubbleSort(exampleArray);
            long endTime=System.nanoTime();
            System.out.printf("sorted array using bubble sort = %s\n",Arrays.toString(exampleArray));
            System.out.println("the runtime is "+(endTime-startTime)+"ns");
            runTime = false;
        }



        printOutBlank();
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

    public static void swap(int[] array, int from, int to){
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public static void printOutBlank() {
        System.out.println("");
    }

    // public static void shuffle(int[] array) {
        
    // }
}