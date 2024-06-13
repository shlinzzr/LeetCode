// https://leetcode.com/problems/sum-of-distances

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer,long[]> map=new HashMap<>();
        long res[]=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            long curr[]=map.getOrDefault(nums[i],new long[]{0,0});
            if(curr[1]>0){
                res[i]+=(long)(curr[1]*i)-curr[0];
            }
            curr[0]+=i;
            curr[1]+=1;
            map.put(nums[i],curr);
        }
        map=new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            long curr[]=map.getOrDefault(nums[i],new long[]{0,0});
            if(curr[1]>0){
                res[i]+=(long)Math.abs((curr[1]*i)-curr[0]);
            }
            curr[0]+=i;
            curr[1]+=1;
            map.put(nums[i],curr);
        }
        return res;  
    }
}
