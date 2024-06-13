// https://leetcode.com/problems/repeated-dna-sequences

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        
//         String a = "abbbbb";
//         System.out.println(a.indexOf(a));
//         System.out.println(a.indexOf(a, a.indexOf(a)));
//         return res;
        
        int len = s.length();
        
        int st=0;
        for(int ed=10; ed<=len; ed++){
            
            String str = s.substring(st, ed);
            
            int idx = s.indexOf(str);
            
            if(s.indexOf(str, idx+1)>=0)
                res.add(str);
            
            if(ed-st==10)
                st++;
            
        }
        
        
        return new ArrayList<>(res);
    }
}