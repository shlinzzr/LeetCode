// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        mergesort(nums, new int[len], 0, len-1);
    }
    
    private void mergesort(int[] nums, int[]temp, int st, int ed){
        
        if(st>=ed)
            return;
        
        int mid = st + (ed-st)/2;
        
        mergesort(nums, temp, 0, mid);
        mergesort(nums, temp, mid+1, ed);
        mergeHalves(nums, temp, st, ed);
        
    }
    
   private void mergeHalves(int[] nums, int[] temp, int leftStart, int rightEnd){
        
        int left = leftStart;
        int leftEnd = leftStart+(rightEnd-leftStart)/2;
        int rightStart = leftEnd +1;
        int right = rightStart;
        int curr=left;
        
        while(left<=leftEnd && right<=rightEnd){
            
            if(nums[left] <= nums[right]){
                temp[curr] = nums[left];
                left++;
            }else{
                temp[curr] = nums[right];
                right++;
            }
            curr++;
        }
        
        
        System.arraycopy(nums, left, temp, curr, leftEnd-left+1);
        System.arraycopy(nums, right, temp, curr, rightEnd-right+1);
        System.arraycopy(temp, leftStart, nums, leftStart, rightEnd-leftStart+1);
            
        
    }
    
}