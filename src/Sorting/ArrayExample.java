package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayExample {
    static int[] x = {5,9,12,44,73};
    public static void main(String args[]){
        int val =12;
        for (int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        int idx = binarySearch(0,x.length-1,val);
        if(idx== -1)
        System.out.println(" Value "+ val +" not found in the array");
        else System.out.format("Value %d found in the array in %d",val,idx+1);
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(9);
        Collections.sort(arrayList);
        for(int i=0;i<arrayList.size();i++) {
            if(i==0 || arrayList.get(i-1) != arrayList.get(i)) {
                System.out.println("\n Sri" + arrayList.get(i));
            }
        }
    }

    public static int binarySearch(int start, int end, int val) {
        //Base case
        if (start >= end )  return -1;
            int mid = start + (end-start)/2;
            if (val == x[mid]) return mid;
            if(val < x[mid]) return binarySearch(start, mid-1,val);
            if(val>x[mid]) return binarySearch(mid+1,end,val);
       return -1;
    }
}
