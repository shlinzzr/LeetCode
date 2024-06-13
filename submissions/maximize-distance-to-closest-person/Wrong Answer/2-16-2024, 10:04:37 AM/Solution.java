// https://leetcode.com/problems/maximize-distance-to-closest-person

class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int max = 1;
        
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=0; i<seats.length; i++){
            
            if(seats[i]==1)
                set.add(i);
        }
        
        List<Integer> list = new ArrayList<>(set);
        
        
        max = Math.max(max, list.get(0)-0);
        max = Math.max(max, len-1-list.get(list.size()-1));
        
        for(int i=0; i<list.size()-1; i++){
            
            int left = list.get(i);
            int right = list.get(i+1);
            max = Math.max(max, (right-left+1)/2);
            
        }
        
        // -1 0 ,4
        
        return max;
        
        
    }
}