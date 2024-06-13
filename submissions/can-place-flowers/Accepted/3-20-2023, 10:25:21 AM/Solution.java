// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] F, int n) {
        int count = 0;
        for(int i = 0; i < F.length && count < n; i++) {
            if(F[i] == 0) {
	     //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0. 
               int next = (i == F.length - 1) ? 0 : F[i + 1]; 
               int prev = (i == 0) ? 0 : F[i - 1];
               if(next == 0 && prev == 0) {
                   F[i] = 1;
                   count++;
               }
            }
        }
        
        return count == n;
    }
}