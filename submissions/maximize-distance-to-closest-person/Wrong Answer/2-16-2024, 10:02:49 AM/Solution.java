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
        set.add(-1);
        set.add(len);
        
        List<Integer> list = new ArrayList<>(set);
        
        for(int i=0; i<list.size()-1; i++){
            
            int left = list.get(i);
            int right = list.get(i+1);
            max = Math.max(max, (right-left+1)/2);
            
        }
        
        return max;
        
        
    }
}