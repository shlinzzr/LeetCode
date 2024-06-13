// https://leetcode.com/problems/odd-even-jump

class Solution {
    public int oddEvenJumps(int[] arr) {
        int len = arr.length;
        
        boolean[] higher = new boolean[len];
        boolean[] lower = new boolean[len];
        
        // odd  arr[i] <= arr[j]
        // even arr[i] >= arr[j]
        
        
        higher[len-1] = true;
        lower[len-1] = true;
        int res = 1;
        
        //= [10,13,12,14,15]
        
        TreeMap<Integer ,Integer> map = new TreeMap<>();  
        map.put(arr[len-1], len-1);   // 15, 4
        
        for(int i=len-2; i>=0; i--){
            // arr[i] = 14 
            Integer hi = map.higherKey(arr[i]); // hi = 15
            Integer lo = map.lowerKey(arr[i]); // xx
            
            if(hi!=null){
                higher[i] = lower[map.get(hi)]; // lower[4] = true
            }
            
            if(lo!=null){
                lower[i] = higher[map.get(lo)];
            }
            
            if(higher[i]){
                System.out.println(i);
                res++;
            }
                
            
            map.put(arr[i], i);
            
        }
        
        return res;
            
        
            
            
            
    }
}