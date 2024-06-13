// https://leetcode.com/problems/first-missing-positive

class Solution {
    
    // https://www.youtube.com/watch?v=SRsT9iHb4OE
    // idx sorting
    
    
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            /*
            //停止條件：  1. 換到想要得的idx的時候 nums[i]==i+1 
                        2. 超出idx 範圍的時候 nums[i]<=0 || nums[i]>len
                        3. 交換的數字跟目前數字一樣的時候 nums[i]==nums[nums[i]-1]     
                       ex:  [2,2,1], i=0;
                            nums[0]= nums[2-1]=nums[1];
                            
            boolean stop = nums[i]==i+1 || (nums[i]<=0 || nums[i]>len) ||  nums[i]==nums[nums[i]-1] ;  
            boolean keep = ~stop
            boolean keep = nums[i]!=i+1 && (nums[i]>0 && nums[i]<=len) &&  nums[i]!=nums[nums[i]-1] ;
            
*/          
            // 關鍵在於＝>  idx = nums[i]-1;
            
            // solution 1
            while(    nums[i]-1!=i  // 第0個不是1 的時候繼續做
                   && nums[i]-1 >= 0   //  在idx範圍內的時候繼續做
                   && nums[i]-1 < nums.length  // 在idx範圍內的時候繼續做
                   && nums[nums[i]-1] != nums[i] ){ // 交換的數字不相同的時候繼續做
            
                
                swap(nums, i, nums[i]-1);
                
            }
            
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)    
                return i+1;
        }
        
        return nums.length+1;
        
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;    
    }
    
    
    
}