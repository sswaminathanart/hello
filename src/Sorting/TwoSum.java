package Sorting;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static int[] x ={5,2,1,8,4};
    static int target  =  6;
    public static void main(String args[]) {
        boolean b = isPossibleExtraSpace(x, target);
        if (b) {
            System.out.println("possible");
        }
    }
    private static boolean isPossible(int[] arr, int target) {
        for(int i=0;i<arr.length;i++) {
            int comp = target - arr[i];
            for (int j=i+1;j<arr.length;j++) {
                if(comp == arr[j]){
                    return true;
                }
            }
        }
       return false;
    }
    private static boolean isPossibleExtraSpace(int[] arr, int target) {
        Map<Integer,Integer> lookup = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            lookup.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++) {
            int comp = target - arr[i];
            if(lookup.containsKey(comp)){
                return true;
            }
        }
        return false;
    }
    private static boolean isPossibleExtraSpaceOneIteration(int[] arr, int target) {
        Map<Integer,Integer> lookup = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int comp = target - arr[i];
            if(lookup.containsKey(comp)){
                return true;
            }
            else {
                lookup.put(arr[i],i);
            }
        }
        return false;
    }


}
