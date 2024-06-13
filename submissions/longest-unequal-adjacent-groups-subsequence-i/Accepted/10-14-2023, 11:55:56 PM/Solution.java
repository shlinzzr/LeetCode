// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        
        
        List<String> res =new ArrayList<>();
        
        for(int st=0; st<n; st++){
            List<Integer> list = new ArrayList<>();
            for(int j=st; j<n; j++){
                if(list.isEmpty() || groups[list.get(list.size()-1)]!=groups[j]){
                    list.add(j);
                }
            }
            
            if(list.size()>res.size()){
                
                for(int idx : list){
                    res.add(words[idx]);
                }
                
            }
            
        }
        
        return res;
        
        
    }
}