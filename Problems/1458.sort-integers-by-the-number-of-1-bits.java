// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits

class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]
        );
            
            
        for(int i=0; i<arr.length; i++){
            
            int a = arr[i];
            String bin = Integer.toBinaryString(a);
            
            int cnt=0;
            for(char ch : bin.toCharArray()){
                if(ch=='1')
                    cnt++;
            }
//             System.out.println(cnt + " "+ a + " " + i);
            pq.offer(new int[]{cnt, a, i});
            
        }
        
        for(int i=0; i<arr.length; i++){
            arr[i] = pq.poll()[1];    
        }
        
        
        return arr;
        
    }
}