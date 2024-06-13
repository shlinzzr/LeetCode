// https://leetcode.com/problems/sum-of-distances

class Solution {
    public long[] distance(int[] nums) {
        int len = nums.length;
        long[] res = new long[len];
        
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
//        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
//            System.out.println(en.getKey() + " " + en.getValue().toString());
//        }
        
        int mod = (int)(1e9+7);
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            int val = en.getKey();
            List<Integer> list = en.getValue();
            int sum = 0;
            for(int i=0; i<list.size(); i++){
                sum+= list.get(i) - list.get(0);
            }
            res[list.get(0)] = sum;
            
            
             // System.out.println(en.getKey() + " " + sum);
            
            
            for(int i=1; i<list.size(); i++){
                sum =  (sum + (list.get(i)-list.get(i-1))*i) %mod;
                sum -= (list.get(i)-list.get(i-1))*(list.size()-i) ;
                
                // System.out.println("val="+val + " list.get(i)=" + list.get(i) + " " + sum);
                
                res[list.get(i)] = sum;
            }
            
        }
        
        
        
        
        return res;
    }
}
