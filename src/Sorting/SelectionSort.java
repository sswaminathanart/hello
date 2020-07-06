package Sorting;

public class SelectionSort {
    static int[] x ={5,2,1,8,4};
    private static void swap(int i,int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    private static void selectionSort(){
        for(int i=0;i<x.length;i++) {
            for(int j=i+1; j<x.length;j++) {
                if(x[i] > x[j]) {
                    swap(i,j);
                }
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("BEFORE SELECTION SORT");
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        selectionSort();
        System.out.println("AFTER SELECTION SORT");
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
    }
}
