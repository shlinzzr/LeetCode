// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        
        int len = nums.length;
        
        for(int i=0; i<len-2; i++){
            
            int val = nums[i];
            
            int st = i+1, ed = len-1;
            
            while(st<ed){
                
                if(nums[st]+nums[ed]+ nums[i] ==0){
                    
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[st]);
                    list.add(nums[ed]);
                    
                    set.add(list);
                    break;
                    
                }else if(nums[st] + nums[ed] + nums[i]>0){
                    ed--;
                }else 
                    st++;
            }
        }
        
        return new ArrayList<>(set);
        
    }
}