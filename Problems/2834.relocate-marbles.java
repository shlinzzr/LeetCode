// https://leetcode.com/problems/relocate-marbles

class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
       
        HashSet<Integer> set = new HashSet<>();
        
        for(int n: nums){
            set.add(n);
        }
        
        int len = moveTo.length;
        for(int i=0; i<len; i++){
            
            int f = moveFrom[i];
            int t = moveTo[i];
            
            if(!set.contains(f))
                continue;

            set.remove(f);
            set.add(t);
        }
        
         List<Integer> list = new ArrayList<>(set);
        
        Collections.sort(list);
        
        return list;
    }
    
}