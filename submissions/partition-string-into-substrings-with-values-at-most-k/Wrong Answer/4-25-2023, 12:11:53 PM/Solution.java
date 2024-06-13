// https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k

class Solution {
    public int minimumPartition(String s, int k) {
        int len= s.length();
        int st =0;
        
        
        int cnt=1;
        int val =0;
        for(int ed=0; ed<len; ed++){
            
            val = val*10 + s.charAt(ed)-'0';
            
            if(val>k ){
                cnt++;
                val = s.charAt(ed)-'0';
                if(val>k)
                    return -1;
            }
        }
        
        return cnt;
    }
}