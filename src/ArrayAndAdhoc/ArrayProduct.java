package ArrayAndAdhoc;

public class ArrayProduct {
    /*
     * Complete the getProductArray function below.
     */
    static int[] getProductArray(int[] nums) {
        /*
         * Write your code here.
         */
        int MOD = (int)(Math.pow(10, 9)+7);
        int n = nums.length;
        int[] prod = new int[n];

         /* In this loop, leftProduct contains product of
           elements on left side excluding nums[i] */
        int leftProduct = 1;
        for(int i=0; i<n; i++){
            prod[i] = leftProduct;
            nums[i] = nums[i] > 0 ? nums[i] : (MOD + nums[i]) % MOD;
            leftProduct = (int)((leftProduct * 1l * nums[i]) % MOD);
        }

         /* In this loop, rightProduct contains product of
           elements on right side excluding nums[i] */
        int rightProduct = 1;
        for(int i = n-1; i>=0; i--){
            prod[i] = (int)((prod[i] * 1l * rightProduct) % MOD);
            rightProduct = (int)((rightProduct * 1l* nums[i]) % MOD);
        }
        return prod;
    }

    public static void main(String args[]) {
        int x[] ={1,2,3,4,5};
        int[] result = getProductArray(x);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }
}
