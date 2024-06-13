// https://leetcode.com/problems/reverse-words-in-a-string-iii

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] arr = s.split(" ");
        for(String a : arr){
            
            for(int i=0; i<a.length(); i++){
                sb.append(a.charAt(a.length()-i-1));
            }
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        
        
        return sb.toString();
    }
}