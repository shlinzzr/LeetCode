// https://leetcode.com/problems/count-and-say

class Solution {
    
    // countAndSay(n) = countAndSay(n-1)
    
    public String countAndSay(int n) {
        
        String res ="";
        
        if(n==1)
            return "1";
        
       
        
        String str = countAndSay(n-1);
        
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
             int cnt = 0;
            
            cnt++;
            
            while(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
                cnt++;
                i=i+1;
            }
            
            res += cnt+""+ c;
        }
        // System.out.println(n + " " + res);
        return res;
        
        
    }
}