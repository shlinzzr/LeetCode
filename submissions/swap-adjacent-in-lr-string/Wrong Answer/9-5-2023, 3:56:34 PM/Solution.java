// https://leetcode.com/problems/swap-adjacent-in-lr-string

class Solution {
    public boolean canTransform(String start, String end) {
        
        int len = start.length();
        if(start.length()!=end.length())
            return false;
        
        return helper(start, end);
        
    }
    
    private boolean helper(String s, String target){
        
        int len = s.length();
        
        for(int i=0; i<len-1; i++){
            
            char ch0 = s.charAt(i);
            char ch1 = s.charAt(i+1);
            
            char ta0 = target.charAt(i);
            char ta1 = target.charAt(i+1);
            
            
            if(ch0==ta0 && ch1==ta1)
                continue;
            
            if(ch0=='R' && ch1=='X' && ta0=='X' && ta1=='R'){
                char[] arr = s.toCharArray();
                arr[i]='X';
                arr[i+1]='R';
                s = new String(arr);
                i++;
            }else if(ch0=='X' && ch1=='L' && ta0=='L' && ta1=='X'){
                char[] arr = s.toCharArray();
                arr[i]='L';
                arr[i+1]='X';
                s = new String(arr);
            }else if(ch0==ta0)
                continue;
            else
                return false;
            
            // System.out.println(i + " " + s);
        }
        
        if(s.charAt(s.length()-1)!=target.charAt(target.length()-1))
            return false;
        
        
        return true;
        
        
    }
}