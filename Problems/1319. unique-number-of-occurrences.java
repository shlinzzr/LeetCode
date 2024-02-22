// https://leetcode.com/problems/unique-number-of-occurrences

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
    
        Set<Integer> set = new HashSet<>();
        
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            
            if(set.contains(en.getValue()))
                return false;
            
            set.add(en.getValue());
        }
        
        return true;
    }
    
}