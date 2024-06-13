// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
       
        if(s.length()==1)
            return 1;
        
        int max =0;
        for(int i=0, j=i+1 ; i<s.length(); i++){
            while(j<s.length() && (s.charAt(i)==s.charAt(j) || k>0)){
              
                if(s.charAt(i)!=s.charAt(j)){
                    k--;    
                }
                
                j++;
                // System.out.println(i + " " + j);
            }
                
            int len = j==s.length()-1? j-i+1: j-i;
            max = Math.max(max, len);
            
            j=i+1;
            
        }
        
        
        
        return max;
        
    }
}