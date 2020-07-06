package Sorting;

public class QuickSort {
    static int[] x ={5,2,1,8,4};
    private static void swap(int i,int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    private static int choosePivot(int start,int end) {
        /*
        Random random = new Random();
        int randomNumber = random.nextInt(end - start) + start;
         */
        return (int) (Math.random() * (end - start)) + start;
        //return start;
    }
    private static int partition(int start, int end, int piovt){
        swap(end,piovt);
        int i = start;
        for(int current= start;current<end;current++) {
            if(x[current] <= x[end]) {
                swap(current,i);
                i++;
            }
        }
        swap(i,end);
        return i;
    }
    private static void quickStort(int start,int end) {
        if(start == end) return;
        if(start>end) return;
        int pivot = choosePivot(start,end);
        int p = partition(start, end, pivot);
        quickStort(start,p-1);
        quickStort(p+1,end);
    }
    public static void main(String args[]) {
        System.out.println("BEFORE QUICK SORT");
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        quickStort(0,x.length-1);
        System.out.println("AFTER QUICK SORT");
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
    }
}
