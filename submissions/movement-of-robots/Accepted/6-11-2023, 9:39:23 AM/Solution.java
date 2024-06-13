// https://leetcode.com/problems/movement-of-robots

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        long ans=0, pre=0, n=s.length(),mod=(long)1e9+7;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='R')nums[i]+=d;
            else nums[i]-=d;
        } Arrays.sort(nums);
        for(int i=0;i<n;i++){
            ans=(ans+ i*(long)nums[i]- pre)%mod;
            pre+=nums[i];
        }return (int)ans;
    }
}