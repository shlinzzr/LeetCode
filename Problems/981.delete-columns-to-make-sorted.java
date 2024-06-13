// https://leetcode.com/problems/delete-columns-to-make-sorted

class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs.length;
        int wordLen = strs[0].length();
        
        
        int cnt = 0;
        for(int i=0; i<wordLen; i++){
            for(int j=1; j<len; j++){
                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    cnt+=1;
                    break;
                }
            }
        }
        
        return cnt;
            
            
        
    }
}