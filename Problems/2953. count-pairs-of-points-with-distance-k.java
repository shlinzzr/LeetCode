// https://leetcode.com/problems/count-pairs-of-points-with-distance-k

class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int n = coordinates.size();
        
        int ret = 0;
        for (int a = 0; a<=k; a++)
        {
            HashMap<String, Integer> map = new HashMap<>();
            
            for (int i=0; i<n; i++)
            {
                int x1 = coordinates.get(i).get(0);
                int y1 = coordinates.get(i).get(1);
                int x2 = a^x1;
                int y2 = (k-a)^y1;
                
                // long code = (long)x2*10000000 + y2;              
                String code = x2+"_"+y2;
                
                if(map.containsKey(code)){
                    ret += map.get(code);
                }
                
                code = x1+"_"+y1;
                // code = (long)x1*10000000 + y1;
                
                map.put(code ,map.getOrDefault(code, 0)+1);
            }
        }
        
        return ret;
    }
}


// k = a + b
// a = x1 ^ x2 => x2 = a ^ x1
// b = y1 ^ y2 => y2 = b ^ y1 => y2 = (k-a)^y1