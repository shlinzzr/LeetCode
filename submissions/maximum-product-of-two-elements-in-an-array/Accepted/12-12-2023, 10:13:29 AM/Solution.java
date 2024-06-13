// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array

class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2=0;

        for(int n: nums){
            if(n>max1){
                max2=max1;
                max1=n;
            }else if(n>max2){
                max2=n;
            }
        }

        return (max1-1) * (max2-1);
    }
}