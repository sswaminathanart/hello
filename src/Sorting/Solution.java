package Sorting;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.ArrayList;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
        for(int i =1;i<=days;i++) {
            int[] temparr = new int[states.length];
            for(int j=0;j<states.length;j++) {
                if(j==0 && states[1]== 0) {
                    temparr[j] = 0;
                }
                if(j==0 && states[1] != 0) {
                    temparr[j] = 1;
                }
                if(j==states.length-1 && states[states.length-2]== 0) {
                    temparr[j] = 0;
                }
                if(j==states.length-1 && states[states.length-2]!= 0) {
                    temparr[j] = 1;
                }
                if(j!=0 && j!=states.length-1 && states[j-1]==states[j+1]) {
                    temparr[j] = 0;
                }
                if(j!=0 && j!=states.length-1 && states[j-1]!=states[j+1]) {
                    temparr[j] = 1;
                }
            }
            for(int k=0;i<temparr.length;k++) {
                states[k] = temparr[k];
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<states.length;i++) {
            result.add(states[i]);
        }
        return result;
    }
    public static void main(String args[]) {
        int[] xxxx=  {1,0,0,0,0,1,0,0};
        List<Integer> result = cellCompete(xxxx, 1);
        for(Integer iii: result) {
            System.out.println(iii);
        }
    }
    // METHOD SIGNATURE ENDS
}
