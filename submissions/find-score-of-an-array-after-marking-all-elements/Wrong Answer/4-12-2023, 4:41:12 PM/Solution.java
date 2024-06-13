// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements

class Solution {
    public long findScore(int[] nums) {
        int len = nums.length;
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            map.putIfAbsent(n, new ArrayList<>());
            map.get(n).add(i);
        }
        
        boolean[] bool = new boolean[len];
        
        int cnt = 0;
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            int n = en.getKey();
            List<Integer> list = en.getValue();
            
            for(int i : list){
                
                if(bool[i]==false){
                    bool[i]=true;
                    if(i-1>=0)  bool[i-1]=true;
                    if(i+1<len) bool[i+1]= true;
                     cnt += n;
                }
                
               
            }
        }
        
        return cnt;
        
    }
}