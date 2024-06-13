// https://leetcode.com/problems/reverse-words-in-a-string-iii

class Solution {
    public String reverseWords(String s) {
        String [] arr = s.split(" ");
          String [] ans = new String[arr.length];
        
        
        
        int i=0;
        for(String str : s.split(" ")){
            StringBuilder sb =new StringBuilder(str);
            
            ans[i] = sb.reverse().toString();
            i++;
        }
        
        
        
        return String.join(" ", ans);
       
    }
}