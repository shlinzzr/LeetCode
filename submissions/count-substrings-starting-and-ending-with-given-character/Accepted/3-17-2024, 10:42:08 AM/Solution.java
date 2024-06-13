// https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character

class Solution {
    public long countSubstrings(String s, char c) {
        
        int len = s.length();
        
        long res = 0;
        
        
        int cnt= 0 ;
        for(int i=0; i<len ; i++){
            if(s.charAt(i)==c)
                cnt++;
        }
        // System.out.println(cnt);
        
        for(int i=cnt; i>0; i--){
            res+=i;
        }
        
        return res;
        
    }
}