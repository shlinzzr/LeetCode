// https://leetcode.com/problems/unique-number-of-occurrences

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : arr){
            
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else{
                
                map.put(i,1);
                
            }
            
        }
        
        for (Map.Entry<Integer, Integer> en : map.entrySet()){
        // for(Entry<Integer, Integer> en : map.entrySet()){
            
            if(set.contains(en.getValue()))
                return false;
            else
                set.add(en.getValue());
        
            
        }
       
        
        return true;
            
    }
}