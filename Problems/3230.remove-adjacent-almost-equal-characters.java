// https://leetcode.com/problems/remove-adjacent-almost-equal-characters

class Solution {
    public int removeAlmostEqualCharacters(String word) {
        
        int res= 0 ;
        int len = word.length();
        boolean[] chg = new boolean[len];
        for(int i=1; i<len; i++){
            if(Math.abs(word.charAt(i)-word.charAt(i-1))<=1){
               if(chg[i-1]) continue;
               chg[i] = true;
                res++;
                
            }
        }
        
        return res;
        
    }
}