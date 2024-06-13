// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends

class Solution {
    int[] parent;
    public int earliestAcq(int[][] logs, int n) {
        parent = new int[n];
        int cnt= 1 ;

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
            

        Arrays.sort(logs, (a,b)-> a[0]-b[0]);
        int res = -1;
        for(int[] log : logs){
            int time = log[0];
            int a = log[1];
            int b = log[2];

            if(union(a, b)){
                cnt++;
                res = time;
            }
        }
        System.out.println(cnt);
        System.out.println(res);
        return cnt==n ? res : -1;




    }

    private boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return false;
        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }

        return true;
        
    }

    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
}