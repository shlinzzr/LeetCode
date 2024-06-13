// https://leetcode.com/problems/find-greatest-common-divisor-of-array

class Solution {
    public int findGCD(int[] nums) {
        int len = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n : nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        return gcd(max, min);

        // int res = Integer.MAX_VALUE;
        // for(int i=0; i<len; i++){
        //     for(int j=i+1; j<len; j++){
        //         res = Math.min(res , gcd(nums[i], nums[j]));
        //     }
        // }

        // return res;
    }

    private int gcd(int a, int b){
        if(b==0) return a;
        int rt =  gcd(b, a%b);

        // System.out.println(a+" "+b + "="+rt);
        return rt;
    }
}