package recursion;

public class SubSet {
    public static void main(String args[]){
        int[] x = {1,2,3};
        int[] subsetx = new int[x.length];
        subset(x,subsetx,0,0);
    }
    static void subset(int[] srcArray,int[] subSetArray,int srcIdx,int subSetIdx) {
        //Base Case
        if(srcIdx == srcArray.length){
            System.out.print("{");
            for(int i=0;i<subSetIdx;i++) {
                System.out.print(subSetArray[i] +" ");
            }
            System.out.print("}\n");
            return;
        }
        //Exclution
        subset(srcArray, subSetArray, srcIdx+1, subSetIdx);
        //Inclution
        subSetArray[subSetIdx] = srcArray[srcIdx];
        subset(srcArray, subSetArray, srcIdx+1, subSetIdx+1);
    }
}
