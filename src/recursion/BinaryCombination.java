package recursion;

public class BinaryCombination {
    public static void main(String args[]){
        binaryCombination(3);
    }
    public static void binaryCombination(int n) {
        int[] arr = new int[n];
        binaryCombinationHelper(arr,0);
        binaryCombinationHelper1to10(arr,0);
    }
    public static void binaryCombinationHelper(int[] arr,int idx){
        //base case
        if(idx == arr.length){
            for(int i=0;i<arr.length;i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
        arr[idx] = 0;
        binaryCombinationHelper(arr,idx+1);
        arr[idx] = 1;
        binaryCombinationHelper(arr,idx+1);

    }
    public static void binaryCombinationHelper1to10(int[] arr,int idx){
        //base case
        if(idx == arr.length){
            for(int i=0;i<arr.length;i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
    for(int i=0;i<=9;i++){
        arr[idx] = i;
        binaryCombinationHelper1to10(arr,idx+1);
    }
    }

}
