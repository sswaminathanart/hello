package recursion;

public class Fact {
    public static void main(String args[]){
        System.out.println(fact(5));
        System.out.println(factiterative(5));
    }
    static int fact(int n) {
        if(n==0) {
            return 1;
        }
        return n * fact(n-1);
    }
    static int factiterative(int n) {
        int fact = 1;
        for(int i=1;i<=5;i++) {
            fact = fact * i;
        }
        return fact;
    }
}
