// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum

class Solution {
    public int numOfSubarrays(int[] arr) {
        int len = arr.length;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        int sum = 0;
        for(int i=0; i<len;i++){
            sum += arr[i];
            for(int k : map.keySet()){
            
                if((sum-k)%2==1){
                    res += map.get(k);
                }
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
        
    }
}