// https://leetcode.com/problems/rearrange-string-k-distance-apart

public class Solution {
    public String rearrangeString(String str, int k) {
        
       
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->b[1]-a[1]
        );

        HashMap<Integer, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            map.put((int)(ch-'a'), map.getOrDefault( (int)(ch-'a'), 0)+1);
        }

        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            pq.offer(new int[]{en.getKey(), en.getValue()});
        }

        StringBuilder sb = new StringBuilder();

        Queue<int[]> q= new LinkedList<>();


        while(!pq.isEmpty()){

            int[] w = pq.poll();
            sb.append((char)(w[0]+'a'));
            q.offer(new int[]{w[0], w[1]-1});

            if(q.size()<k){
                continue;
            }
                

            int[] p = q.poll();
            int cnt = p[1];
            if(cnt>0)
                pq.offer(new int[]{p[0], cnt});
        }


        return sb.length()==str.length() ? sb.toString() : "";



    }
    
}