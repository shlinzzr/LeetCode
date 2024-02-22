// https://leetcode.com/problems/find-original-array-from-doubled-array

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] res = new int[changed.length/2];
        int cnt =0, len = changed.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : changed){
            map.put(i, map.getOrDefault(i, 0) +1); 
              // System.out.println(i + ", val-"+map.get(i));
        }
        
        // Arrays.sort(changed, Collections.reverseOrder());
        // for(int i=0; i<len;i++) changed[i] = -changed[i];
        Arrays.sort(changed); 
        // for(int i=0; i<len;i++) changed[i] = -changed[i];
                                
        
        int idx =0;
        for(int i=len-1; i>=0 && idx<len/2; i--){
            
            int num = changed[i]; //8
            int n_2 = num/2;
            
            if(map.containsKey(num/2) && num==n_2*2 && map.get(num/2)>0 &&  map.get(num)>0 && (num!=num/2 || num==num/2 && map.get(num)>=2)){
                
                
                map.put(num/2, map.get(num/2)-1);
                map.put(num, map.get(num)-1);
                res[idx]=num/2;
                idx++;
            }
        }
        
        
        if(idx<len/2 || len%2==1){
            return new int[0];
        }
        
        return res;
        
        
    }
}