// https://leetcode.com/problems/most-frequent-ids

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        
        int len = nums.length;
        
        Map<Integer, Long> map = new HashMap<>(); // id, freq
        
        TreeMap<Long, Set<Integer>> tmap = new TreeMap<>(); // freq , List<id>
        
        long[] res = new long[len];
        
        for(int i=0; i<len; i++){
            
            int id = nums[i];
            long f = (long)freq[i];
            
            
            if(map.containsKey(id)){
                long old_f = map.get(id);
            
                tmap.getOrDefault(old_f, new HashSet<>()).remove(id);
                if(tmap.getOrDefault(old_f, new HashSet<>()).size()==0) tmap.remove(old_f);
            }
            
            
            map.put(id, map.getOrDefault(id, 0L)+f);
            
            long new_f = map.get(id);
            tmap.putIfAbsent(new_f, new HashSet<>());
            tmap.get(new_f).add(id);
            
            res[i] = tmap.lastKey();
            
            
        }
        
        return res;
            
        
    }
}