// https://leetcode.com/problems/find-longest-awesome-substring

class Solution {
    public int longestAwesome(String s) {
        
        int[] arr = new int[10];
        
        int n = s.length();
        s="#"+s;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        int ret = 0;
        
        for (int i=1; i<=n; i++)
        {            
            
            arr[s.charAt(i)-'0']++;
            
            int key = makeKey(arr);
            
            if(map.containsKey(key)){
                ret = Math.max(ret, i-map.get(key));
            }
            
            
            for (int k=0; k<10; k++)
            {
                int newKey = key;
                
                if (((key>>k)&1)==0)
                    newKey |= (1<<k);
                else
                    newKey -= (1<<k);
                
                if(map.containsKey(newKey))
                    ret = Math.max(ret, i-map.get(newKey));
            }
            
            if(!map.containsKey(key))
                map.put(key, i);
        }
        
        return ret;
    }
    
    private int makeKey(int[] arr){
        int key=0;
        for (int i=0; i<10; i++)
        {
            if (arr[i]%2==0)
                key+=(0<<i);
            else
                key+=(1<<i);
        }
        return key;
    }
    
}