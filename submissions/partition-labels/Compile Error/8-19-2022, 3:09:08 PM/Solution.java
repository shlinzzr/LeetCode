// https://leetcode.com/problems/partition-labels

class Solution {
    public List<Integer> partitionLabels(String s) {
         List<Integer> res =new ArrayList<>();
        
        
        List<HashSet<Character>> list= new ArrayList<>();
        list.add(new HashSet<>());
        
        
        for(char c : s.toCharArray()){
            boolean hit=false;
            
            for(HashSet set : list){
                if(set.contains(c)){
                    
                }
            }
            
        }
        
        
        
        
        
        
    }
}