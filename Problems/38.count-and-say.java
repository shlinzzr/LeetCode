// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String str = countAndSay(n-1);
        
        StringBuilder sb = new StringBuilder();
        int ed=0;
        for(int st=0; st<str.length(); st++){
            char ch = str.charAt(st);
            
            while(ed<str.length() && str.charAt(ed)==ch){
                ed++;
            }
            
            int cnt = ed-st;
            int num = ch-'0';
            sb.append(cnt).append(num);
            
            st = ed-1;
        }
        
        return sb.toString();
            
            
    }
}