// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>(); // val, idx
        int len = nums.length;
        int[] res = new int[len-k+1];
        
        int cnt=0;
        for(int i=0; i<len ;i++){
            int cur = nums[i];
            map.put(cur, map.getOrDefault(cur, 0)+1);
            cnt++;
            // System.out.println("i=" +i + " cur="+ cur + " set=" + map.keySet());
            
            int del = i-k;
            if(cnt>k){
                
                // System.out.println("del i=" + i + " k=" + k +" nums[del]="+nums[del]);
                
                map.put(nums[del], map.get(nums[del])-1);
                cnt--;
                if(map.get(nums[del])==0)
                    map.remove(nums[del]);
            }
            
            
            /*
     x x x
[-7,-8,7,5,7,1,6,0]
4
            
i=0 cur=-7 set=[-7]
i=1 cur=-8 set=[-8, -7]
i=2 cur=7 set=[-8, -7, 7]
i=3 cur=5 set=[-8, -7, 5, 7]
i=4 cur=7 set=[-8, -7, 5, 7]
i=5 cur=1 set=[-8, -7, 1, 5, 7]
del i=5 k=4 nums[del]=-8
i=6 cur=6 set=[-7, 1, 5, 6, 7]
del i=6 k=4 nums[del]=7
del i=6 k=4 nums[del]=5
i=7 cur=0 set=[-7, 0, 1, 6, 7]
del i=7 k=4 nums[del]=5

*/
            
            
            
            if(i+1-k>=0){
                res[i+1-k] = map.lastKey();
            }
        }
        
        return res;
        
        
        
    }
}