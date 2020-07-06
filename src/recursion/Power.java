package recursion;

public class Power {
    public static void main(String args[]) {
        System.out.println(power(2,9));
    }
    static long power(int x, int n) {
        if(n == 0) {
            return 1;
        }
        long p = power(x,n/2);
        p = p * p;
        if(n%2 ==1){
            p = x * p;
        }
        return p;
    }
}
