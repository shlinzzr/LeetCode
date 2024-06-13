// https://leetcode.com/problems/sliding-window-median

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        
        double[] res= new double[len-k+1];
        
        TreeMap<Long, Integer> map = new TreeMap<>();
        
        int idx = 0;
        int st =0;
        for(int ed=0; ed<len; ed++){
            
            map.put((long)nums[ed], map.getOrDefault((long)nums[ed],0)+1);
            if(ed<k-1)
                continue;
            
            List<Long> list = new ArrayList<>();
            for(Map.Entry<Long, Integer> en : map.entrySet()){
                for(int r=0; r<en.getValue(); r++){
                    list.add(en.getKey());
                }
            }
            
            // System.out.println(list.toString());
            
            
            
            if(list.size()%2==0){  // 0, 1
                res[idx] = (double) (list.get(k/2)+list.get(k/2-1))/2;
            }else{ // 0, 1, 2
                res[idx] = (double) (list.get(k/2));
            }
            idx++;
            
            if(ed-st+1==k){
                map.put((long)nums[st], map.getOrDefault((long)nums[st],0)-1);
                if(map.get((long)nums[st])==0)
                    map.remove((long)nums[st]);
                
                st++;
            }
            
        }
        
        return res;
    }
}