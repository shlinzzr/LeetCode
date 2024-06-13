// https://leetcode.com/problems/positions-of-large-groups

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        
        int len = s.length();
        for(int i=0; i<len; i++){
            int st = i;
            char ch = s.charAt(i);
            while(i+1<len && s.charAt(i+1)==ch){
                i++;
            }
            
            int cnt = i-st+1;
            
            if(cnt>=3){
                List<Integer> list = new ArrayList<>();
                list.add(st);
                list.add(i);
                res.add(list);
            }
            
        }
        return res;
    }
}