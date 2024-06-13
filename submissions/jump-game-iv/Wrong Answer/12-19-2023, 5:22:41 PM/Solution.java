// https://leetcode.com/problems/jump-game-iv

class Solution {
    public int minJumps(int[] arr) {
        int len = arr.length;


        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.put(arr[i], i);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] seen = new boolean[len];

        int step = 0;
        while(!q.isEmpty()){
          
            int siz = q.size();
            for(int cnt=0; cnt<siz; cnt++){
                int i = q.poll();

                if(i==len-1)
                    return step;

                if(map.containsKey(arr[i]) && map.get(arr[i])>i){
                    if(seen[map.get(arr[i])]==false){
                        q.offer(map.get(arr[i]));
                        seen[map.get(arr[i])]=true;
                        continue;
                    }
                }else{

                    if(i-1>0 && seen[i-1]==false){
                        q.offer(i-1);
                        seen[i-1]=true;
                    }

                    if(i+1< len && seen[i+1]==false){
                        q.offer(i+1);
                        seen[i+1]=true;
                    }
                }
            }
              step++;
        }

        return -1;

    }
}