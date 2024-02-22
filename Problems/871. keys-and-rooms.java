// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set =new HashSet<>();
        helper(0, set, rooms);
        
        return set.size()==rooms.size();
            
    }
    
    private void helper(int key, Set<Integer> set, List<List<Integer>> rooms){
        set.add(key);
        List<Integer> keys = rooms.get(key);
        for(int k: keys){
            if(!set.contains(k))
                helper(k, set, rooms);
        }
    }
}