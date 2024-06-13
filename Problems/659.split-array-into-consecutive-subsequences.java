// https://leetcode.com/problems/split-array-into-consecutive-subsequences

class Solution {
    public boolean isPossible(int[] nums) {
        
        //https://www.youtube.com/watch?v=uJ8BAQ8lASE
        
        Map<Integer, Integer> freq = new HashMap<>(), need = new HashMap<>();
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i,0) + 1);

        for (int i : nums) {
            if (freq.get(i) == 0) {
                //之前可能找到過了被幹掉 所以這case不用理
                continue;
            }
                

            else if (need.getOrDefault(i,0) > 0) { // 有需要找i優先給
                need.put(i, need.get(i) - 1);
                need.put(i+1, need.getOrDefault(i+1,0) + 1);
            }   
            else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) { //找全局有沒有i+1, i+2有的話填need i+3
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                need.put(i+3, need.getOrDefault(i+3,0) + 1);
            }
            else 
                return false;
           
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}