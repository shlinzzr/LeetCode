// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        while(true){
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            
            System.out.println(tortoise + "," + hare);
            
            if(tortoise==hare)
                break;
            
            
        }
        
        
        return hare;
        
        
    }
}