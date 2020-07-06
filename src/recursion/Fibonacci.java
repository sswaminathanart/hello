package recursion;

public class Fibonacci {
    public static void main(String args[]) {
        System.out.println(fibo(6));
        int[] x =fibomemoization(6);
        for(int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        fiboiterative(6);
    }
    static int fibo(int n) {
        if(n ==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
    static int[] fibomemoization(int n) {
        int[] result = new int[(n+1)];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i<=n;i++)
        {
            result[i] = result[i-1] + result[i-2];
        }
        return result;
    }
    static void fiboiterative(int n) {
        int f = 0;
        int s = 1;
        int count =0;
        while (count <= 6){
            System.out.println(f);
            int t = f + s;
            f = s;
            s = t;
            count++;

        }
    }
}
