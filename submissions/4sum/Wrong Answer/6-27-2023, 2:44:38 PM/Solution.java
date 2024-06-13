// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Set<List<Integer>> set = new HashSet<>();
        
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<len-3; i++){
            for(int j=i+1; j<len-2; j++){
                
                if(nums[i]==nums[j])
                    continue;
                
                int k=j+1, l=len-1;
                while(k<l){
                
                    long curr = (long)nums[i]+(long)nums[j] + (long)nums[k] + (long)nums[l];
                    if(curr==target){
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[j] == nums[k-1]) k--;
                        
                        k++;
                        l--;
                    
                    
                    
//                     if(curr==target){
//                         List<Integer> list = new ArrayList<>();
//                         list.add(nums[i]);
//                         list.add(nums[j]);
//                         list.add(nums[k]);
//                         list.add(nums[l]);
//                         set.add(list);

                    }else if(curr>target)
                        l--;
                    else 
                        k++;
                }
                
            }
        }
                                
        return new ArrayList<>(set);
    }
}