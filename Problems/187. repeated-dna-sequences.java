// https://leetcode.com/problems/repeated-dna-sequences

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if(len<10)
            return new ArrayList<>();
        
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<len-10+1; i++){
            
            String sub = s.substring(i, i+10);
            // System.out.println(sub);
            
            if(set.contains(sub))
                res.add(sub);
             else
                set.add(sub);
        }
        
        return new ArrayList<>(res);
        
        
    }
}