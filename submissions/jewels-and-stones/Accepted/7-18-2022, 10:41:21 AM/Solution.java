// https://leetcode.com/problems/jewels-and-stones

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int res = 0;
        
        for(char st : stones.toCharArray()){
            if(jewels.indexOf(st)>=0)
                res++;
        }
        
        return res;
    }
    
}