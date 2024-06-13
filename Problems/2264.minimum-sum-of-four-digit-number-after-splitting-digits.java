// https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits

class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        
        
        int carry=1000;
        for(int i=0; i<4; i++){
            arr[i] = num/carry;
            num = num-carry*arr[i];
            carry = carry/10;
        }
               
        Arrays.sort(arr);
        return arr[0]*10 + arr[1]*10+arr[2]  + arr[3];
        
        
        
    }
}