package DynamicPrograming;

public class KnightsTour {

    static  int[][] NEIGHBOURS = {
            {4,6},//0
            {6,8},//1
            {7,9},//2
            {4,8},//3
            {0,3,9},//4
            {},//5
            {0,1,7},//6
            {2,6},//7
            {1,3},//8
            {2,4}//9
    };
    static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        long[] dpTable = new long[10];
        long[] temp = new long[10];
        for(int d=0;d<10;d++){
            dpTable[d] = 1;
        }
        for(int i=1;i<phonenumberlength;i++){
            for(int d=0;d<10;d++){
                for(int j : NEIGHBOURS[d]){
                    temp[d] += dpTable[j];
                }
            }
            for(int d=0;d<10;d++){
                dpTable[d] = temp[d];
                temp[d] = 0;
            }
        }
        return dpTable[startdigit];

    }
    public static void main(String args[]) {
        System.out.println(numPhoneNumbers(1,3));
    }
}
