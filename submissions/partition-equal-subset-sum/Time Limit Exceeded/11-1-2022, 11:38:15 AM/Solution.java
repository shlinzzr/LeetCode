// https://leetcode.com/problems/partition-equal-subset-sum

public class Solution {
    public boolean canPartition(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
            sum += i;
        }
        if(sum % 2 == 1) return false;
        return helper(map, sum / 2);
    }
    
    private boolean helper(Map<Integer, Integer> map, int target){
        /*target is achieveable*/
        if(map.containsKey(target) && map.get(target) > 0) return true;
        /*dfs*/
        for(int key : map.keySet()){
            if(key < target && map.get(key) > 0){
                map.put(key, map.get(key) - 1);
                if(helper(map, target - key)) return true;
                map.put(key, map.get(key) + 1);
            }
        }
        return false;
    }
}