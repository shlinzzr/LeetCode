// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    
    boolean[] seen;
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<String> cons = new ArrayList<>();
        seen = new boolean[words.length];
        dfs(words, cons, "");
        
        Set<Integer> res =new TreeSet<>();
        for(String con : cons){
            System.out.println(con);
            int idx = s.indexOf(con);
            if(idx>=0)
                res.add(idx);
        }
        
        return new ArrayList<>(res);
        
    }
    
    private void dfs(String[] words, List<String> cons, String curr){
        
        
        // if(curr.length()>0)
        //     cons.add(curr);
        
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