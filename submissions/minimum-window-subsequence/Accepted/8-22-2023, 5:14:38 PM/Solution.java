// https://leetcode.com/problems/minimum-window-subsequence

class Solution {
    public String minWindow(String s1, String s2) {
        
        
        // sliding window O(m*n)
        
        int len = s1.length();
        
        String[] dp = new String[len+1]; // 執行到第i個字符的 min subseq?
        
        if(s1.equals(s2))
            return s1;
        
        String res = s1+"#";
        
        
        for(int i1=0; i1<s1.length(); i1++){
        
            int i2 = 0;
            
            if(s1.charAt(i1)!=s2.charAt(i2)){
                continue;
            }
            
            int st=i1, ed=i1;
            while(ed<s1.length() && i2<s2.length()){
                
                if(s1.charAt(ed)==s2.charAt(i2)){
                    i2++;
                    ed++;
                }else{
                    ed++;
                }
            }
            
            String sub = s1.substring(st, ed);
            
            if(i2==s2.length() && sub.length()<res.length()){
                res = sub;
            }
            
        }
        
        return res.length()==len+1 ? "" : res;
        
    }
}