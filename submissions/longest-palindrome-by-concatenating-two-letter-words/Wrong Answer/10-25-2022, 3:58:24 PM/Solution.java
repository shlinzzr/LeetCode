// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words

class Solution {
    public int longestPalindrome(String[] words) {
        
        HashSet<String> set = new HashSet<>();
        int cnt=0;
        boolean hasDD = false;
        
        for(String w : words){
            boolean dd = w.charAt(0)==w.charAt(1);
            
            StringBuilder sb = new StringBuilder(w);
            if(set.contains(sb.toString())){
                
                if(dd && hasDD==true){
                    hasDD=false;
                    cnt+=2;
                }else
                    cnt+=4;
            }
            
            if(dd && hasDD==false){
                cnt+=2;
                hasDD=true;
            }
            
            set.add(sb.reverse().toString());
        }
        
        return cnt;
        
        
        
    }
}