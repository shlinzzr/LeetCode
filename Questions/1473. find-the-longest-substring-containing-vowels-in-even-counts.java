// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts

class Solution {
    
    
    public int findTheLongestSubstring(String s) {
        
        int[] arr = new int[5];
        HashMap<Integer, Integer> map = new HashMap<>(); // val, idx
        map.put(0,-1);
        
        int ret = 0;
        
        for (int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            
            switch(ch){
                case 'a':
                    arr[0] = (arr[0]+1)%2;
                    break;
                    
                case 'e':
                    arr[1] = (arr[1]+1)%2;
                    break;
                    
                case 'i':
                    arr[2] = (arr[2]+1)%2;
                    break;
                    
                case 'o':
                    arr[3] = (arr[3]+1)%2;
                    break;
                    
                case 'u':
                    arr[4] = (arr[4]+1)%2;
            }
            
            int key = 0;
            for (int j=0; j<5; j++)
                key = key*2 + arr[j];
            
            if(map.containsKey(key))
                ret = Math.max(ret, i-map.get(key));
            else
                map.put(key, i);
        }
        
        return ret;
        
        
    }
}