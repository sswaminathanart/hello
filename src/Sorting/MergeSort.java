package Sorting;

public class MergeSort {
    static int[] x ={5,2,1,8,4};

    private static void mergeSort(int start,int end) {
        //Base case
        if(start >= end) return;
        //int mid = start + (end - start)/2;
        int mid = start +(end-start)/2;
        mergeSort(start,mid);//mid-1
        mergeSort(mid+1,end);//mid
        merge(start,mid,end);
    }
    private static void merge(int start,int mid,int end) {
        /* We need to splic the array into 2 left and right
        First array size is till mid and Second array size is mid +1 till end
         */
        int leftArraySize = (mid-start +1);
        int rightArraySize = end - mid;

        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i= 0; i<leftArraySize; i++) {
            leftArray[i] = x[(start + i)];
        }

        for (int i = 0; i< rightArraySize; i++) {
            rightArray[i] = x[mid  +1 +i ];
        }

        int leftArrayIncrementer = 0;

        int rightArrayIncrementer = 0;

        int arrayIncrementer = start;

        while (leftArrayIncrementer < leftArraySize && rightArrayIncrementer < rightArraySize) {

            if(leftArray[leftArrayIncrementer] <= rightArray[rightArrayIncrementer]) {
                x[arrayIncrementer] = leftArray[leftArrayIncrementer];
                leftArrayIncrementer ++;
            }
            else  {
                x[arrayIncrementer] = rightArray[rightArrayIncrementer];
                rightArrayIncrementer ++;
            }
            arrayIncrementer ++;
        }

        while (leftArrayIncrementer < leftArraySize ) {
            x[arrayIncrementer] = leftArray[leftArrayIncrementer];
            leftArrayIncrementer ++;
            arrayIncrementer ++;
        }

        while (rightArrayIncrementer < rightArraySize ) {
            x[arrayIncrementer] = rightArray[rightArrayIncrementer];
            rightArrayIncrementer ++;
            arrayIncrementer ++;
        }

    }
    public static void main(String args[]){
        System.out.println("BEFORE MERGE SORT");
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        mergeSort(0,x.length-1);
        System.out.println("AFTER MERGE SORT");
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
    }
}
