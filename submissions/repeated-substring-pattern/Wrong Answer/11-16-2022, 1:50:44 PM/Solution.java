// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        if(s.length()==1)
            return false;
        
        
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            
            arr[c-'a']++;
        }
        
        int cnt =0;
        for(int a: arr){
            
            if(a==0)
                continue;
            
            if(cnt==0 && a!=0){
                cnt=a;
            }
            
            if(cnt!=0 && a!=cnt)
                return false;
        }
        
        return true;
        
    }
}