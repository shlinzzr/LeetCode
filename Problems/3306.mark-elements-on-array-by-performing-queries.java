// https://leetcode.com/problems/mark-elements-on-array-by-performing-queries

class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        
        
        int n = nums.length;
        int m = queries.length;
        
        long[] res = new long[m];
        long sum = 0 ;
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            sum += nums[i];
            map.putIfAbsent(nums[i], new TreeSet<>());
            map.get(nums[i]).add(i);
            
        }
        
        boolean[] marked = new boolean[n];
        
        for(int i=0; i<m; i++){
            int[] q = queries[i];
            int idx = q[0];
            int k = q[1];
            
            if(marked[idx]==false){
                marked[idx] = true;
                sum -= nums[idx];
                if(map.get(nums[idx])!=null){
                    map.get(nums[idx]).remove(idx);
                    if(map.get(nums[idx]).size()==0)
                        map.remove(nums[idx]);
                }
                
            }
            
            while(k-->0 && map.size()!=0){
                
                Integer f_idx = map.get(map.firstKey()).first();
            
                if(f_idx==null) break;
                marked[f_idx] = true;
                sum -= nums[f_idx];
                
                      // System.out.println("i="+ i + " f_dix="+f_idx+ " sum=" + sum + " " + map.get(map.firstKey()));
                map.get(map.firstKey()).remove(f_idx);
                if(map.get(map.firstKey()).size()==0)
                    map.remove(map.firstKey());
            }
            
            res[i] = sum;
        }
        return res;
    }
}