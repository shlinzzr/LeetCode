// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int len = arr.length;
        
        if(len==2)
            return true;
        
        Arrays.sort(arr);
        
        for(int n : arr){
            System.out.print( n + ", ");
        }
        
        int diff = arr[1] - arr[0];
        
        for(int i=1; i<len; i++){
            if(arr[i]-arr[i-1] !=diff)
                return false;
        }
        
        return true;
        
    }
}