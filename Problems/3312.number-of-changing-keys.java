// https://leetcode.com/problems/number-of-changing-keys

class Solution {
    public int countKeyChanges(String s) {
        
        
        int cnt = 0;
        for(int i=0; i<s.length()-1; i++){
            
            char ch0 = s.charAt(i);
            char ch1 = s.charAt(i+1);
            
            int a = getIdx(ch0);
            int b = getIdx(ch1);
            
            if(a!=b) cnt++;
            
            
        }
        
        return cnt;
        
    }
    
    private int getIdx(char ch){
        if(ch>='a' && ch<='z')
            return ch-'a';
        else if(ch>='A' && ch<='Z')
            return ch-'A';
        
        return -1;
            
    }
}