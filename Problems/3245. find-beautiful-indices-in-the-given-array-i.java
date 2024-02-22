// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        
        List<Integer> list=  new ArrayList<>();
//         for(int i=0; i<s.length()-a.lenght(); i++){
            
//             boolean match = true;
//             for(int ai=0; ai<a.length();ai++){
//                 if(s.charAt(i+a)!=a.charAt(ai)){
//                     match=false;
//                     break;
//                 }
//             }
//             if(!match) continue;
            
//             for(int bi=0; bi<b.length(); bi++){
                
//             }
//         }
//         String abcb = "abcb";
//         System.out.println(abcb.indexOf("b", 1+1));
        
        int ia= s.indexOf(a);
        
        while(ia!=-1 ){
            
            
            int ib = s.indexOf(b);
            while(ib!=-1){
                
                // System.out.println(ia+ " " + ib); 
                
                if(Math.abs(ia-ib)<=k){
                    list.add(ia);
                    ia = s.indexOf(a, ia+1);
                    break;

                }else{

                    ib= s.indexOf(b, ib+1);
                   
                }
                
                
            }
            
             if(ib==-1){
                 ia = s.indexOf(a, ia+1);
             }

            
            
           
            
        }
        return list;
    }
}