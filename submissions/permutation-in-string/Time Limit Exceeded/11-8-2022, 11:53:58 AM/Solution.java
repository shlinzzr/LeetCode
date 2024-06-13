// https://leetcode.com/problems/permutation-in-string

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Set<String> set = getperm(s1);
        for(String s : set){
            if(s2.contains(s))
                return true;
        }
        
        return false;
        
    }
    
    
    private Set<String> getperm(String s1){
        
        Set<String> set = new HashSet<>();
        boolean[] bool = new boolean[s1.length()];
        
        helper(s1, "", set, bool);
        return set;
        
    }
    
    private void helper(String s1, String curr, Set<String> set, boolean[] bool){
        
        if(curr.length()==s1.length()){
            set.add(curr);
            return;
        }
        
        
        for(int i=0; i<s1.length(); i++){
            
            if(bool[i]==false){
                bool[i]=true;
                helper(s1, curr+s1.charAt(i), set, bool);
                bool[i]=false;
            }
        }
    }
}