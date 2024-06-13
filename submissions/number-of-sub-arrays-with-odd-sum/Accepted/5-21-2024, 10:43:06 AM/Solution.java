// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum

class Solution {
    public int numOfSubarrays(int[] arr) {
        int len = arr.length;
        int M = (int) 1e9+7;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0,1L);
        long res = 0;
        int sum = 0;


        for(int i=0; i<len;i++){
            sum += arr[i];
            sum %= 2;
            for(int k : map.keySet()){

                if(k%2==1 && sum%2==0){
                    res+= map.get(k)%M;
                }
            
                if(sum%2==1 && k%2==0){
                    res += map.get(k)%M;
                }
            }
            map.put(sum, map.getOrDefault(sum, 0L)+1L);
        }
        return (int) (res%M);
        
    }
}