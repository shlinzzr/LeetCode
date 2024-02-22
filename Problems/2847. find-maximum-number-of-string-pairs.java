// https://leetcode.com/problems/find-maximum-number-of-string-pairs

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int len = words.length;
        
        int cnt = 0;
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                
                if(isRev(words[i], words[j]))
                    cnt++;
            }
        }
        
        return cnt;
    }
    
    private boolean isRev(String a, String b){
        
        if(a.length()!=b.length())
            return false;
        
        for(int i=0;i<a.length(); i++){
            
            if(a.charAt(i)!=b.charAt(b.length()-1-i))
                return false;
        }
        
        return true;
        
        
    }
}