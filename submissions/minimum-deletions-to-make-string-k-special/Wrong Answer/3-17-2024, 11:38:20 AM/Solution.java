// https://leetcode.com/problems/minimum-deletions-to-make-string-k-special

class Solution {
    public int minimumDeletions(String word, int abs) {
        
        HashMap<Character, Integer> map= new HashMap<>();
        
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        TreeMap<Integer, Integer> f = new TreeMap<>(); // freq , 有幾個數字
        for(int v : map.values()){
            f.put(v, f.getOrDefault(v,0)+1);
        }
        
         // for(int key : f.keySet())
         //    System.out.println(key + " "+ f.get(key));
        
        int res = word.length();
        
        for(int i = f.firstKey(); i<=f.lastKey(); i++){
            
            int cur = 0;
            for(int k : f.keySet()){
                
                if(k<i){
                    cur += Math.min(k*f.get(k), (i-k) * f.get(k));
                }
                 
                
                if(k-i>abs){
                    cur += Math.min(f.get(k)*k , (k-i-abs)*f.get(k));
                }
                
            }
            
            // System.out.println (i + " cur="+cur);
              res = Math.min(res, cur);
            
            
        }
        
        
        return res;
        
//        
//         List<Integer> flist = new ArrayList<>(f.keySet());
        
//         for(int i=0; i<flist.size(); i++){
            
            
//             HashMap<Integer, Integer> m = new HashMap<>(f);
            
//             int cur = 0;
//             // to achieve freq 
//             int freq = flist.get(i);
            
//             //delete below
//             for(int j=0; j<i; j++){
//                 int df = flist.get(j);
//                 cur +=  f.get(df);
                
//                 m
//             }
            
//             //delete upper
//             for(int j=i+1; j<flist.size(); j++){
//                 int df = flist.get(j);
                
//                 if(df-freq>k){
//                     cur += df
                        
//                 }
//             }
            
//             res = Math.min(res, cur);
            
//         }
        
//         return res;
        // dabdcbdcdcdd
        // ddddda
        
// a 1 1 
// b 2 1
// c 3 1
// d 5 1
    
    
//     1 => 5
//     2 =>
        
        
        
//         while(f.lastKey() - f.firstKey()>k){
//             int first = f.firstKey();
//             int last = f.lastKey();
            
//             int fcnt = f.get(first);
//             int lcnt = f.get(last);
                
            
//             if(first*fcnt<=last * lcnt){
                
//                 res+= first*fcnt;
//                 f.put(first+1, f.getOrDefault(first+1, 0)+fcnt);
//                 f.remove(first);
//             }else{
//                 res += last * lcnt;
//                 f.put(last-1, f.getOrDefault(last-1, 0)+lcnt);
//                 f.remove(last);
//             }
            
//         }
        
        
//         1:1              10:10 k=8
//             2:11
        
        
    }
}