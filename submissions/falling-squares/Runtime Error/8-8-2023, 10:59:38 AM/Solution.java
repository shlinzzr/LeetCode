// https://leetcode.com/problems/falling-squares

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        // Arrays.sort(positions, (a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        List<Integer> res = new ArrayList<>();
        
        int len = positions.length;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int max = 0;
        
        for(int[] curr : positions){
            
            int left = curr[0];
            int right = curr[0]+curr[1];
            int height = curr[1];
            
             // System.out.println(left + " " + right + " " + height);
            
            Integer hi = map.higherKey(left);
            Integer lo = map.lowerKey(right);
            
            if((hi!=null && hi<right) || (lo!=null && lo>left)){
                height+= Math.max(map.get(hi), map.get(lo));
                
                
                if(map.higherKey(left)<right)
                    map.remove(hi);
                if(map.lowerKey(right)>left)
                    map.remove(lo);
            }else if(hi!=null && lo!=null && map.get(hi)==map.get(lo)){
                
                  height+= Math.max(map.get(hi), map.get(lo));
                 if(map.higherKey(left)<right)
                    map.remove(hi);
                if(map.lowerKey(right)>left)
                    map.remove(lo);
                
            }
            
            max = Math.max(max, height);
            map.put(left, height);
            map.put(right, height);
            res.add(max);
            
            // System.out.println(max);
            
        }
        
        return res;
        
    }
}