// https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array

class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int len = words.length;
        
        int min = len;
        
        for(int i=0; i<len; i++){
            
            if(words[i].equals(target)){
                int dis = Math.abs(startIndex-i);
                min = Math.min(min , dis);
                
                dis = Math.abs(startIndex+len-i);
                min = Math.min(min , dis);
                
                dis = Math.abs(startIndex-len-i);
                min = Math.min(min , dis);
            }
        }
        
        return min==len ? -1 : min;
        
        
    }
}