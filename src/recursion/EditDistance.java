package recursion;

public class EditDistance {
    public static void main(String args[]) {
        String src ="hello";
        String dest = "boello";
        System.out.println(minEditDistance(src,dest,0,0));
    }
    private static int minEditDistance(String src,String dest,int srcIdx,int destIdx) {
        //base case
        if(srcIdx ==src.length() && destIdx == dest.length()) return 0;
        if(srcIdx == src.length() && destIdx != dest.length()) return dest.length()-destIdx;
        if(srcIdx != src.length() && destIdx == dest.length()) return src.length()-srcIdx;
        if(src.charAt(srcIdx)== dest.charAt(destIdx)){
            return minEditDistance(src,dest,srcIdx+1,destIdx+1);
        }
        else {
            return Math.min(Math.min(minEditDistance(src,dest,srcIdx+1,destIdx+1),
                    minEditDistance(src,dest,srcIdx,destIdx+1)),
                    minEditDistance(src,dest,srcIdx+1,destIdx))+1;
        }
    }
}
