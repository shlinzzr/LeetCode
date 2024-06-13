// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        for(int i=0; i<len ;i++){
            int j=i+1;
            int k = len-1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(new ArrayList<>(list));
                    j++;
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    k--;
                }
            }
            
        }

        return new ArrayList<>(res);
    }
}