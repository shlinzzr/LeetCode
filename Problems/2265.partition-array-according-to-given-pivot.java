// https://leetcode.com/problems/partition-array-according-to-given-pivot

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int[] res = new int[nums.length]; 
        
        int pcnt =0;
        int cnt=0;
        for(int i=0; i<nums.length; i++){
            
            int n = nums[i];
            if(n<pivot){
                res[cnt++] = n;
            }else if(n==pivot)
                pcnt++;
            
        }
        
        for(int i=0; i<pcnt;i++){
            res[cnt++] = pivot;
        }
        
        for(int i=0; i<nums.length; i++){

            if(nums[i]>pivot){
                res[cnt++]=nums[i];
            }
            
        }
        
        return res;
            
        
    }
}