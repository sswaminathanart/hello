package Sorting;

public class BubbleSort {
    static int[] x ={5,2,1,8,4};
    private static void swap(int i,int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    private static void bubbleSort() {
        for(int i=0;i<x.length;i++) {
            for(int j=x.length-1; j>i;j--) {
                if(x[j] < x[j-1]){
                    swap(j,j-1);
                }
            }
        }
    }
    public static void main(String args[]) {
            System.out.println("BEFORE BUBBLE SORT");
            for (int i=0;i<x.length;i++) {
                System.out.println(x[i]);
            }
            bubbleSort();
            System.out.println("AFTER BUBBLE SORT");
            for (int i=0;i<x.length;i++) {
                System.out.println(x[i]);
            }
        }
}
