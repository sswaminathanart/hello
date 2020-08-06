package DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBrack {
    public static String[] wordBreak(String s,String[] words){

        Set<String> setOfAccounts = new HashSet<>(Arrays.asList(words));
        List<String> str=wordBreak(s,setOfAccounts);
        return str.toArray(new String[str.size()]);
    }
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<String>();

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=null){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(sub);
                            pos[j]=list;
                        }else{
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

        if(pos[s.length()]==null){
            return new ArrayList<String>();
        }else{
            ArrayList<String> result = new ArrayList<String>();
            dfs(pos, result, "", s.length());
            return result;
        }
    }
    public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
            dfs(pos, result, combined, i-s.length());
        }
    }
    public static void main(String args[]) {
        String str[] ={"kick",
                "start",
                "kickstart",
                 "is",
                "awe",
                "some",
                "awesome"};
        for(String result:wordBreak("kickstartisawesome",str )) {
         System.out.println(result);
        }


    }
}
