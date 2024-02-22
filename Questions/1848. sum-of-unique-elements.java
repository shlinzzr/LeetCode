// https://leetcode.com/problems/sum-of-unique-elements

class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int sum=0;
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            if(en.getValue()==1)
                sum+=en.getKey();
        }
        
        return sum;
    }
}