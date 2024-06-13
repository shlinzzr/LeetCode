// https://leetcode.com/problems/index-pairs-of-a-string

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        int len = words.length;
        

        ArrayList<int[]> list = new ArrayList<>();        
        
        for(int i=0; i<len; i++){
            String w = words[i];
            
            int idx = text.indexOf(w);
            while(idx>=0){
                
                list.add(new int[]{idx, idx+ w.length()-1});    
                
                idx = text.indexOf(w, idx+1);
            }
        }
        
        int[][] res = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        Arrays.sort(res, (a,b)->(a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]));
        
        
        return res;
    }
}