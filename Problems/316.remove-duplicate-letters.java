// https://leetcode.com/problems/remove-duplicate-letters

class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if(len==0) return s;
        
        int[] lastOccur = new int[26];
        for(int i=0; i<len; i++){
            lastOccur[s.charAt(i)-'a'] = i;
        }
        
        boolean[] seen = new boolean[26];
        
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0; i<len ;i++){
            char ch = s.charAt(i);
            
            if(seen[ch-'a']) continue;
            
            while(sb.length()>0 //sb不為空
              && sb.charAt(sb.length()-1) > ch // sb最後一個字 > ch
              && lastOccur[sb.charAt(sb.length()-1)-'a'] > i){ //  sb最後一個字之後還會出現 
                seen[sb.charAt(sb.length()-1)-'a']=false;  // ==>前面的可以砍 移到後面再出現
                sb.deleteCharAt(sb.length()-1);
                
            }
            sb.append(ch);
            seen[ch-'a']=true;
            
        }
        
       
        return sb.toString();
    }
}