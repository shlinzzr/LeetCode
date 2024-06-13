// https://leetcode.com/problems/to-lower-case

class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        
        
        for(char ch : s.toCharArray()){
            
            if(ch>='a' && ch<='z')
                sb.append(ch);
            
            if(ch>='A' && ch<='Z'){
                sb.append((char) (ch-'A'+'a'));
            }
        }
        
        return sb.toString();
        
    }
}