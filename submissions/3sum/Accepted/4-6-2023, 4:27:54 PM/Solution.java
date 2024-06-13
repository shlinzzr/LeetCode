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
                    List<Integer> list =new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
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