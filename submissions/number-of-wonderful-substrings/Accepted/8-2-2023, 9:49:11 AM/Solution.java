// https://leetcode.com/problems/number-of-wonderful-substrings

class Solution {
    public long wonderfulSubstrings(String word) {
        int len = word.length();
//         int[] cnt= new int[1<<10]; // a~j
        
//         int state = 0;
//         cnt[0] = 1;
        
//         long ret = 0;
//         for (int i=0; i<len; i++)
//         {
//             int idx = word.charAt(i)-'a';
//             state ^= (1<<idx);
            
//             ret += cnt[state];
            
//             for (int j=0; j<10; j++)            
//                 ret += cnt[state ^ (1<<j)];                                

//             cnt[state]++;
            
//              System.out.println(i + " " + ret );
//         }
//         return ret;
        
        int[] arr = new int[10];
        
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long res = 0;
        
        for(int i=0; i<len; i++){
            
            char ch = word.charAt(i);
            arr[ch-'a']= arr[ch-'a']^1;
            long key = genKey(arr);
            
            if(map.containsKey(key)){
                res += map.get(key);
            }
            
            for(int j=0; j<10; j++){
                
                
                
                long newkey = key;
                if(arr[j]==1)
                    newkey -= (1<<j);
                else 
                    newkey += (1<<j);
                
                if(map.containsKey(newkey))
                    res += map.get(newkey);
            }
            
            
            map.put(key, map.getOrDefault(key, 0L)+1);
            
        }
        
        return res;
    }
    
    
    private long genKey(int[] arr){
        long key = 0L;
        for(int i=9; i>=0; i--){
            key = key*2 + arr[i];
        }
        return key;
    }
}