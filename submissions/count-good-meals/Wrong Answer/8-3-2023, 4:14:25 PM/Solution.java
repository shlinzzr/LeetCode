// https://leetcode.com/problems/count-good-meals

class Solution {
    public int countPairs(int[] del) {
        int len = del.length;
        
        
        Set<Integer> powset = new HashSet<>();
        int cur =1;
        for(int i=0; i<=21; i++){
            powset.add(cur);
            cur*=2;
        }
        
        // System.out.println(powset);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int d : del){
            map.put(d, map.getOrDefault(d,0)+1);
        }
        
        int M = (int) 1e9+7;
        
        long cnt = 0;
        
        for(int i=0; i<del.length; i++){
            
            int d = del[i];
            
            for(int p : powset){
                
                // System.out.println(p + " " + d + " contain p-d" + (map.containsKey(p-d)))
                
                if(map.containsKey(p-d)){
                    
                    if(p-d==d ){
                        if(map.get(p-d)>=2)
                            cnt = (cnt + map.get(p-d)-1)%M;
                    }else
                    
                        cnt = ( cnt + map.get(p-d) ) %M;
                }
                
                
            }
        }        
        
        
        
        return (int)(cnt/2%M);
        
        
        
//         Arrays.sort(del);
//         int st=0, ed=len-1;
//         int M = (int) 1e9+7;
//         long cnt=0;
//         while(st<ed){
//             int sum = 
//         }
        
        
    }
    
    private boolean isPowOf2(int sum){
        
        while(sum>0){
            
            if(sum==1)
                return true;
            
            if(sum%2!=0)
                return false;
            
            sum/=2;
        }
        
        return false;
        
        
    }
}