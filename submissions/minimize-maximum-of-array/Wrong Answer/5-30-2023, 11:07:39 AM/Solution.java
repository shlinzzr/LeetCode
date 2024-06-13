// https://leetcode.com/problems/minimize-maximum-of-array

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int len = nums.length;
        
        int std = nums[0];
        
        int slot = 0;
        
        for(int i=1; i<len; i++){
            
            if(nums[i]>std){
                
                int ele = nums[i]-std;//4
                
                if(ele<slot){
                    slot-=ele;
                }else{
                    ele-=slot;  //4
                    std+=ele/(i+1);
                    
                    if(ele%(i+1)>0)
                        std+=1;
                    
                    slot=(i+1) - (ele%(i+1));
                }
                
            }else{
                slot += nums[i]-std;
            }
            
            System.out.println("i="+i + " slot="+slot + " std="+std);
        }
        
        return std;
    }
}