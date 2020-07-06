package Sorting;

public class QuickSelect {
    static int[] x ={5,2,1,8,4};
    private static void swap(int i,int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    public static void main(String args[]) {
        System.out.println(quickSelect(3));
    }
    private static int choosePivot(int start,int end) {
        /*
        Random random = new Random();
        int randomNumber = random.nextInt(end - start) + start;
         */
        //return (int) (Math.random() * (end - start)) + start;
        return start;
    }
    public static int quickSelect(int index) {
        return quickSelectHelper(0,x.length-1,index);
    }
    public static int quickSelectHelper(int start,int end,int index) {
        if (start >= end) return -1;
        int p = choosePivot(start,end);
        swap(p,end);
        int i = start;
        for (int curr =start;curr<end;curr++) {
            if(x[curr]<=x[end]){
                swap(curr,i);
                i++;
            }
        }
        swap(end,i);
        if(i==index) {
            return x[index];
        }
        else if(i<index){
            return quickSelectHelper(start,index-1,index);
        }
        else {
            return quickSelectHelper(index+1,end,index);
        }
    }
}
