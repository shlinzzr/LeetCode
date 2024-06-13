// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Set<List<Integer>> set = new HashSet<>();
        
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<len-3; i++){
            for(int j=i+1; j<len-2; j++){
                
                int k=j+1, l=len-1;
                
                while(k<l){
                    
                    int sum = nums[i]+nums[j] + nums[k] + nums[l];
                    if(sum==target){
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    }else if(sum>target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
                                
        return new ArrayList<>(set);
    }
}