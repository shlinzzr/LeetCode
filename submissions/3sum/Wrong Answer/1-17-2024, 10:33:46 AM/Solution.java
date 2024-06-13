// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res =new HashSet<>();
        
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i=0; i<len ;i++){
            
            int st=i+1, ed=len-1;
            
            while(st<ed){
                
                int sum = nums[i]+ nums[st]+nums[ed];
                if(sum==0){
                    st++;
                    ed--;
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[st], nums[ed]}));
                }else if(sum>0)
                    ed--;
                else
                    st++;
            }
        }
        
        return new ArrayList<>(res);
    }
}