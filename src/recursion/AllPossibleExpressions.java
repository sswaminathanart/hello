package recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleExpressions {
    public static void main(String args[]){
        String[] s =generate_all_expressions("22200",44);
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }

    }
    public static String[] generate_all_expressions(String num,long target){
        List<String> result = new ArrayList<>();
        char[] digits = num.toCharArray();
        char[] path = new char[num.length() * 2 - 1];
        long currentVal = 0;
        for (int i = 0; i < digits.length; i++) {
            path[i] = digits[i];
            currentVal = currentVal * 10 + digits[i] - '0';
            compute(result, digits, i+1, path, i+1, 0, currentVal, target);

        }
        return result.toArray(new String[result.size()]);
    }
    public static void compute(List<String> result,
                               char[] digitArray,
                               int digitArrayIdx,
                               char[] exprArray,
                               int exprArrayIdx,
                               long sumSoFor,
                               long currentVal,
                               long target) {
        //Base Case
        if(digitArrayIdx == digitArray.length) {
            if(sumSoFor + currentVal == target){
                result.add(new String(exprArray,0,exprArray.length));
            }
            return;
        }
        long n = 0;
        int expincr = exprArrayIdx + 1;
        for(int i=digitArrayIdx; i< digitArray.length; i++){
            n = n * 10 +digitArray[i] - '0';
            exprArray[expincr] = digitArray[i];
            expincr = expincr +1; //next char is '+' or '*'
            exprArray[exprArrayIdx] = '*';
            compute(result,digitArray,i+1,exprArray,expincr,sumSoFor,currentVal*n,target);
            exprArray[exprArrayIdx] = '+';
            compute(result,digitArray,i+1,exprArray,expincr,sumSoFor+currentVal,n,target);

        }
    }
}
