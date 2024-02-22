// https://leetcode.com/problems/finding-the-users-active-minutes

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] res = new int[k];
        
        
        
         // id, act min
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] t : logs){
            int id = t[0];
            int min = t[1];

            HashSet<Integer> set = map.getOrDefault(id, new HashSet<Integer>());
            set.add(min);
            map.put(id, set);
        }
        
        
        
        for(Map.Entry<Integer, HashSet<Integer>> en : map.entrySet()){
            int uam = (int)en.getValue().size();
            res[uam-1]++;
        }
        
        return res;
        
    }
}