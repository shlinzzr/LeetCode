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

        for(int i=0; i<len; i+=2){
            int a = row[i];
            int b = row[i+1];

            if(find(a)!=find(b)){
                union(a, b);
            }
        }

        int[] cnt = new int[len];
        for(int i=0; i<len; i++){  
            cnt[parent[i]]++;
        }

        int res = 0;
        for(int i=0; i<len ; i++){
            if(cnt[i]>2)
                res += cnt[i]/2-1;
        }

        return res;

    }

    private int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return ;

        parent[b] = a;
    }
}