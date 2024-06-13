// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        
        int len = words.length;
        
        for(int i=0; i<len; i++){
            
            for(int j=0; j<len; j++){
                
                if(i==j)
                    continue;
                
                if(isPal(words[i]+words[j])){
                    res.add(Arrays.asList(i,j));
                }
                
            }
        }        
        
        return res;
    }
    
    
    private boolean isPal(String s){
        
        int len = s.length();
        for(int i=0; i<len/2; i++){
            
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}