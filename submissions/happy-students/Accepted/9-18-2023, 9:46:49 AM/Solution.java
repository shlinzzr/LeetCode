// https://leetcode.com/problems/happy-students

class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        
        int res = 0;
        
        if(nums.get(0)>0)
            res++;
        
        
        for(int i=0; i<nums.size(); i++){
            if(i==nums.size()-1){
                
                if(i+1>nums.get(i))
                    res++;
            }else{
                
                if(i+1>nums.get(i) && i+1<nums.get(i+1)){
                    res++;
                }
                
                
            }
            
        }
        
        return res;
        
        
    }
}