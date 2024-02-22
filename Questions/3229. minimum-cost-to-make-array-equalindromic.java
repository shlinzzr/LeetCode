// https://leetcode.com/problems/minimum-cost-to-make-array-equalindromic

class Solution {
    public long minimumCost(int[] nums) {

        Arrays.sort(nums);

        int len = nums.length;

        int mid = nums[len/2];

        int p1 = nextPal(mid);
        int p2 = prevPal(mid);

        long sum1 = getSum(nums, p1);
        long sum2 = getSum(nums, p2);
        return Math.min(sum1, sum2);
    }

    private long getSum(int[] nums, int p){
        long res = 0;
        for(int i=0; i<nums.length; i++){
            res+= Math.abs(nums[i]-p);
        }

        return res;
    }


    private int nextPal(int n){
        while(!isPal(n)){
            n++;
        }
        return n;
    }

    private int prevPal(int n){
        while(!isPal(n)){
            n--;
        }
        return n;
    }

    private boolean isPal(int n){
        int tmp = n;
        int rev = 0;
        while(tmp>0){
            rev = rev*10 + tmp%10;
            tmp/=10;
        }

        return rev==n;
    }
        
}