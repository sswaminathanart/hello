package ArrayAndAdhoc;

public class MagicSquar {
    static int[] x = new int[9];
    static void buildMagicSquare() {
        swap(1,2);
        swap(3,0);
        swap(1,3);
        swap(5,6);
        swap(6,7);
        swap(7,8);
        swap(7,1);

    }
    public static void main(String args[]) {
        int ran =(int)(Math.random()) + 1;
        for(int i=0;i<9;i++) {
            x[i] = ran + i;
        }
        buildMagicSquare();
        for(int i=0;i<9;i++) {
            if(i%3==0) {
                System.out.println();
            }
            System.out.print("\t "+x[i]);
        }
    }
    public static void swap(int i,int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
}
