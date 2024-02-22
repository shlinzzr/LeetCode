// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<groupSizes.length; i++){
            int num = groupSizes[i];
            
            List<Integer> idxList = map.get(num);
            if(idxList==null)
                idxList = new ArrayList<>();
            idxList.add(i);
            map.put(num, idxList);
            
            
            if(idxList.size()==num){
                res.add(idxList);
                map.remove(num);
            }
            
        }
        
        return res;
        
        
//         for(Entry<Integer, List<Integer>> en : map.entrySet()){
//             int num = en.getKey();
//             List<Integer> idxList = en.getValue;
            
//         }
       
        
        
        
        
    }
}