// https://leetcode.com/problems/couples-holding-hands

class Solution {

    int[] parent;

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        parent = new int[len];
        
        for(int i=0; i<len; i+=2){
            parent[i]=i;
            parent[i+1]=i;
        }
        int cnt= 0;
        for(int i=0; i<len; i+=2){

            int a = row[i];
            int b = row[i+1];
            if(union(a, b))
                cnt++;
        }

        return cnt;


        // Map<Integer, Integer> map =new HashMap<>();

        // for(int i=0; i<len; i++){  
        //     map.put(parent[i], map.getOrDefault(parent[i],0)+1);
        // }

        // int res = 0;
        // for(int v: map.values()){
        //     res+=v/2-1;
        // }

        // return res;

    }

    private int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return false;

        if(a<b)
            parent[b] = a;
        else
            parent[a] = b;

        return true;
    }
}