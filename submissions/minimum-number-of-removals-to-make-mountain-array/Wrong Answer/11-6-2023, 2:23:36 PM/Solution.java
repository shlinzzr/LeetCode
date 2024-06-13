// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;
        int st =0, ed=len-1;

        while(st<ed){
            int mid = st+(ed-st)/2;

            if(isValid(nums, mid)){
                ed = mid;
            }else{
                st = mid+1;
            }
        }

        return st;

    }

    private boolean isValid(int[] nums, int mid){

        List<Integer> list = new ArrayList<>();

        int len = nums.length;

        for(int i=1; i<len-1; i++){
            if(nums[i-1]<nums[i] && nums[i]>nums[i+1]){
                list.add(i);
            }
        }


        int cnt = 0;
        for(int peak : list){

            for(int i=1; i<len-1; i++){
                
                if(i<peak){
                    if(nums[i]<nums[i-1]){
                        cnt++;
                    }
                }else{
                    if(nums[i]<nums[i+1]){
                        cnt++;
                    }
                }

                if(cnt>mid)
                    continue;
            }

            if(cnt<=mid)
                return true;
        }

        return false;

    }


}