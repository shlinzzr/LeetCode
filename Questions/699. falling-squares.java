// https://leetcode.com/problems/falling-squares

class Solution {
    
    //https://leetcode.com/problems/falling-squares/discuss/108775/Easy-Understood-TreeMap-Solution
    
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // at first, there is only one segment starting from 0 with height 0
        map.put(0, 0);
        
        // The global max height is 0
        int max = 0;

        for(int[] position : positions) {

            // the new segment 
            int start = position[0], end = start + position[1];

            // find the height among this range
            
            
            //            st          ed
            // x x x x x x x x x x x x x x 
            //     lower <-[       
            //     key:|     
            //         ( ->higher    <-) ... update h
            
            
            Integer key = map.floorKey(start);
            int h = map.get(key);
            key = map.higherKey(key);
            while(key != null && key < end) {
                h = Math.max(h, map.get(key));
                key = map.higherKey(key);
            }
            h += position[1];

            // update global max height
            max = Math.max(max, h);
            list.add(max);

            // update new segment and delete previous segments among the range
            int tail = map.floorEntry(end).getValue();
            map.put(start, h);
            map.put(end, tail);
            key = map.higherKey(start);
            while(key != null && key < end) {
                map.remove(key);
                key = map.higherKey(key);
            }
        }
        return list;
    }
}