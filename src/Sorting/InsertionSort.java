package Sorting;

public class InsertionSort {

    static int[] x ={5,2,1,8,4};

    static void insertionSortRecursive(int arr[], int n)
    {
        // Base case
        if (n <= 0)
            return;

        // Sort first n-1 elements
        insertionSortRecursive( arr, n-1 );

        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n];
        int j = n-1;

    /* Move elements of arr[0..i-1], that are
      greater than key, to one position ahead
      of their current position */
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j=j-1;
        }
        arr[j+1] = last;
    }

    private static void insertionSortIterative() {
        // One element array is sorted by itself
        if (x.length <= 1) return;
        for(int i=1;i<x.length;i++) {
            int temp = x[i];
            int j = i-1 ;
            while (j >=0  && temp < x[j]) {
                x[j+1] = x[j];
                j = j - 1;
            }
            x[j+1] = temp;
        }
    }


    public static void main(String args[]) {
        System.out.println("BEFORE INSERTION SORT");
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        insertionSortIterative();
        System.out.println("AFTER INSERTION SORT");
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        int[] yyy ={5,2,1,8,4};
        insertionSortRecursive(yyy,yyy.length-1);
        System.out.println("AFTER INSERTION SORT");
        for (int i=0;i<yyy.length;i++) {
            System.out.println(yyy[i]);
        }
    }
}
