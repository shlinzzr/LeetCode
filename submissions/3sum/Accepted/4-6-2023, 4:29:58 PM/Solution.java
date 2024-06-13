// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int len = nums.length;
        
        Arrays.sort(nums);
        
        
        for(int i=0; i<len-2; i++){
            
            int j=i+1, k=len-1;
            
            while(j<k){
                
                int curr = nums[i]+nums[j]+nums[k];
                
                if(curr==0){
                    
                      /* improvement */
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    
                    j++;
                    k--;
                }else{
                    
                    if(curr<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}