// https://leetcode.com/problems/find-all-duplicates-in-an-array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> res = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);

            if(map.get(n)>1) res.add(n);
        }


        return new ArrayList<>(res);

    }
}