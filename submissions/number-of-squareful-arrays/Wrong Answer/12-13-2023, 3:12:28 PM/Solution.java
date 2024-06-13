// https://leetcode.com/problems/number-of-squareful-arrays

class Solution {
    public int numSquarefulPerms(int[] nums) {

        HashSet<String> set = new HashSet<>();
        int len = nums.length;
        int cnt=0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                long t = nums[i]+nums[j];
                if(Math.sqrt(t)*Math.sqrt(t)==t && set.add(nums[i]+"_"+nums[j])){
                    cnt++;
                    System.out.println(nums[i]+ " " + nums[j] + " t=" + t);
                }
                    
            }
        }

        return cnt;

    }
}