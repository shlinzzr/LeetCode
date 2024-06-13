// https://leetcode.com/problems/minimum-window-subsequence

class Solution {
    public String minWindow(String s1, String s2) {
        
        int len = s1.length();
        
        
        String[] dp = new String[len+1]; // 執行到第i個字符的 min subseq
        
        
        if(s1.equals(s2))
            return s1;
        
        int min = Integer.MAX_VALUE;
        String str = s1;
        
        
        
        
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
            
            if(idx==s2.length() && sub.length()<min){
                min = sub.length();
                str = sub;
            }
            
            
            
        }
        
        return min==Integer.MAX_VALUE ? "" : str;
        
    }
}