// https://leetcode.com/problems/find-the-losers-of-the-circular-game

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] seen = new boolean[n]; // f, f, f
        
        // k 2k 3k
        // ooo  
        // 12345
          // ^   
        
        
        int idx =0;
        seen[0]=true;
        for(int i=1;i<=n; i++){
            int step = i *k;
            int next = (idx+step)%n;
            if(seen[next])
                break;
            seen[next]=true;
            idx = next;
            
        }
        
              
              
        
        
        
//         int mul=1;
//         int idx = 0;
//         // seen[0]=true;      //t, f, f
        
//         for(int i=0;i<n;i++){
//             int step=(i+1)*k;//2
//             mul++;
//             int next = (idx+step)%n; //2 
//             if(seen[next])
//                 break;
//             idx = next; // 2
//         }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(seen[i]==false)
                list.add(i);
        }
        
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i]= list.get(i)+1;
        }
        
        
        
        return res;
        
        
    }
}