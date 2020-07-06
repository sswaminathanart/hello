package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecomposition {
    public static void main(String args[]){
        String s[] = generate_palindromic_decompositions("abracadabra");
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }
    static String[] generate_palindromic_decompositions(String s) {
        List<String> results = new ArrayList<>();

        int n = s.length();
        generate(s.toCharArray(), 0, new char[2 * n], 0, results);

        return results.toArray(new String[results.size()]);
    }

    static void generate(char[] s, int pos, char[] out, int j, List<String> results) {
        if(pos == s.length) {
            results.add(new String(out, 0, j-1));
            return;
        }
        //Subset problem only inclution logic
        for(int i = pos; i < s.length; i++) {
            int lengthOfCharAdded = i-pos;
            out[j + lengthOfCharAdded] = s[i];
            if(isPalindrome(s, pos, i)) {
                out[j + (i-pos) + 1] = '|';
                generate(s, pos + lengthOfCharAdded + 1, out, j + lengthOfCharAdded + 2 /* 1 for | and 1 for next char*/, results);
            }
        }
    }



    static boolean isPalindrome(char[] arr, int lo, int hi) {
        while(lo < hi) {
            if(arr[lo] != arr[hi]) {
                return false;
            }
            lo++; hi--;
        }
        return true;
    }
}
