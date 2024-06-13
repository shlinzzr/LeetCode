// https://leetcode.com/problems/increasing-decreasing-string

class Solution {
    public String sortString(String s) {
        String res = "";
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[c-'a']++;            
        }
        
        
        while(res.length()<s.length()){
            
            for(int i=0; i<26; i++){
                if(arr[i]>0){
                    res += (char)(i+'a');
                    arr[i]--;
                }
            }
            
            for(int i=25; i>=0; i--){
                if(arr[i]>0){
                    res += (char)(i+'a');
                    arr[i]--;
                }
            }
        }
        
        
        return res;
        
        
        
        
        
        
        
    }
}