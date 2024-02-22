// https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring

class Solution {
    public int longestContinuousSubstring(String s) {

        
        int cnt = 0;
        int max = 1;
        for(int i=0; i<s.length(); i++){
            int j = Math.min(i+26, s.length());
            
            for(int k=i+1; k<=j; k++){
                 String sub = s.substring(i, k);
                // System.out.println(i + " " + k + " sub="+sub );
                
                if(isAlpha(sub)){
                    max= Math.max(max, sub.length());
                }
            }
            
           
            
            
        }
        
        return max;
    }
    
    
    private boolean isAlpha(String a){
        
        char ch = a.charAt(0);
        
        for(int i=0;i<a.length(); i++){
            
            if(ch!=a.charAt(i))
                return false;
            ch++;
        }
        
        return true;
        
        
    }
}