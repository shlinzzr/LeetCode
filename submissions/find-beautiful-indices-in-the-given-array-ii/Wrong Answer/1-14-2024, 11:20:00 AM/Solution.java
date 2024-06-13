// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-ii

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
       
        List<Integer> lista = new ArrayList<>();
        int ia = s.indexOf(a);
        
        while(ia!=-1){
            lista.add(ia);
            ia = s.indexOf(a, ia+1);
        }
        
        TreeSet<Integer> setb = new TreeSet<>();
        int ib = s.indexOf(b);
        while(ib!=-1){
            setb.add(ib);
            ib = s.indexOf(b, ib+1);
        }
        
        
        List<Integer> res = new ArrayList<>();
        for(int aa : lista){
            
            Integer ceil = setb.ceiling(aa-k);
            if(ceil!=null && ceil<=aa+k);
                res.add(aa);
            
        }
        return res;      
           
       
    }
}