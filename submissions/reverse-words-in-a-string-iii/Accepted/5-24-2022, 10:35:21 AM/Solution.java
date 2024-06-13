// https://leetcode.com/problems/reverse-words-in-a-string-iii

class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : strArr){
            
            if(sb.length()!=0)
                sb.append(" ");
            
            char [] charArr = str.toCharArray();
            reverse(charArr);
            sb.append( String.valueOf( charArr ));
            
            
        }
        
        return sb.toString();
        
        
        
    }
    
    
    private void reverse(char[] charArr){
        
        int st =0, ed = charArr.length-1;
        while(st<ed){
            
            char c = charArr[st];
            charArr[st++] = charArr[ed];
            charArr[ed--] = c;
            
            
        }
        
    }
    
}