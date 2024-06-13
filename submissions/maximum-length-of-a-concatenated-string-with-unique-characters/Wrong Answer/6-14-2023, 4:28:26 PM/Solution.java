// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

class Solution {
    
    int max = 0;
    
    public int maxLength(List<String> arr) {
        
        helper(arr, 0, new int[26]);
        return max;
    }
    
    private void helper(List<String> arr, int st, int[]curr){
        
        int val = 0;
        for(int c : curr){
            if(c==1)
                val++;
        }
        max = Math.max(max, val);
        
        for(int i=st; i<arr.size(); i++){
            String s = arr.get(i);
            
            boolean valid = true;
            for(char ch : s.toCharArray()){
                curr[ch-'a']++;
                
                if(curr[ch-'a']>1){
                    valid=false;
                }
            }
            
            if(valid)
                helper(arr, i+1, curr);
            
            helper(arr, i+1, curr);
            for(char ch : s.toCharArray()){
                curr[ch-'a']--;
            }
            
        }
        
        
    }
}