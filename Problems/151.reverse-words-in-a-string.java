// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            
            if(arr[i].isEmpty())
                continue;
            
            sb.append(arr[i] + " ");
            
        }
        
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
        
    }
}