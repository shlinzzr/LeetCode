// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res  = new ArrayList<>();
        int len = words.length;
        
        
        for(int i=0; i<len ; i++){
            for(int j=i+1; j<len; j++){
                
                if(isPal(words[i]+words[j])){
                    res.add(Arrays.asList(i, j));
                }
                
                if(isPal(words[j]+words[i])){
                    res.add(Arrays.asList(j, i));
                }
                
                
            }
        }
        return res;
        
    }
    
    
    private boolean isPal(String s){
        
        for(int i=0; i<s.length()/2; i++){
            
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        
        return true;
                    
    }
}