// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // sum, idx
        map.put(0, -1); //<2,-1>
        
        int sum =0, cnt=0;
        for(int i=0; i<len; i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                int preIdx = map.get(sum-k);
                cnt++;
            }
            map.put(sum, i);
            System.out.println(sum + " " + i);
        }
        return cnt;
    }
}