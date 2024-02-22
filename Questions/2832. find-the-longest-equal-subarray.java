// https://leetcode.com/problems/find-the-longest-equal-subarray

class Solution {
    
    // public int longestEqualSubarray(List<Integer> A, int k) {
    //     int maxf = 0, i = 0, n = A.size();
    //     Map<Integer, Integer> count = new HashMap<>();
    //     for (int j = 0; j < n; j++) {
    //         count.put(A.get(j), count.getOrDefault(A.get(j), 0) + 1);
    //         maxf = Math.max(maxf, count.get(A.get(j)));
    //         if (j - i + 1 - maxf > k) {
    //             count.put(A.get(i), count.get(A.get(i)) - 1);
    //             i++;
    //         }
    //     }
    //     return maxf;
    // }
    
    
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.size(); i++){
            int n = nums.get(i);
            map.putIfAbsent(n, new ArrayList<>());
            map.get(n).add(i);
        }
        
        int res = 0; 
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            int key = en.getKey();
            List<Integer> pos = en.getValue();
            
            int j=0;
            for(int i=0; i<pos.size(); i++){
                while(j<pos.size() && (pos.get(j)-pos.get(i)+1) - (j-i+1) <=k){
                    //                   distance             // how many A
                    res = Math.max(res, (j-i+1));
                    j++;
                }
            }
        }
        
        return res;
        
    }
    
    /* [1,A,2,A,1,A]
          ^^^^^^^^^ distance : 5
    
    
    // A: pos : [1 3 5]
    // 5-1+1    2-0+1: have 3 A
    //.^^^^^
    
    */
    
  
    
}