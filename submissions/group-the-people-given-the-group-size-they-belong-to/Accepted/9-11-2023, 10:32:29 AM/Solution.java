// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        
        int len = groupSizes.length;
        
        for(int i=0; i<len; i++){
            
            int siz = groupSizes[i];
            
            map.putIfAbsent(siz, new ArrayList<>());
            map.get(siz).add(i);
            
            if(map.get(siz).size()==siz){
                res.add(map.get(siz));
                map.remove(siz);
            }
        }
        
        return res;
    }
}