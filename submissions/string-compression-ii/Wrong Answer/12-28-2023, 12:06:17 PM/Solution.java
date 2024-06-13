// https://leetcode.com/problems/string-compression-ii

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        //怎麼刪最划算
        // 1. char cnt == 1  "a" => ""
        // 2. char cnt == 2. "a2"=> "a"
        List<Integer> list = new ArrayList<>();
        int len = s.length();
        int[] arr = new int[26];
        int st =0;

        int sum= 0 ;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            sum++;

            if(i+1<len && s.charAt(i+1)!=ch){
                list.add(sum);
                sum=0;
            }

            if(i==len-1 && sum!=0){
                list.add(sum);
            }
        }



        for(int i=0; i<list.size() && k>0; i++){

            if(list.get(i)==2){
                k--;
                list.set(i, 1);
            }

            if(k==0) break;

            if(list.get(i)==1){
                k--;
                list.set(i, 0);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( // idx, cnt
            (a,b)-> a[1]-b[1]
        );

        for(int i=0; i<list.size(); i++){
            if(list.get(i)!=0) pq.offer(new int[]{i, list.get(i)});
        }

        while(k>0 && !pq.isEmpty()){
            int[] p = pq.poll();
            int idx = p[0];
            int cnt = p[1];

            if(k>=cnt){
                k-=cnt;
                list.set(idx, 0);
            }else{
                list.set(idx, list.get(idx)-k);
                k=0;
            }
        }

        System.out.println(list);

        int res = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)>2){
                // System.out.println(String.valueOf(list.get(i)).length());
                res+=String.valueOf(list.get(i)).length()+1;
            }
                
            else if(list.get(i)==2){
                res += 2;
            }else if(list.get(i)==1)
                res += 1;
        }

        return res;

    }
}