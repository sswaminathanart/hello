package Sorting;

import java.util.Random;

public class RadixSort {
    static int[] x = new int[1500];
    public static void main(String args[]) {
        for (int i = 0; i < x.length; i++) {
            Random r = new Random();

            x[i] = r.nextInt(9999);
        }
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        int max = getMax();
        for(int digit=1; max/digit > 0 ;digit*=10) {
            radixSort(digit);
        }
        System.out.println("\n Max = "+ max);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
    // A utility function to get maximum value in arr[]
    static int getMax()
    {
        int mx = x[0];
        for (int i = 1; i < x.length; i++)
            if (x[i] > mx)
                mx = x[i];
        return mx;
    }
    static void radixSort(int digit) {
        int output[] = new int[x.length];
        int digitArray[]  = new int[10];
        for(int i=0;i<10;i++) {
            digitArray[i] = 0;
        }
        for(int i=0; i<x.length;i++){
            int digitValue = (x[i]/digit)%10;
            digitArray[digitValue]++;
        }
        for(int i =1; i<10;i++) {
            digitArray[i] += digitArray[i-1];
        }
        for(int i=x.length-1;i>=0;i--) {
            int digitValue = (x[i]/digit)%10;
            output[digitArray[digitValue]-1] = x[i];
            digitArray[digitValue]--;
        }
        for(int i=0;i<x.length;i++) {
            x[i] = output[i];
        }
    }
}
