// https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment

class Solution {
    
    
    private int isOk(int m, HashMap<Integer, Integer> map ){
        
        int res =0;
        
        
        for(int k : map.keySet()){
            int v = map.get(k);
            // check xm + y(m+1) = v, 
            
            while(v>0){
               if(v%(m+1)==0){
                   res+=v/(m+1);
                   break;
               }else if(v%m==0){
                   res += v/m;
                   break;
               }
                
               v-=m;
               res++;
            }
            
            if(v<=0)
                return -1;
        }
        
        return res;
        
    }
    
    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        int min = Integer.MAX_VALUE;
        for(int k : map.keySet()){
            min = Math.min(min, map.get(k));
        }
        
        
        int res =0;
        int st=1, ed=min;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            res = isOk(mid, map);
            if(res!=-1){
                st = mid;
            }else
                ed = mid-1;
            
        }
        
        return res;
        
        
        
        
        
        // return st;
        
        
        
        
        
        
//         int min = Integer.MAX_VALUE;
//         for(int k : map.keySet()){
//             min = Math.min(min, map.get(k));
//         }
        
        
//         int g=0;
//         for(int k : map.keySet()){
//             int cnt = map.get(k);
//             if(cnt<=min){
//                 g++;
//                 continue;
//             }else{
                
//                 g+=cnt/(min);
                
//                 if(cnt%(min)!=0)
//                     g++;
                
//             }
            
//         }
        
//         return g;
        
    } 
    // 1:5, 2:3, 3:4
    // 111 11 222 33 33
    //
}

// ix+(i+1)y=k
// ix-k = -(i+1)y
// 2x-k = -3y
// ix + yi + y = k
