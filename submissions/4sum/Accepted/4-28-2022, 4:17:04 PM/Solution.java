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
                    
                     // System.out.println(i+", "+ j +", "+ k +", "+L);
                    int sum = nums[i] + nums[j] + nums[k] + nums[L] - target;
                    if(sum==0){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[L--]));
      
                    }else if(sum<0){
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