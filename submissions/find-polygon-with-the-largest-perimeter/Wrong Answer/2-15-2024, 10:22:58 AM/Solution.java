// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter

class Solution {
    public long largestPerimeter(int[] nums) {
        int len = nums.length;
        if(len<=2) return -1;

        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<len; i++){
            sum+=nums[i];
        }

        int last = len-1;

        if(nums[last]<sum-nums[last]) return sum;
        
        while(last>0 && nums[last]>=sum-nums[last]){

            // System.out.println(sum + " " + last);
            sum-=nums[last];
            last--;

            if(nums[last]<sum-nums[last]) return sum;
        }

        //[1,12,1,2,5,50,3]
        // 1 1 2 3 5 12 50
        return -1;
    }
}