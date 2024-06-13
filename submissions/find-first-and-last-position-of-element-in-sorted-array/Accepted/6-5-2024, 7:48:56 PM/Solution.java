// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int [] searchRange(int[] nums, int target) {



        int[] res = new int[]{-1, -1};

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        if(!set.contains(target)) return res;
        
        int len = nums.length;

        int st=0, ed=len-1;

        while(st<ed){ //0 1
            int mid = st+(ed-st)/2; //0
            if(nums[mid]<target){
                st = mid+1; //1
            }else{
                ed = mid; 
            }
        }

        res[0] = st;

        st=0; ed=len-1;
        while(st<ed){
            int mid = ed-(ed-st)/2;

            if(nums[mid]>target){
                ed = mid-1;
            }else{
                st = mid;
            }
        }

        res[1] =st;
        return res;
    }
}