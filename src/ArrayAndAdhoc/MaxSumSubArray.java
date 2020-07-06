package ArrayAndAdhoc;

public class MaxSumSubArray {
    static class MaxSum{
        int startIdx;
        int endIdx;
        int maxSum;
        MaxSum(int s,int e,int sum){
            startIdx = s;
            endIdx = e;
            maxSum = sum;
        }
    }
    public static void main(String args[]) {
        int[] x = new int[5];
        for(int i= 0;i<x.length;i++) {
            x[i] = i-1;
        }
        for(int i= 0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        maxSumSubArrayO3(x);
        maxSumSubArrayO2(x);
        for(int i= 0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        MaxSum maxSum = maxSumSubArrayDivideAndConcur(x,0,x.length-1);
        System.out.println("MaxSum "+ maxSum.maxSum);
        System.out.println("MaxSum start index "+ maxSum.startIdx);
        System.out.println("MaxSum end index "+ maxSum.endIdx);
        System.out.println("MaxSum Kadanis "+ kadanesalgo(x).maxSum);
        System.out.println("MaxSum start index "+ kadanesalgo(x).startIdx);
        System.out.println("MaxSum end index "+ kadanesalgo(x).endIdx);

    }
    public static void maxSumSubArrayO3(int arr[]) {
        int maxSum = 0;
        for (int start = 0; start < arr.length; start++) {
            for(int end = 0; end<start; end++) {
                int sum = 0;
                for(int i =end; i<=start;i++){
                    sum = sum + arr[i];
                    if(sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println("Max Sum " +maxSum);
    }
    public static void maxSumSubArrayO2(int arr[]) {
        int maxSum = 0;
        for (int start = 0; start < arr.length; start++) {
            int sum = 0;
            for(int end = start; end<arr.length; end++) {
                    sum = sum + arr[end];
                    if(sum > maxSum) {
                        maxSum = sum;
                    }
            }
        }
        System.out.println("Max Sum " +maxSum);
    }
    // divide and concur
    // ans is in left function (arr, start, mid-1)
    // ans is in right function (arr, mid+1, end)
    // or in the mid max of left + max of right + mid
    public static MaxSum maxSumSubArrayDivideAndConcur(int arr[], int start,int end) {
        //base case
        if (start == end) {
            return new MaxSum( start, end, arr[start]);
        }
        if (start > end) {
            return new MaxSum(-1, -1, Integer.MIN_VALUE);
        }
        int mid = start + (end - start)/2;
        MaxSum leftMax = maxSumSubArrayDivideAndConcur(arr, start, mid-1);
        MaxSum rightMax = maxSumSubArrayDivideAndConcur(arr, mid+1, end);
        MaxSum crossingMidMAc = crossingMid(arr, start, mid, end);
        if(leftMax.maxSum >= rightMax.maxSum && leftMax.maxSum >= crossingMidMAc.maxSum) {
            return leftMax;
        }
        else if(rightMax.maxSum >= crossingMidMAc.maxSum) {
            return rightMax;
        }
        else {
            return crossingMidMAc;
        }
    }

    static MaxSum crossingMid(int arr[], int l,
                              int m, int h)
    {
        // Include elements on left of mid.
        int leftSum = 0;
        int maxStartIdx = -1;
        int leftMaxSum = 0;
        for (int i = m; i >= l; i--)
        {
            leftSum = leftSum + arr[i];
            if (leftSum > leftMaxSum) {
                leftMaxSum = leftSum;
                maxStartIdx = i;
            }

        }

        // Include elements on right of mid
        int rightSum = 0;
        int maxEndIdx = -1;
        int rightMaxSum = 0;
        for (int i = m+1 ; i <= h; i++)
        {
            rightSum = rightSum + arr[i];
            if (rightSum > rightMaxSum) {
                rightMaxSum = rightSum;
                maxEndIdx = i;
            }
        }

        // Return sum of elements on left
        // and right of mid
        return new MaxSum( maxStartIdx, maxEndIdx, (leftMaxSum + rightMaxSum));
    }
    public static MaxSum kadanesalgo(int[] arr){
        int max_sum_so_for = 0;
        int max_sum_ending_here = 0;
        int maxStartIdx = -1;
        int maxEndIdx = -1;

        for(int currentStartIdx = 0, currentEndIdx=0; currentEndIdx<arr.length; currentEndIdx++){
            max_sum_ending_here += arr[currentEndIdx];

            if(max_sum_ending_here>max_sum_so_for){
                max_sum_so_for = max_sum_ending_here;
                maxEndIdx = currentEndIdx;
                maxStartIdx = currentStartIdx;
            }
            if(max_sum_ending_here<0){
                max_sum_ending_here =0;
                currentStartIdx = currentEndIdx + 1;
            }
        }
        MaxSum returnObj =new MaxSum(maxStartIdx, maxEndIdx, max_sum_so_for);
        return returnObj;
    }

}
