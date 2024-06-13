// https://leetcode.com/problems/merge-similar-items

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
         List<List<Integer>> res = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int[] item : items1){
            map.put(item[0], map.getOrDefault(item[0], 0)+item[1]);
        }
        
        for(int[] item : items2){
            map.put(item[0], map.getOrDefault(item[0], 0)+item[1]);
        }
        
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            list.add(en.getKey());
            list.add(en.getValue());
            res.add(list);
        }
        
        return res;
        
    }
}