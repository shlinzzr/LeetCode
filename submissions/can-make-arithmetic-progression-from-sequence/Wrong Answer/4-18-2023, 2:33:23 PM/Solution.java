// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int len = arr.length;
        
        Arrays.sort(arr);
        
        for(int i=2; i<len; i++){
            if(arr[i]-arr[i-1] == arr[i-1]-arr[i-2])
                return true;
        }
        
        return false;
        
    }
}