// https://leetcode.com/problems/next-permutation

class Solution {
    
    //https://www.youtube.com/watch?v=IbcQOdtmvpA
    // ex : 1 2 4 6 5 3 
    
    /*why point 1 ?
    consider  9 8 7 6 5 3 , i 就會一直往左跑 最後把整個987653 reverse
    只要保持 nums[i]>nums[i+1], 就能保證nums[i:k]都是當下max
    */
    
    // 1 2 '4' 6 5 3   => 1.從右邊開始找  找到打破nums[i]>nums[i+1]的數字 : '4'
    // 1 2 '4' 6 '5' 3 => 2.從右邊開始找 找到比4大又最接近4的數  
    // 1 2 '5' 6 '4' 3 => 3.交換
    // 1 2 '5' 3 '4' 6 => 4.reverse後半段
    // 他媽的 這只能背了吧 幹
    
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;
        
        // => 1.從右邊開始找  找到打破nums[i]>nums[i+1]的數字 : '4'
        int i=len-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        // 2.從右邊開始找 找到比4大又最接近4的數  
        if(i>=0){
            int j=len-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            
            swap(nums, i, j); //3.交換
        }
        
        reverse(nums, i+1, len-1); //4.reverse後半段
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