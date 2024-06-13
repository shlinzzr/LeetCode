// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        
        Arrays.sort(nums);
        
         Set<List<Integer>> set = new HashSet<>();
        
        
        for(int i=0; i<len-2; i++){
            
            int j=i+1, k=len-1;
            while(j<k){
                
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                     while (j < k && nums[j] == nums[j+1]) j++;
                    while (j < k && nums[j] == nums[k-1]) k--;
                    j++;
                    k--;
                }else if (sum<0)
                    j++;
                else
                    k--;
                    
                
                
            }
        }
        
        return new ArrayList<>(set);
    }
}