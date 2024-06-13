// https://leetcode.com/problems/find-all-duplicates-in-an-array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int k : map.keySet()){
            if(map.get(k)>1){
                res.add(k);
            }
        }

        return res;

    }
}