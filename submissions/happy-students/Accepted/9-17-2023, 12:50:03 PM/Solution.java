// https://leetcode.com/problems/happy-students

class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int count=0;
        if(nums.get(0)>0)
            count++;
        for(int i=0;i<nums.size();i++){
            if(i==nums.size()-1){
                if(i+1>nums.get(i))
                    count++;
            }
            else{
                if(i+1>nums.get(i) && i+1<nums.get(i+1))
                    count++;
                
            }
        }
        return count;
    }
}