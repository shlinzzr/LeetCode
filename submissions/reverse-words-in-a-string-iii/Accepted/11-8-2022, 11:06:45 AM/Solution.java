// https://leetcode.com/problems/reverse-words-in-a-string-iii

class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(String a:arr){
            if(sb.length()!=0)
                sb.append(" ");
            sb.append(new StringBuilder(a).reverse());
            
        }
        
        return sb.toString();
        
    }
}