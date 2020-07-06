package ArrayAndAdhoc;

public class NextPalindromicNumber {
    static long next_palindrome(int x) {
        if (x < 0) {
            return -1;
        }
        if(x==9) return 11;
        //special case: 100 -> 101 palindrome is closest
        if (x != 1 && isPower10(x)) {
            return x + 1;
        }
        String value = x + "";
        int inputLength = value.length();
        //first half
        String first1 = value.substring(0, ((inputLength + 1) / 2));
        long palindrome1 = Long.parseLong(reflect(first1, inputLength / 2));

        //if the "lower" palindrome is found, increase by 1 or if the "higher" palindrome is found, decrease by 1
        int twiddleDirection = palindrome1 <= x ? 1 : -1;
        String first2 = (Integer.parseInt(first1)  + twiddleDirection) + "";
        long palindrome2 = Long.parseLong(reflect(first2, inputLength / 2));
        if(palindrome2<palindrome1) palindrome2=palindrome1;
        //if palindrome2 has more of a distance than palindrome1, return palindrome1 (smallest)
        return palindrome2;
    }
    public static String reflect(String left, int n) {
        String reverse = new StringBuilder(left.substring(0, n)).reverse().toString();
        return left + reverse;
    }
    public static boolean isPower10(int x) {
        while (x > 9 && x % 10 == 0)
            x /= 10;
        return x == 1;
    }
    public static void main(String args[]) {
        System.out.println(next_palindrome(8));
    }
}
