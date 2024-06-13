// https://leetcode.com/problems/next-permutation

class Solution {
    
    //https://www.youtube.com/watch?v=IbcQOdtmvpA
    // 12 '4' 6 '5' 3 => 找到比4大又最接近4的數 1.交換 2.reverse後半段
    //.12 '5' 6 '4' 3 
    // 他媽的 這只能背了吧 幹
    
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;
        int i=len-2;
        
        //從右邊找到左邊 找到打破升序的數字
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        // i=2
        
        
        
        //從右邊開始找 找到比4大又最接近4的數: 5,   並交換 => 125643, 再做reverse: 125346#
        if(i>=0){
            int j=len-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            
            swap(nums, i, j);
        }
        
        reverse(nums, i+1, len-1);
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
        
    }
}