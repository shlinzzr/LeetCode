// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        
        int len = words.length;
        int cnt=  0;
        
        for(int i=0; i<len ; i++){
            for(int j=i+1; j<len; j++){
                
                String a = words[i];
                String b = words[j];
                
                if(isps(a,b)){
                    cnt++;
                }
                
            }
        }
        
        return cnt;
        
    }
    
    private boolean isps(String a, String b ){
        
        if(b.length()<a.length()) return  false;
        
        String p = b.substring(0, a.length());
        String s = b.substring(b.length()-a.length(), b.length());
        
        return a.equals(p) && a.equals(s);
        
    }
}