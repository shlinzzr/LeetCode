// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        int st = 0, ed = len-1;

        while(st<ed){ //0 , 1
            int mid = st+(ed-st)/2; // 0

            int ge = greaterEqual(nums, mid);

            if(ge==k){
                return mid;
            }else if(ge>k){
                st = mid+1;
            }else{
                ed = mid;
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