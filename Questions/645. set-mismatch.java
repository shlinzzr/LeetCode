// https://leetcode.com/problems/set-mismatch

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        int[] res = new int[2];
        for(int i=0; i<len; i++){
            if(set.add(nums[i])==false){
                res[0] = nums[i];
            }
        }

        for(int i=1; i<=len; i++){
            if(!set.contains(i)){
                res[1] = i;
                break;
            }

        }

        return res;
    }
}