package recursion;

public class TargetSum {
    public static void main(String args[]) {
        int[] x ={2,4,8,0,0,-8};
        int k = 6;
        boolean s = targetsum(x,k);
        if(s) {
            System.out.println("Possible");
        }
        else {
            System.out.println("Not Possible");
        }
        int[] subSetArray = new int[x.length];
        helperall(x,0,subSetArray, 0, k);
    }
    static boolean targetsum(int[] srcArray,int target) {
        return helper(srcArray,0,0,target,false);
    }
    static boolean helper(int[] srcArray,int srcIdx,int sumSoFor,int target,boolean isPossible) {
        if(srcIdx == srcArray.length) {
            return isPossible && sumSoFor == target;
        }
        //inclution
        if(helper(srcArray,srcIdx+1,sumSoFor+srcArray[srcIdx],target,true)) {
            return true;
        }
        //exclution
        return helper(srcArray,srcIdx+1,sumSoFor,target,isPossible);
    }
    static void helperall(int[] srcArray,int srcIdx,int[] subsetArray,int subSetIdx, int target) {
        if(srcIdx >= srcArray.length) {
            int sum =0;
            int i=0;
            for(;i<subSetIdx;i++) {
                sum = sum + subsetArray[i];
            }

            if(sum == target && i == subSetIdx) {
                System.out.println();
                for(i=0;i<subSetIdx;i++) {
                    System.out.print(subsetArray[i] +" ");
                }
            }
            return;
        }
        //exclution
        helperall(srcArray,srcIdx+1,subsetArray,subSetIdx,target);
        //inclution
        subsetArray[subSetIdx] = srcArray[srcIdx];
        helperall(srcArray,srcIdx+1,subsetArray,subSetIdx+1,target);
        }
}
