// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        
        int len = nums.length;
        
        Arrays.sort(nums);
        
        
        for(int i=0; i<len-2; i++){
            
            int j = i+1;
            int k = len-1;
            while(j<k){
                
                
                if(nums[i] + nums[j]+ nums[k]==0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(nums[i] + nums[j]+ nums[k]>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}