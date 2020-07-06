package recursion;

public class Palindrom {
    public static void main(String args[]) {
        String s ="ammb";
        System.out.println("StringExamples " + s + " is " + isPalindrom(s,0,s.length()-1) +" Palindrom.");
        s = "malayalam";
        System.out.println("StringExamples " + s + " is " + isPalindrom(s,0,s.length()-1)+" Palindrom.");
        System.out.println("StringExamples " + s + " is " + isPalindromrecursion(s)+" Palindrom.");
        System.out.println("StringExamples " + "ammb" + " is " + isPalindromrecursion("ammb")+" Palindrom.");
    }
    static boolean isPalindrom(String str,int start,int end) {
        while (start < end) {
            if(str.charAt(start) == str.charAt(end)){
                start ++;
                end --;
            }
            else {
                return false;
            }
        }
        if(start >= end) {
            return true;
        }
        return false;
    }
    static boolean isPalindromrecursion(String str) {
        if(str.length()<=1) {
            return true;
        }
        if(str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalindromrecursion(str.substring(1,(str.length()-1)));
        }
        else {
            return false;
        }
    }
}
