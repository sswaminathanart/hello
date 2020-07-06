package recursion;

public class Permutation {
    public static void main(String args[]) {
        int[] src = {1,2,3,4};
        //permutation(src,0);
        permutationWithRep(src,0);
    }
    static void permutation(int[] srcArray,int srcIdx) {
        //Base Case
        if(srcIdx == srcArray.length){
            for(int i=0;i<srcArray.length;i++) {
                System.out.print(srcArray[i]+"   ");
            }
            System.out.println();
        }
        for(int i=srcIdx;i<srcArray.length;i++){
            swap(srcArray,i,srcIdx);
            permutation(srcArray,srcIdx+1);
            swap(srcArray,i,srcIdx);
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void permutationWithRep(int[] srcArray,int srcIdx) {
        //Base Case
        if(srcIdx == srcArray.length){
            for(int i=0;i<srcArray.length;i++) {
                System.out.print(srcArray[i]+"   ");
            }
            System.out.println();
        }
        for(int i=srcIdx;i<srcArray.length;i++){
            swap(srcArray,i,srcIdx);
            permutationWithRep(srcArray,srcIdx+1);
            swap(srcArray,i,srcIdx);
        }
    }
}
