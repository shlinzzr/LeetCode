// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        
        Arrays.sort(nums);
        
        Set<List<Integer>> set = new HashSet<>();
        
        
        for(int i=0; i<len-3; i++){
            
            for(int a=i+1; a<len-2; a++){

                int j=a+1, k=len-1;
                while(j<k){
                    long sum = (long)nums[i]+(long)nums[a]+(long)nums[j]+(long)nums[k];
                    // System.out.println(i+", " + a + ", " + j + ", "+ k+ " =" + sum); 
                    if(sum==target){
                        set.add(Arrays.asList(nums[i],nums[a],nums[j],nums[k]));
                         while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[j] == nums[k-1]) k--;
                        j++;
                        k--;
                    }else if (sum<target)
                        j++;
                    else
                        k--;
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}