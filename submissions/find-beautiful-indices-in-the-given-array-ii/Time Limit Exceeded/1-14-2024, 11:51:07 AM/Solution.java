// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-ii

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
       
        List<Integer> lista = new ArrayList<>();
        int ia = s.indexOf(a);
        
        while(ia!=-1){
            lista.add(ia);
            ia = s.indexOf(a, ia+1);
        }//  0 ,4 , 7
        
        // 1 , 5 9
        
        List<Integer> listb = new ArrayList<>();
        int ib = s.indexOf(b);
        while(ib!=-1){
            listb.add(ib);
            ib = s.indexOf(b, ib+1);
        }
        // System.out.println()
        
        List<Integer> res = new ArrayList<>();
        
        if(lista.isEmpty() || listb.isEmpty()) return res;
        
       ia =0; ib=0;
        
        while(ia<lista.size() && ib<listb.size()){
            
            int v1 = lista.get(ia);
            int v2 = listb.get(ib);
            
            if(Math.abs(v1-v2)<=k){
                res.add(v1);
                ia++;
                // ib = s.indexOf(b, ib+1);
                
            }else{
                if(v1<v2){
                   ia++;
                }else
                    ib++;
            }
        }
        
        
        
        
        
        
//         for(int aa : lista){
            
//             Integer ceil = setb.ceiling(aa-k);
//             if(ceil!=null && ceil!=-1 && ceil<=aa+k)
//                 res.add(aa);
            
//         }
        return res;      
           
       
    }
}