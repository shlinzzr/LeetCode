// https://leetcode.com/problems/minimum-window-subsequence

class Solution {
    public String minWindow(String s1, String s2) {
        
        int len = s1.length();
        
        String[] dp = new String[len+1]; // 執行到第i個字符的 min subseq
        
        
        String min = s1;
        
        
        
        for(int i=0; i<s1.length(); i++){
        
            int idx = 0;
            
            if(s1.charAt(i)!=s2.charAt(idx)){
                continue;
            }
            
            int st=i, ed=i;
            while(ed<s1.length() && idx<s2.length()){
                
                if(s1.charAt(ed)==s2.charAt(idx)){
                    idx++;
                    ed++;
                }else{
                    ed++;
                }
            }
            
            String sub = s1.substring(st, ed);
            // System.out.println(sub);
            
            if(sub.length()<min.length()){
                min = sub;
            }
            
            
            
        }
        
        return min;
        
    }
}