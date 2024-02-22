// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n ,0)+1);
        }

        int op = 0;
        for(int k : map.keySet()){
            int v = map.get(k);
            if(v>=3){
                op += v/3;
                v = v%3;
                if(v>0){
                    op++;
                }
            }else if(v==2){
                op++;
            }else{
                return -1;
            }
        }

        return op==0 ? -1 : op;
    }
}