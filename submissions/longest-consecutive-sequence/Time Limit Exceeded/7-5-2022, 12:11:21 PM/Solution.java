// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length<2)
            return nums.length;
        
        // merge sort
        mergesort(nums);
        
        for(int n : nums){
            System.out.println(n);
        }
        
        
        int max = 0;
        int curr = 1;
        for(int n=1; n<nums.length; n++){
            
            if(nums[n]==nums[n-1])
                continue;
            
            if(nums[n]==nums[n-1] +1){
                curr++;
            }else{
                if(curr>max){
                    max = curr;
                    
                }
                
                curr=1;
            }
            
            System.out.println(nums[n] + ", max="+max + " curr"+ curr);
            

        }
         if(curr>max){
                    max = curr;
                    
                }
        
        
        return max;
        
    }
    
    
    private void mergesort(int[] nums){
        
        mergesort(nums, new int[nums.length], 0, nums.length-1);
        
        
    }
    
    private void mergesort(int[] nums, int[] temp, int leftStart, int rightEnd){
        
        if(leftStart >= rightEnd)
            return;
        
        // System.out.println("mergesort(" + leftStart + ", " + rightEnd + ")");
        
        int mid = (leftStart + rightEnd) /2;
        mergesort(nums, temp, 0, mid);
        mergesort(nums, temp, mid+1, rightEnd);
        mergeHalves(nums, temp, leftStart, rightEnd);
        
    }
    
    private void mergeHalves(int[] nums, int[] temp, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd+1;
        
        int left = leftStart;
        int right = rightStart;
        int idx = leftStart;
        
        while(left<=leftEnd && right<=rightEnd){
            if(nums[left] <= nums[right]){
                temp[idx] = nums[left];
                left++;
            }else{
                temp[idx] = nums[right];
                right++;
            }
            idx++;
        }
        
        
        // System.out.println("print temp:");
        // for(int t : temp){
        //     System.out.println(t);
        // }
        
        int size = rightEnd-leftStart +1;
        
        // System.arraycopy(nums, left, temp,idx, leftEnd-left+1);
        // System.arraycopy(nums, right, temp,idx, rightEnd-right+1);
        // System.arraycopy(temp, leftStart, nums, leftStart, size);
        
        
        
        
        for(int i=left; i<=leftEnd; i++){
            temp[idx] = nums[i];
            idx++;
        }
        for(int i=right; i<=rightEnd; i++){
            temp[idx] = nums[i];
            idx++;
        }
        
        
        
        for(int i=leftStart; i<=rightEnd; i++){
            nums[i] = temp[i];
        }
        
        
        
    }
    
}
