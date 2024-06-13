// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        int st=Integer.MIN_VALUE/2, ed= Integer.MAX_VALUE/2;

        while(st<ed){ //0 , 1
            int mid = ed-(ed-st)/2; // 0

            int ge = greaterEqual(nums, mid);

            if(ge>=k){
                st = mid;
            }else{
                ed = mid-1;
            }
        }

       return st;

        
    }

    private int greaterEqual(int[] nums, int mid){

        int cnt = 0;
        for(int n : nums){
            if(n>=mid) cnt++;
        }

        return cnt;


    }

        


}