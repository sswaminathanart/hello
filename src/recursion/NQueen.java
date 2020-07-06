package recursion;

public class NQueen {
    public static void main(String[] args) {
        int size = 5;
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }
        permut(arr,0);
    }
    private static void permut(int[] arr,int idx) {
        if(idx==arr.length && isSafe(arr)) {
            for(int i=0;i<arr.length;i++){
               System.out.print(arr[i]);
            }
            System.out.println();
            printQue(arr);
        }
        for (int j=idx;j<arr.length;j++) {
            swap(arr,idx,j);
            permut(arr,idx+1);
            swap(arr,idx,j);
        }

    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static boolean isSafe(int[] arr){
        for (int i=0;i<arr.length-1;i++){
                if(Math.abs(i-(i+1))==Math.abs(arr[i]-arr[i+1])){
                    return false;
                }
        }
        return true;
    }
    static void printQue(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                if(i==arr[j]) {
                    System.out.print("Q");
                }
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }

}