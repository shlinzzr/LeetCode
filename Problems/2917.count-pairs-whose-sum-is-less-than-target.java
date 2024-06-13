// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        
        int cnt =0;
        for(int i=0; i<nums.size(); i++){
            for(int j=i+1; j<nums.size(); j++){
                if(nums.get(i)+ nums.get(j)<target)
                    cnt++;
            }
            
        }
        
        return cnt;
    }
}