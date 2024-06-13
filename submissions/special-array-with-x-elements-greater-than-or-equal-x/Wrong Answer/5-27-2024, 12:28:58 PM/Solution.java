// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x

class Solution {
    public int specialArray(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;

        int st=0, ed=nums[len-1];

        while(st<ed){
            int x = st+(ed-st)/2;

            int cnt = getCnt(nums, x);
            if(cnt==x) return x;
            else if(cnt<x){
                ed = x-1;
            }else{
                st = x+1;
            }
        }

        return -1;
    }

    private int getCnt(int[] nums, int x){
        int cnt= 0 ;
        for(int n: nums){
            if(n>=x){
                cnt++;
            }
        }

        return cnt;
    }
}