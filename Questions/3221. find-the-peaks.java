// https://leetcode.com/problems/find-the-peaks

class Solution {
    public List<Integer> findPeaks(int[] m) {
        int len = m.length;
        
         List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<len-2; i++){
            if(m[i]<m[i+1] && m[i+1]>m[i+2])
               list.add(i+1);
        }
        
        return list;
        
        
    }
}