// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<cards.length; i++){
            
            map.putIfAbsent(cards[i], new ArrayList<>());
            map.get(cards[i]).add(i);
        }
        
        int min = 200000;
        for(Map.Entry<Integer, List<Integer>>en : map.entrySet()){
            
            int val = en.getKey();
            List<Integer> list = en.getValue();
            
            if(list.size()<2)
                continue;
            
            for(int i=0; i<list.size()-1; i++){
                min = Math.min(min, list.get(i+1)-list.get(i));
            }
        }
        
        return min==200000? -1 : min;
        
    }
}