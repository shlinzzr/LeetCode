// https://leetcode.com/problems/number-of-wonderful-substrings

class Solution {
    public long wonderfulSubstrings(String word) {
        int len = word.length();
        
        int[] arr= new int[1<<10]; // a~j
        
        // HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        
        int state = 0;
        arr[0] = 1;
        
        long ret = 0;
        for (int i=0; i<len; i++)
        {
            int idx = word.charAt(i)-'a';
            state ^= (1<<idx);
            
            ret += arr[state];
            
            for (int j=0; j<10; j++)            
                ret += arr[state ^ (1<<j)];                                

            arr[state]++;
        }
        return ret;
        
        
        
//         int res = 0;
//         int cur = 0;
//         for(int i=0; i<len; i++){
            
//             char ch = word.charAt(i);
//             arr[ch-'a']++;
//             int key = genKey(arr);
            
//             if(map.containsKey(key)){
//                 res += map.get(key).size();
//             }
            
//             map.putIfAbsent(key, new ArrayList<>());
//             map.get(key).add(i);
            
//             for(int a: arr){
//                 System.out.print(a + ",");
//             }
//             System.out.println();
            
//             System.out.println(i + " " + key + " " + i);
//         }
        
//         return res;
    }
    
    
    private int genKey(int[] arr){
        int key = 0;
        for(int i=0; i<10; i++){
            key = key*2 + arr[i];
        }
        return key;
    }
}