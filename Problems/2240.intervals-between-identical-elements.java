// https://leetcode.com/problems/intervals-between-identical-elements

class Solution {
    public long[] getDistances(int[] arr) {
        int len = arr.length;
        
        long[] res = new long[len];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // val , List<idx>
        for(int i=0; i<len ;i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            List<Integer> list = en.getValue();
            long sum = 0;
            for(int i=0; i<list.size(); i++){
                sum+= list.get(i)-list.get(0);
            }
            
            res[list.get(0)]=sum;
            
            for(int i=1; i<list.size(); i++){
                
                sum += (list.get(i)-list.get(i-1))*i;
                sum -= (list.get(i)-list.get(i-1)) * (list.size()-i);
                res[list.get(i)]=sum;
            }
        }
                        
        return res;
        
    }
}