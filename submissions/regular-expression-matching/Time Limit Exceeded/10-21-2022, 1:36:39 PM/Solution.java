// https://leetcode.com/problems/regular-expression-matching

class Solution {
    
    int len_s;
    int len_p;
    String s;
    String p;
    HashMap<int[], Boolean> map;
    public boolean isMatch(String s, String p) {
        
        
        
        this.s=s;
        this.p=p;
        len_s = s.length();
        len_p = p.length();
        map = new HashMap<>();
        
        return dfs(0,0);
        
        
    }
    
    
    private boolean dfs(int i, int j){

        int[] key = new int[]{i,j};
        if(map.containsKey(key))
            return map.get(key);
        
        if(i>=len_s && j>=len_p)
            return true;
        
        if(j>=len_p)
            return false;
        
        boolean match = i<len_s && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<len_p && p.charAt(j+1)=='*'){
            boolean res = (match && dfs(i+1, j)) || dfs(i, j+2);
            map.put(key, res);
            return res;
        }
        
        if( match ){
            boolean res = dfs(i+1, j+1);
            map.put(key, res);
            return res;
        }
        
        map.put(key, false);
        return false;
    }
}