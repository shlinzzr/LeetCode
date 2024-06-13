// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] F, int n) {
        int len = F.length;
        
        for(int i=0; i<len; i++){
            if(F[i]==1){
                i++;
            }else{
                n--;
                i++;
            }
        }
        
        return n==0;
    }
}