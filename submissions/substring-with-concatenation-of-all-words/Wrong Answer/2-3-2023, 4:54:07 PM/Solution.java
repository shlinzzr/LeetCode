// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<String> list = new ArrayList<>();
        
        int len = words.length;
        boolean[] used = new boolean[len];
        
        dfs(words, "", list, used);
        
        List<Integer> res = new ArrayList<>();
        for(String l : list){
            
            if(s.indexOf(l)>-1)
                res.add(s.indexOf(l));
        }
        
        return res;
        
    }
    
    
    private void dfs(String words[], String curr, List<String> list, boolean[] used){
        
        int wLen = words[0].length();
        int len = words.length;
        if(curr.length()==wLen*len){
            list.add(curr);
            return;
        }
        
        
        for(int i=0; i<len; i++){
            if(used[i]==false){
                used[i]=true;
                dfs(words, curr+words[i], list, used);
                used[i]=false;
            }
        }
        
        
    }
}