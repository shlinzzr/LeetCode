// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4)
            return new ArrayList<>();

        Set<List<Integer>> res = new HashSet<>();
        
        
        Arrays.sort(nums);
        
    
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
           
                int k = j+1;
                int L = nums.length-1;
                
                while(k<L){
                    
                    int sum = nums[i] + nums[j] + nums[k] + nums[L];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[L--]));
      
                    }else if(sum<target){
                        k++;
                    }else{
                        L--;
                    }
                }
            
            }
        }
        return new ArrayList<>(res);
        
    }
}