package recursion;

public class FindAllWellFormedBrackets {
    public static void main(String args[]) {
        wellFormedBrackets(3,3,"");
    }
    private static void wellFormedBrackets(int left,int right,String brackets) {
        //base case
        if(right<=0){
            System.out.println(brackets);
            return;
        }
        if(left>0){
            wellFormedBrackets(left-1,right,brackets +"(");
            if(right>left){
                wellFormedBrackets(left,right-1,brackets+")");
            }
        }
        else if(right>0) {
            wellFormedBrackets(left,right-1,brackets+")");
        }
    }
}
