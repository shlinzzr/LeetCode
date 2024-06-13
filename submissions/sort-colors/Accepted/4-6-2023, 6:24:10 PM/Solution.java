// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        
        mergeSort(nums, 0, len-1);
    }
    
    private void mergeSort(int[] nums, int st, int ed){
        
        if(st>=ed)    return ;
        
        int mid = st+(ed-st)/2;
        
        mergeSort(nums, st, mid);
        mergeSort(nums, mid+1, ed);
        mergeHalves(nums, st, mid, mid+1, ed);
    }
    
    private void mergeHalves(int[] nums, int left, int leftEnd, int right, int rightEnd){
        
        int[] tmp = new int[rightEnd-left+1];
        int idx =0;
        
        int i = left;
        int j = right;
        
        while(i<=leftEnd && j<=rightEnd){
            
            if(nums[i]<=nums[j]){
                tmp[idx++] = nums[i++];
            }else{
                tmp[idx++] = nums[j++];
            }
        }
        
        while(i<=leftEnd){
            tmp[idx++] = nums[i++];
        }
        
        while(j<=rightEnd){
            tmp[idx++] = nums[j++];
        }
        
        idx=0;
        for(i=left; i<=rightEnd; i++){
            nums[i] = tmp[idx++];
        }
        // System.arraycopy(tmp, 0, nums, left, rightEnd-left+1);
        
    }
}


