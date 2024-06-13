// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    
    boolean[] seen;
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<String> cons = new ArrayList<>();
        seen = new boolean[words.length];
        dfs(words, cons, "");
        
        List<Integer> res =new ArrayList<>();
        for(String con : cons){
            res.add(s.indexOf(con));
        }
        
        return res;
        
    }
    
    private void dfs(String[] words, List<String> cons, String curr){
        
        if(curr.length()==words[0].length() * words.length){
            cons.add(curr);
            return;
        }
        
        for(int i =0; i<words.length;i++){
            if(seen[i]==false){
                seen[i]=true;
                dfs(words, cons, curr+words[i]);
                seen[i]=false;    
            }
        }
        
        
    }
}