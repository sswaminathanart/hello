package recursion;

public class PatternMatching {
    public static void main(String args[]) {
        String str = "hello";
        String pattern = "h*l?o";
        boolean b = isPatternMatch(str, pattern,0,0);
        System.out.println(b);
    }
    private static boolean isPatternMatch(String str,String pattern,int strIdx,int patternIdx) {
        //base cases
        if(patternIdx == pattern.length()){
            return (strIdx==str.length());
        }
        if(strIdx == str.length()){
            boolean allStart = true;
            for(int j=patternIdx;j<pattern.length();j++){
                if(pattern.charAt(j)!='*'){
                    allStart= false;
                    j=pattern.length();
                }
            }
            return allStart;
        }
        if(pattern.charAt(patternIdx)=='?' || pattern.charAt(patternIdx)== str.charAt(strIdx)){
            return isPatternMatch(str,pattern,strIdx+1,patternIdx+1);
        }
        if(pattern.charAt(patternIdx)=='*'){
            return isPatternMatch(str,pattern,strIdx+1,patternIdx)|| isPatternMatch(str,pattern,strIdx,patternIdx+1);
        }
        return false;
    }
}
