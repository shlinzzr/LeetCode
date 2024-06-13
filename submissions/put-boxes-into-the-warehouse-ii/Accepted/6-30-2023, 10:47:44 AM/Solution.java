// https://leetcode.com/problems/put-boxes-into-the-warehouse-ii

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        
        int len = boxes.length;
        int wLen = warehouse.length;
        
        // Arrays.sort(boxes);
        
        int[] front = new int[wLen];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<wLen; i++){
            int w = warehouse[i];
            min = Math.min(min, w);
            front[i]=min;
        }
        
        
        min = Integer.MAX_VALUE;
        // int[] back = new int[wLen];        
        for(int i=wLen-1; i>=0; i--){
            int w = warehouse[i];
            min = Math.min(min, w);
            // back[i]=min;
            
            warehouse[i] = Math.max( front[i], min);
        }
        
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int b : boxes){
            map.put(b, map.getOrDefault(b, 0)+1);
        }
        
        int res =0;
        
        for(int i=0; i<wLen; i++){
            
            int w = warehouse[i];
            Integer b = map.floorKey(w);
            
            // System.out.println("w="+w + " b="+b);
            
            if(b!=null){
                res++;
                map.put(b, map.get(b)-1);
                
                if(map.get(b)==0)
                    map.remove(b);    
            }
            
        }
        
        
        return res;
        
                
        
    }
}