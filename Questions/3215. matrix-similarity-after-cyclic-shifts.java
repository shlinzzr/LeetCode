// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        
        // k =4
        // r : 2
        // 1 2 3 4 5 6 
        // 4 3 2 1 6 5
        // 5 6 1 2 3 4
        
        int h= mat.length;
        int w = mat[0].length;
        
        k= k%w;
        
        
        for(int i=0 ;i<h; i++){
            int[] nums = mat[i];
            
            int [] tmp = new int[w];
            System.arraycopy(nums, 0, tmp, 0,w);
            
            if(i%2==0){
                reverse(nums, 0,w-k-1);
                reverse(nums,w-k, w-1);
                reverse(nums, 0, w-1);
                
                if(check(nums, tmp)==false)
                    return false;
                
            }else{
                reverse(nums, 0, k-1);
                reverse(nums, k, w-1);
                reverse(nums, 0, w-1);
                 
                if(check(nums, tmp)==false)
                    return false;
            }
            
        }
        return true;
        
        
        
        
        
    }
    
    private boolean check(int[] nums, int[] tmp){
        for(int i=0; i<tmp.length; i++){
            if(nums[i]!=tmp[i])
                return false;
        }
        return true;
    }
    
    private void reverse(int[] nums, int st, int ed){
        int w = nums.length;
        
        while(st<ed){
            
            int t  = nums[st];
            nums[st]=nums[ed];
            nums[ed] = t;
            st++;
            ed--;
        }
        
        
        
        
    }
}