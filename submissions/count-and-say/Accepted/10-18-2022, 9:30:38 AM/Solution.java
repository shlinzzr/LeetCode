// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        
        if(n==1)
            return "1";
        
        String s = countAndSay(n-1);
        
        int cnt=1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                cnt++;
            }else{
                sb.append(String.valueOf(cnt) + s.charAt(i));
                cnt=1;
            }
        }
        
        return sb.toString();
        
    }
}